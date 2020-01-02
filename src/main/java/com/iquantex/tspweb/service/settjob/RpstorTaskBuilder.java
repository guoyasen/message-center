package com.iquantex.tspweb.service.settjob;

import com.iquantex.tspweb.dao.java.RpstorSettChildtaskMapper;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RpstorTaskBuilder extends BaseBuilder {
    /**
     * 重启
     */
    public static final int DOTYPE_RE = 0;
    /**
     * 跳过
     */
    public static final int DOTYPE_NEXT = 1;

    @Autowired
    private RpstorSettJobService eodSettJobService;
    @Autowired
    private RpstorSettChildtaskMapper childTaskMapper;

    /**
     * 开始任务
     *
     * @param jobId
     * @param taskId
     * @param childTaskId
     * @param doType
     */
    public void startTask(int jobId, int taskId, int childTaskId, int doType) {

        // 如果是执行跳过，则判断是否能跳过
        if (doType == DOTYPE_NEXT) {

            canSkip(jobId, taskId, childTaskId);
        }

        checkStartJob(jobId);

        List<RpstorSettChildtask> childtasks = childTaskMapper.selectByJobAsc(jobId);

        if (RpstorTaskBuilder.DOTYPE_RE == doType) {
            childtasks.stream()
                    .filter(task -> (taskId == task.getTaskId() && childTaskId <= task.getChildtaskId()) || taskId < task.getTaskId())
                    .filter(task -> RpstorSettChildtask.c_status_warning.equals(execuChildTask(task)))
                    .findFirst();
        }

        if (RpstorTaskBuilder.DOTYPE_NEXT == doType) {

            // 将跳过步骤置为已完成
            childtasks.stream()
                    .filter(childtask -> taskId == childtask.getTaskId() && childTaskId == childtask.getChildtaskId()).collect(Collectors.toList())
                    .forEach(childtask -> {
                        childtask.setStatus(RpstorSettChildtask.c_status_done);
                        childTaskMapper.updateByPrimaryKeySelective(childtask);
                        updateTaskJobStatus(jobId, taskId, childTaskId);
                        RpstorLoggerPlus.taskListInfoMsg(jobId, eodSettJobService.getJobTree(jobId));

                    });

            // 后续子任务依次执行
            childtasks.stream()
                    .filter(task -> (taskId == task.getTaskId() && childTaskId < task.getChildtaskId()) || taskId < task.getTaskId())
                    .filter(task ->
                    {
                        int status = execuChildTask(task);
                        if (RpstorSettChildtask.c_status_warning.equals(status)||RpstorSettChildtask.c_status_finish_stop.equals(status)){
                            return true;
                        }else {
                            return false;
                        }
                    })
                    .findFirst();
        }

        RpstorLoggerPlus.processViewInfoMsg(jobId,null);

        //resetAllJobTree();
        exitSystem(jobId);

    }
}
