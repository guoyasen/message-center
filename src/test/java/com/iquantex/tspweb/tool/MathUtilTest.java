package com.iquantex.tspweb.tool;

import com.iquantex.tspweb.common.AuthData;
import com.iquantex.tspweb.common.MathUtil;
import com.iquantex.tspweb.model.TspRole;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class MathUtilTest {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());




    @Test
    public void test() {
        try {
            LOG.info(MathUtil.removeScientificNotation("125412464684665.48"));
            LOG.info(MathUtil.removeScientificNotation("1.95481488886E7"));
            LOG.info(MathUtil.removeScientificNotation("-1.95481488886E7"));
            LOG.info(MathUtil.removeScientificNotation("1528.48"));
            LOG.info(MathUtil.removeScientificNotation("0.45"));

            LOG.info("千分位");

            LOG.info(MathUtil.fmtMicrometer("125412464684665.48"));
            LOG.info(MathUtil.fmtMicrometer("1.954814888869E7"));
            LOG.info(MathUtil.fmtMicrometer("-1.95481488886E7"));
            LOG.info(MathUtil.fmtMicrometer("1528.48845441"));
            LOG.info(MathUtil.fmtMicrometer("0.45568"));

            LOG.info(MathUtil.fmtMicrometerNoDecimal("125412464684665.4011"));
            LOG.info(MathUtil.fmtMicrometerNoDecimal("125412464684665.9811"));
            LOG.info(MathUtil.fmtMicrometerNoDecimal("1.954814888869E7"));
            LOG.info(MathUtil.fmtMicrometerNoDecimal("-1.95481488886E7"));

            LOG.info(MathUtil.addSuffixPercent("0.004011111",0));
            LOG.info(MathUtil.addSuffixPercent("0.004011111",1));
            LOG.info(MathUtil.addSuffixPercent("0.004011111",2));
            LOG.info(MathUtil.addSuffixPercent("0.004011111",3));
            LOG.info(MathUtil.addSuffixPercent("0.004011111",4));

            LOG.info(MathUtil.addSuffixPercent("100.004011111",0));
            LOG.info(MathUtil.addSuffixPercent("100.004011111",1));
            LOG.info(MathUtil.addSuffixPercent("100.004011111",2));
            LOG.info(MathUtil.addSuffixPercent("100.004011111",3));
            LOG.info(MathUtil.addSuffixPercent("100.004011111",4));

            LOG.info(MathUtil.fmtNumber("10154566113",1000000,2));
            LOG.info(MathUtil.fmtNumber(null,1000000,2));

            LOG.info(MathUtil.fmtMicrometer("9875412.254","000"));



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Test
    public void test1(){
        AuthData.LightVOMid=9L;
        LOG.info(AuthData.LightVOMid.toString());
    }



}


