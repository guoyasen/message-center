package com.iquantex.tspweb.service.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gchaoxue on 2018/5/17
 *
 * RateLimiter
 */
public class RateLimiter {

    private static final Logger LOG = LoggerFactory.getLogger(RateLimiter.class);

    private static final long ONE_SEC_NANO = (long) 1e9;
    private static final long ONE_SEC_MILLIS = (long) 1e3;

    private String name;
    private Runnable workload;
    private Thread workThread;
    private boolean started;
    private long rate;
    private long timeout;

    public RateLimiter(long rate, long timeout, Runnable workload, String name) {
        this.rate = rate;
        this.timeout = timeout * ONE_SEC_MILLIS;
        this.workload = workload;
        this.name = name;
    }

    public RateLimiter(long rate, long timeout, Runnable workload) {
        this(rate, timeout, workload, "unnamed work load");
    }

    public void stop() {
        started = false;
    }

    public boolean start() {
        if (rate <= 0) {
            LOG.error("tps value cannot be less than 1");
            return false;
        }
        // start working thread
        workThread = new Thread( ()-> {
            long rateControlTimeGap = ONE_SEC_NANO;
            long rateControlCounter = 0;
            long rateControlCountPerGap = rate;
            long rateControlDelayTimer;
            long rateControlDelay = rateControlTimeGap / rateControlCountPerGap * 4 / 5;
            long rateControlTimer = System.nanoTime();
            long timeoutTimer = System.currentTimeMillis();

            started = true;
            while (started && System.currentTimeMillis() - timeoutTimer < timeout) {
                if (System.nanoTime() - rateControlTimer < rateControlTimeGap) {
                    if (rateControlCounter < rateControlCountPerGap) {
                        // workload
                        workload.run();

                        rateControlCounter++;
                        rateControlDelayTimer = System.nanoTime();
                        while(System.nanoTime() - rateControlDelayTimer < rateControlDelay);
                    }
                    else {
                        rateControlTimer = rateControlTimer + rateControlTimeGap;
                        rateControlCounter = 0;
                        while(System.nanoTime() < rateControlTimer);
                    }
                }
                else {
                    rateControlTimer = rateControlTimer + rateControlTimeGap;
                    rateControlCounter = 0;
                }
            }
            if (started) {
                LOG.info("rate limiter thread stop: name<{}> timeout: {}s", name, timeout);
            }
            else {
                LOG.info("rate limiter thread stop: name<{}> interrupted", name);
            }
            this.started = false;
        });

        workThread.start();
        LOG.info("rate limiter thread started: name<{}>", name);
        return true;
    }
}
