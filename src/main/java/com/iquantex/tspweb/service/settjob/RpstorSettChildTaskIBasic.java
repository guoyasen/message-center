package com.iquantex.tspweb.service.settjob;

import com.iquantex.tspweb.dao.java.RpstorSettChildtaskMapper;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.param.settjob.JobTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * 日终childTask接口
 *
 * @author Jeff
 */
public abstract class RpstorSettChildTaskIBasic {

    protected static RpstorLoggerPlus LOG = null;
    protected static int jobID;
    @Autowired
    private RpstorSettChildtaskMapper settChildtaskMapper;
    @Autowired
    private RpstorSettJobService settJobService;
    @Autowired
    private ApplicationContext applicationContext;

    public abstract int execute();

    public void setLog(int jobID) {
        RpstorSettChildTaskIBasic.jobID = jobID;
        LOG = new RpstorLoggerPlus(jobID);
    }

    /**
     * 执行前函数
     */
    public void before() {

    }

    /**
     * 执行后回调函数
     */
    public void after(RpstorSettChildtask childtask, int status) {
        if (RpstorSettChildtask.c_finishStop_yes.equals(childtask.getFinishStop())) {
            //如果当前子任务配置为完成后中止任务
            status = RpstorSettChildtask.c_status_finish_stop;
        }
        childtask.setStatus(status);
    }

    /**
     * 初始进入方法
     *
     * @param jobId
     * @param taskId
     * @param childTaskId
     */
    public int init(int jobId, int taskId, int childTaskId) {

        RpstorSettChildtask childtask = settChildtaskMapper.selectOneBy(RpstorSettChildtask.f_jobId, jobId, RpstorSettChildtask.f_taskId, taskId, RpstorSettChildtask.f_childtaskId, childTaskId);
        // 初始化日志对象
        setLog(jobId);
        // 推送开始日志，将子任务置为开始
        startLog(childtask);
        before();

        // 直接使用 int status = execute(); 会导致子任务配置的事务无效
        RpstorSettChildTaskIBasic objet = applicationContext.getBean(childtask.getChildtaskCls(), RpstorSettChildTaskIBasic.class);
        int status = objet.execute();

        after(childtask,status);
        // 推送结束日志
        endLog(childtask);

        return childtask.getStatus();
    }

    /**
     * 开始日志
     *
     * @param childtask
     */
    private void startLog(RpstorSettChildtask childtask) {

        childtask.setStatus(RpstorSettChildtask.c_lastStatus_running);
        settChildtaskMapper.updateByPrimaryKeySelective(childtask);
        LOG.infoWithPub(String.format("子任务<%s>执行开始", childtask.getChildtaskName()));
        sentJobTree(childtask.getJobId());
    }

    /**
     * 结束日志
     *
     * @param childtask
     */
    private void endLog(RpstorSettChildtask childtask) {

        childtask.setLastTime(new Date());
        settChildtaskMapper.updateByPrimaryKeySelective(childtask);
        if (RpstorSettChildtask.c_status_warning.equals(childtask.getStatus())) {

            LOG.warnWithPub(String.format("子任务<%s>执行警告", childtask.getChildtaskName()));
        } else if (RpstorSettChildtask.c_status_finish_stop.equals(childtask.getStatus())){

            LOG.infoWithPub(String.format("子任务<%s>执行结束，进入暂停中。。。",childtask.getChildtaskName()));
        }else {

            LOG.infoWithPub(String.format("子任务<%s>执行结束", childtask.getChildtaskName()));
        }
        sentJobTree(childtask.getJobId());

    }

    /**
     * 发送流程树
     *
     * @param jobId
     */
    public void sentJobTree(int jobId) {

        List<JobTree> tree = settJobService.getJobTree(jobId);
        LOG.taskListInfoMsg(tree);
    }
}
