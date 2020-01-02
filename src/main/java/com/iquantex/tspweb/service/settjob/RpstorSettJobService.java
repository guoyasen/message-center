package com.iquantex.tspweb.service.settjob;

import com.iquantex.tspweb.model.RpstorSettJob;
import com.iquantex.tspweb.param.settjob.JobTree;
import com.iquantex.tspweb.param.settjob.UpdateJobInParam;

import java.util.List;

/**
 * @author bluce
 */
public interface RpstorSettJobService {

    /**
     * 获取任务信息
     *
     * @param jobId
     * @return
     */
    RpstorSettJob getJob(Integer jobId);

    /**
     * 获取清算流程树
     *
     * @param jobId
     * @return
     */
    List<JobTree> getJobTree(int jobId);

    /**
     * 流程树事件发布
     *
     * @param jobId
     * @return
     */
//    EodJobTreePublishEvent JobTreeEvent(int jobId);

    /**
     * 修改工作状态
     *
     * @param param 可调整字段：是否执行、状态
     */
    void update(UpdateJobInParam param);

}
