package com.iquantex.tspweb.service.settjob;

import com.alibaba.fastjson.JSONObject;
import com.iquantex.tspweb.common.DateUtil;
import com.iquantex.tspweb.service.settjob.event.EodMsgLogInfoEvent;
import com.iquantex.tspweb.service.settjob.event.UpgradeMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件发布
 *
 * @author devin.chung
 */
public class RpstorLoggerPlus {
    protected static Logger LOG = LoggerFactory.getLogger(RpstorLoggerPlus.class);

    // 工作类型
    private int jobId;

    public RpstorLoggerPlus(int jobId) {
        this.jobId = jobId;
    }

    /**
     * 带进度显示
     *
     * @param msg
     * @param num
     * @param length
     */
    public void infoWithPub(String msg, int num, int length) {
        if (length <= 50) {
            if (length <= 10) {
                infoWithPub(String.format("%s[%s/%s]", msg, num, length));
            } else {
                if (num % 10 == 0) {
                    infoWithPub(String.format("%s[%s/%s]", msg, num, length));
                } else if (num == length) {
                    infoWithPub(String.format("%s[%s/%s]", msg, num, length));
                }
            }
        } else if (length <= 1000) {
            if (num % 100 == 0) {
                infoWithPub(String.format("%s[%s/%s]", msg, num, length));
            } else if (num == length) {
                infoWithPub(String.format("%s[%s/%s]", msg, num, length));
            }
        } else if (length <= 10000) {
            if (num % 1000 == 0) {
                infoWithPub(String.format("%s[%s/%s]", msg, num, length));
            } else if (num == length) {
                infoWithPub(String.format("%s[%s/%s]", msg, num, length));
            }
        } else {
            if (num % 5000 == 0) {
                infoWithPub(String.format("%s[%s/%s]", msg, num, length));
            } else if (num == length) {
                infoWithPub(String.format("%s[%s/%s]", msg, num, length));
            }
        }
    }

    /**
     *
     * @param jobId
     * @param msg
     */
    public static void infoWithPub(int jobId, String msg) {
        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.infoWithPub(msg);
    }
    /**
     * info msg
     *
     * @param msg
     */
    public void infoWithPub(String msg) {
        LOG.info(msg);
        pubMsg(msg);
    }

    /**
     *
     * @param jobId
     * @param object
     */
    public static void infoMsg(int jobId, Object object) {
        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.infoMsg(object);
    }
    /**
     * info msg
     *
     * @param object
     */
    public void infoMsg(Object object) {
        try {

            LOG.info(JSONObject.toJSONString(object));
        } catch (Exception e) {
            LOG.info(object.toString());
        }
    }

    /**
     *
     * @param jobId
     * @param object
     */
    public static void taskListInfoMsg(int jobId, Object object) {
        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.taskListInfoMsg(object);
    }
    /**
     * 工作任务树结构
     *
     * @param object
     */
    public void taskListInfoMsg(Object object) {
        String msg = JSONObject.toJSONString(object);
        pubMsg(msg, EodMsgLogInfoEvent.c_msgType_normal, EodMsgLogInfoEvent.c_viewType_jobtreelist, EodMsgLogInfoEvent.c_contentFormat_json);
    }

    /**
     *
     * @param jobId
     * @param object
     */
    public static void processViewInfoMsg(int jobId, Object object) {
        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.processViewInfoMsg(object);
    }
    /**
     * 流程导图事件发送
     *
     * @param object
     */
    public void processViewInfoMsg(Object object) {

        String msg = JSONObject.toJSONString(object);
        pubMsg(msg, EodMsgLogInfoEvent.c_msgType_normal, EodMsgLogInfoEvent.c_viewType_processlist, EodMsgLogInfoEvent.c_contentFormat_json);
    }

    /**
     *
     * @param jobId
     * @param e
     */
    public static void errorWithPub(int jobId, RuntimeException e) {
        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.errorWithPub(e);
    }
    /**
     * @param e
     */
    public void errorWithPub(RuntimeException e) {
        LOG.error(e.getMessage(), e);
        pubMsg(e.getMessage(), EodMsgLogInfoEvent.c_msgType_except);
        throw e;
    }

    /**
     *
     * @param jobId
     * @param e
     */
    public static void errorWithPub(int jobId, Exception e, String msg) {
        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.errorWithPub(e, msg);
    }
    /**
     * @param e
     * @param msg
     */
    public void errorWithPub(Exception e, String msg) {
        LOG.error(e.getMessage(), e);
        pubMsg(e.getMessage(), EodMsgLogInfoEvent.c_msgType_except);
        throw new RuntimeException(msg, e);
    }

    /**
     *
     * @param jobId
     */
    public static void errorWithPub(int jobId, String msg) {
        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.errorWithPub(msg);
    }
    /**
     * error msg
     *
     * @param msg
     */
    public void errorWithPub(String msg) {
        LOG.error(msg);
        pubMsg(msg, EodMsgLogInfoEvent.c_msgType_except);
        throw new RuntimeException(msg);
    }

    /**
     * warn msg
     *@param jobId
     * @param msg
     */
    public static void warnWithPub(int jobId, String msg) {

        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.warnWithPub(msg);
    }
    /**
     * warn msg
     *
     * @param msg
     */
    public void warnWithPub(String msg) {

        pubMsg(msg, EodMsgLogInfoEvent.c_msgType_warning);
    }

    /**
     * warn msg
     *@param jobId
     * @param msg
     */
    public static void debugWithPub(int jobId,String msg) {

        RpstorLoggerPlus eodLoggerPlus = new RpstorLoggerPlus(jobId);
        eodLoggerPlus.debugWithPub(msg);
    }
    /**
     * debug msg
     *
     * @param msg
     */
    public void debugWithPub(String msg) {

        pubMsg(msg);
    }

    /**
     * 发送日志事件
     *
     * @param msg
     */
    private void pubMsg(String msg) {

        pubMsg(msg, EodMsgLogInfoEvent.c_msgType_normal, EodMsgLogInfoEvent.c_viewType_msg, EodMsgLogInfoEvent.c_contentFormat_String);
    }

    private void pubMsg(String msg, int msgType) {
        pubMsg(msg, msgType, EodMsgLogInfoEvent.c_viewType_msg, EodMsgLogInfoEvent.c_contentFormat_String);
    }

    /**
     * 发送日志事件
     *
     * @param msg
     */
    private void pubMsg(String msg, int msgType, Integer viewType, Integer contentFormat) {

        LOG.debug(msg);
//        String loginName = ThreadLocalUtil.getJwtData().getLoginName();
        String currentDateTime = DateUtil.getCurrentDateTime();
        if (EodMsgLogInfoEvent.c_viewType_msg == viewType) {

            msg = String.format("【%s】%s", currentDateTime, msg);
        }
        EodMsgLogInfoEvent event = new EodMsgLogInfoEvent();
        event.setJobId(this.jobId);
        event.setMsg(msg);
        event.setMsgType(msgType);
        viewType = null == viewType ? EodMsgLogInfoEvent.c_viewType_msg : viewType;
        contentFormat = null == contentFormat ? EodMsgLogInfoEvent.c_contentFormat_String : contentFormat;
        event.setViewType(viewType);
        event.setContentFormat(contentFormat);
        EventPublisher.send(event);
    }

    /**
     * 系统退出事件推送
     */
    public static void pubUpgradeMsgEvent(String msg) {
        UpgradeMessageEvent event = new UpgradeMessageEvent();
        event.setAction(UpgradeMessageEvent.c_action_stop);
        event.setCountdown(5L);
        event.setTitle(String.format("<%s> 执行完成，系统退出", msg));
        EventPublisher.send(event);
    }
}
