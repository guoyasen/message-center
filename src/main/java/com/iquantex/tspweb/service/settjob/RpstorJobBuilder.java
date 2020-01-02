package com.iquantex.tspweb.service.settjob;

import com.iquantex.tspweb.dao.java.RpstorSettChildtaskMapper;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RpstorJobBuilder extends BaseBuilder {

    @Autowired
    private RpstorSettChildtaskMapper settChildtaskMapper;
    @Autowired
    private RpstorSettJobService eodSettJobService;


    /**
     * 开始job
     *
     * @param jobId
     */
    public void startJob(int jobId) {

        // check if can start job
        checkStartJob(jobId);
        //重置job下的任务和子任务
        resetTaskAndChild(jobId);

        // 查询job下的任务 按照taskId升序排列
        List<RpstorSettChildtask> childtasks = settChildtaskMapper.selectByJobAsc(jobId);

        // 依次运行 第一个运行状态为警告 则停下来
        childtasks.stream().filter(task -> {
            int status = execuChildTask(task);
            if (RpstorSettChildtask.c_status_warning.equals(status)||RpstorSettChildtask.c_status_finish_stop.equals(status)){
                return true;
            }else {
                return false;
            }
        }).findFirst();

        RpstorLoggerPlus.processViewInfoMsg(jobId, null);

        //resetAllJobTree();
        exitSystem(jobId);
    }


}
