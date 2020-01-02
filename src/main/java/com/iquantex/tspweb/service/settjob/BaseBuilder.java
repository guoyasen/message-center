package com.iquantex.tspweb.service.settjob;

import com.iquantex.tspweb.dao.java.RpstorSettChildtaskMapper;
import com.iquantex.tspweb.dao.java.RpstorSettJobMapper;
import com.iquantex.tspweb.dao.java.RpstorSettTaskMapper;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.model.RpstorSettJob;
import com.iquantex.tspweb.model.RpstorSettTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bluce
 * Date 2017/9/15.
 */
public abstract class BaseBuilder {

    @Autowired
    protected RpstorSettChildtaskMapper settChildtaskMapper;
    @Autowired
    private RpstorSettJobMapper settJobMapper;
    @Autowired
    private RpstorSettJobService settJobService;
    @Autowired
    private RpstorSettTaskMapper settTaskMapper;
    @Autowired
    ApplicationContext applicationContext;

    /**
     * check
     *
     * @param jobId
     * @return
     */
    public synchronized void checkStartJob(Integer jobId) {

        // 任务已在执行中（重复点击出现）
        RpstorSettJob settJob = settJobMapper.selectOneBy(RpstorSettJob.f_jobId, jobId);

        if (RpstorSettJob.c_status_running.equals(settJob.getStatus())) {
            RpstorLoggerPlus.errorWithPub(jobId, new RuntimeException(String.format("当前流程的状态非法，不能开始流程. 流程状态：%s", RpstorSettJob.c_status_running.equals(settJob.getStatus()) ? "进行中" : "已完成")));
        }

        updateJobStatus(jobId, RpstorSettJob.c_status_running);
        RpstorLoggerPlus.processViewInfoMsg(jobId, null);

    }


    /**
     * 检测某个子任务是否能够重启
     *
     * @param jobId
     * @return
     */
    public synchronized void checkRepeatChildTask(int jobId, int taskId, int childTaskId) {

        RpstorSettJob settJob = settJobMapper.selectOneBy(RpstorSettJob.f_jobId, jobId);
        if (RpstorSettJob.c_status_running.equals(settJob.getStatus())) {
            RpstorLoggerPlus.errorWithPub(jobId, new RuntimeException(String.format("当前流程的状态非法，不能开始该流程子任务. 流程状态：进行中")));
        }

        RpstorSettChildtask childtask = settChildtaskMapper.selectOneBy(RpstorSettChildtask.f_jobId, jobId, RpstorSettChildtask.f_taskId, taskId, RpstorSettChildtask.f_childtaskId, childTaskId);

        if (!RpstorSettChildtask.c_ifRepeat_yes.equals(childtask.getIfRepeat())) {
            RpstorLoggerPlus.errorWithPub(jobId, new RuntimeException("该子任务不允许重做"));
        }

        if (!(RpstorSettChildtask.c_status_unstart.equals(childtask.getStatus()) || RpstorSettChildtask.c_status_done.equals(childtask.getStatus()))) {
            RpstorLoggerPlus.errorWithPub(jobId, new RuntimeException(String.format("当前子任务状态非法. 子任务状态：%s", RpstorSettJob.c_status_running.equals(childtask.getStatus()) ? "进行中" : RpstorSettJob.c_status_error.equals(childtask.getStatus()) ? "异常" : "警告")));
        }

        updateJobStatus(jobId, RpstorSettChildtask.c_status_running);
        RpstorLoggerPlus.processViewInfoMsg(jobId, null);

    }

    /**
     * 重置流程导图工作树状态
     * 如果所有任务都已经处理完成则重置流程状态
     */
    public void resetAllJobTree() {

        List<RpstorSettJob> eodSettJobList = settJobMapper.selectBy(RpstorSettJob.f_isProcessJob, RpstorSettJob.c_isProcessJob_yes, RpstorSettJob.f_ifRunning, RpstorSettJob.c_ifRunning_yes);

        List<RpstorSettJob> unDonedJobList = eodSettJobList.stream().filter(settJob -> !RpstorSettJob.c_status_done.equals(settJob.getStatus())).collect(Collectors.toList());

        if (unDonedJobList.isEmpty()) {

            eodSettJobList.stream().forEach(settJob -> resetJobTree(settJob.getJobId()));
        }
    }

    /**
     * 重置某个树状态
     *
     * @param jobId
     */
    public void resetJobTree(int jobId) {
        settJobMapper.resetStatus(jobId);
        settTaskMapper.resetStatus(jobId);
        settChildtaskMapper.resetStatus(jobId);
    }

    /**
     * 重置某个树状态
     *
     * @param jobId
     */
    public void resetTaskAndChild(int jobId) {
        settTaskMapper.resetStatus(jobId);
        settChildtaskMapper.resetStatus(jobId);
        RpstorLoggerPlus.taskListInfoMsg(jobId, settJobService.getJobTree(jobId));

    }

    /**
     * 退出系统
     *
     * @param jobId
     */
    public void exitSystem(int jobId) {

        RpstorSettJob settJob = settJobMapper.selectOneBy(RpstorSettJob.f_jobId, jobId, RpstorSettJob.f_ifExitSystem, RpstorSettJob.c_ifExitSystem_yes, RpstorSettJob.f_status, RpstorSettJob.c_status_done);
        if (null != settJob) {
            RpstorLoggerPlus.pubUpgradeMsgEvent(settJob.getJobName());
        }

    }

    /**
     * 跳过子任务的提前判断
     *
     * @param jobId
     * @param taskId
     * @param childTaskId
     */
    public void canSkip(int jobId, int taskId, int childTaskId) {

        RpstorSettChildtask childtask = settChildtaskMapper.selectOneBy(RpstorSettChildtask.f_jobId, jobId, RpstorSettChildtask.f_taskId, taskId, RpstorSettChildtask.f_childtaskId, childTaskId);

        //子任务状态为完成终止中时，不需要检查是否能跳过
        if (!RpstorSettChildtask.c_status_finish_stop.equals(childtask.getStatus())){
            if (RpstorSettChildtask.c_ifSkip_no.equals(childtask.getIfSkip())) {
                RpstorLoggerPlus.errorWithPub(jobId, String.format("<%s>不可以跳过,必须执行！", childtask.getChildtaskName()));
            }
        }
    }

    /**
     * 发生异常更改job,task，childTask 状态
     *
     * @param jobId
     * @param taskId
     * @param childTaskId
     */
    public void updateStatus(int jobId, int taskId, int childTaskId, int status) {

        RpstorSettChildtask childtask = settChildtaskMapper.selectOneBy(RpstorSettChildtask.f_jobId, jobId, RpstorSettChildtask.f_taskId, taskId, RpstorSettChildtask.f_childtaskId, childTaskId);
        childtask.setStatus(status);
        settChildtaskMapper.updateByPrimaryKeySelective(childtask);
        updateTaskStatus(jobId, taskId, status);
        updateJobStatus(jobId, status);

        RpstorLoggerPlus.taskListInfoMsg(jobId, settJobService.getJobTree(jobId));
        RpstorLoggerPlus.processViewInfoMsg(jobId, null);
    }

    /**
     * 修改job状态
     *
     * @param jobId
     * @param status
     */
    public void updateJobStatus(int jobId, int status) {

        RpstorSettJob settJob = settJobService.getJob(jobId);
        settJob.setStatus(status);
        settJobMapper.updateByPrimaryKeySelective(settJob);
    }

    /**
     * 修改任务状态
     *
     * @param jobId
     * @param taskId
     * @param status
     */
    public void updateTaskStatus(int jobId, int taskId, int status) {

        RpstorSettTask settTask = settTaskMapper.selectOneBy(RpstorSettTask.f_jobId, jobId, RpstorSettTask.f_taskId, taskId);
        settTask.setStatus(status);
        settTaskMapper.updateByPrimaryKeySelective(settTask);
    }

    /**
     * 更新任务状态
     *
     * @param jobId
     * @param taskId
     * @param childTaskId
     */
    public void updateTaskJobStatus(int jobId, int taskId, int childTaskId) {

        // 如果为最后一个子任务跳过则该task置为已完成
        List<RpstorSettChildtask> childTasks = settChildtaskMapper.selectByJobAsc(jobId);

        // 找不到可运行的比当前子任务序号排后的数据则表示该任务已经完成
        List<RpstorSettChildtask> undoChildTasksOfTask = childTasks
                .parallelStream()
                .filter(task -> task.getTaskId() == taskId && task.getChildtaskId() > childTaskId && !task.getStatus().equals(RpstorSettChildtask.c_status_done)).collect(Collectors.toList());

        List<RpstorSettChildtask> undochildTasksOfJob = childTasks.parallelStream()
                .filter(task -> ((task.getTaskId() == taskId && task.getChildtaskId() > childTaskId) || (task.getTaskId() > taskId) && !task.getStatus().equals(RpstorSettChildtask.c_status_done)))
                .collect(Collectors.toList());


        if (undoChildTasksOfTask.isEmpty()) {
            updateTaskStatus(jobId, taskId, RpstorSettJob.c_status_done);
        }

        if (undochildTasksOfJob.isEmpty()) {
            updateJobStatus(jobId, RpstorSettJob.c_status_done);
        }
    }

    /**
     * @param childtask
     * @return
     */
    public int execuChildTask(RpstorSettChildtask childtask) {

        int status = 0;
        updateStatus(childtask.getJobId(), childtask.getTaskId(), childtask.getChildtaskId(), RpstorSettJob.c_status_running);

        // 查找子任务
        try {

            RpstorSettChildTaskIBasic childTaskBasic = applicationContext.getBean(childtask.getChildtaskCls(), RpstorSettChildTaskIBasic.class);
            status = childTaskBasic.init(childtask.getJobId(), childtask.getTaskId(), childtask.getChildtaskId());

            if (RpstorSettChildtask.c_status_done.equals(status)) {

                updateTaskJobStatus(childtask.getJobId(),childtask.getTaskId(),childtask.getChildtaskId());

            }
            else if (RpstorSettChildtask.c_status_finish_stop.equals(status)){

                updateTaskStatus(childtask.getJobId(), childtask.getTaskId(), RpstorSettChildtask.c_status_finish_stop);
                updateJobStatus(childtask.getJobId(), RpstorSettJob.c_status_finish_stop);
            }
            else if (RpstorSettChildtask.c_status_warning.equals(status)) {

                updateTaskStatus(childtask.getJobId(), childtask.getTaskId(), RpstorSettChildtask.c_status_warning);
                updateJobStatus(childtask.getJobId(), RpstorSettJob.c_status_warning);
            }

        } catch (Exception e) {

            // 如果配置为遇到异常自动跳过则自动跳过
            if (RpstorSettChildtask.c_exceptSkip_yes.equals(childtask.getExceptSkip())) {

                updateStatus(childtask.getJobId(), childtask.getTaskId(), childtask.getChildtaskId(), RpstorSettJob.c_status_done);
                RpstorLoggerPlus.warnWithPub(childtask.getJobId(), "自动跳过异常步骤：" + childtask.getChildtaskName());

            } else {

                updateStatus(childtask.getJobId(), childtask.getTaskId(), childtask.getChildtaskId(), RpstorSettJob.c_status_error);
                RpstorLoggerPlus.errorWithPub(childtask.getJobId(), e, e.getMessage());

            }
        } finally {

            RpstorLoggerPlus.taskListInfoMsg(childtask.getJobId(), settJobService.getJobTree(childtask.getJobId()));
        }

        return status;
    }

}
