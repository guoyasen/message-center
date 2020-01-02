package com.iquantex.tspweb.service.settjob;

import com.iquantex.tspweb.dao.java.RpstorSettChildtaskMapper;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RpstorChildTaskRepeatBuilder extends BaseBuilder {
    protected static Logger LOG = LoggerFactory.getLogger(RpstorChildTaskRepeatBuilder.class);
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
     */
    public void repeatClildTask(int jobId, int taskId, int childTaskId) {

        RpstorSettChildtask childTask = childTaskMapper.selectOneBy(RpstorSettChildtask.f_jobId, jobId, RpstorSettChildtask.f_taskId, taskId, RpstorSettChildtask.f_childtaskId, childTaskId);
        if (childTask == null) {
            throw new RuntimeException(String.format("子任务不存在，job:%d, task:%d, childtask:%d", jobId, taskId, childTaskId));
        }

        // 保存子任务状态
        int childTaskStatus = childTask.getStatus();

        // 保存以前job状态
        int jobStatus = eodSettJobService.getJob(jobId).getStatus();

        // 检查
        checkRepeatChildTask(jobId, taskId, childTaskId);

        try {
            execuChildTask(childTask);
        } finally {

            // 恢复子任务状态
            childTask.setStatus(childTaskStatus);
            childTask.setLastTime(new Date());
            settChildtaskMapper.updateByPrimaryKey(childTask);

            // 恢复job状态
            updateJobStatus(jobId, jobStatus);
            RpstorLoggerPlus.processViewInfoMsg(jobId, null);
        }
    }
}
