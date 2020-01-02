package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.param.settjob.UpdateJobInParam;
import com.iquantex.tspweb.service.settjob.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author bluce
 */
@RestController
@RequestMapping("/api/v2/sett_job")
public class RpstorSettJobController extends BaseController {

    @Autowired
    private RpstorSettJobService service;

    @Autowired
    private RpstorJobBuilder eodJobBuilder;

    @Autowired
    private RpstorTaskBuilder taskBuilder;

    @Autowired
    private RpstorChildTaskRepeatBuilder taskRepeatBuilder;

    @Autowired
    private RpstorJobBuilder rpstorJobBuilder;

    @PutMapping("/{jobId}/reset")
    public String resetStatus(@PathVariable("jobId") Integer jobId) {
        rpstorJobBuilder.resetJobTree(jobId);
        return successReturn();
    }

    /**
     * 修改工作状态
     *
     * @return
     */
    @PutMapping("/update")
    public String update(@RequestBody UpdateJobInParam param) {
        service.update(param);
        return successReturn();
    }

    /**
     * 获取状态树
     * JOB
     * -TASK
     * -CHILD TASK
     *
     * @param jobId
     * @return
     */
    @GetMapping("{jobId}/tree")
    public String getJobTree(@PathVariable int jobId) {
        return successReturn(service.getJobTree(jobId));
    }

    /**
     * 开始任务
     *
     * @param jobId
     * @return
     */
    @PostMapping("{jobId}")
    public String startJob(@PathVariable int jobId) {
        eodJobBuilder.startJob(jobId);
        return successReturn();
    }

    /**
     * 重新处理某个子任务
     *
     * @param jobId
     * @param taskId
     * @return
     */
    @PostMapping("repeat/{jobId}/{taskId}/{childTask}")
    public String repeatChildTask(@PathVariable int jobId, @PathVariable int taskId, @PathVariable int childTask) {
        taskBuilder.startTask(jobId, taskId, childTask, RpstorTaskBuilder.DOTYPE_RE);
        return successReturn();
    }

    /**
     * 处理下个子任务
     *
     * @param jobId
     * @param taskId
     * @return
     */
    @PostMapping("next/{jobId}/{taskId}/{childTask}")
    public String nextChildTask(@PathVariable int jobId, @PathVariable int taskId, @PathVariable int childTask) {
        taskBuilder.startTask(jobId, taskId, childTask, RpstorTaskBuilder.DOTYPE_NEXT);
        return successReturn();
    }

    /**
     * 单独处理某个子任务
     *
     * @param jobId
     * @param taskId
     * @return
     */
    @PostMapping("childtask/{jobId}/{taskId}/{childTask}")
    public String curChildTask(@PathVariable int jobId, @PathVariable int taskId, @PathVariable int childTask) {
        taskRepeatBuilder.repeatClildTask(jobId, taskId, childTask);
        return successReturn();
    }

}
