package com.iquantex.tspweb.service.settjob.impl;

import com.iquantex.tspweb.dao.java.RpstorSettChildtaskMapper;
import com.iquantex.tspweb.dao.java.RpstorSettJobMapper;
import com.iquantex.tspweb.dao.java.RpstorSettTaskMapper;
import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.model.RpstorSettJob;
import com.iquantex.tspweb.model.RpstorSettTask;
import com.iquantex.tspweb.param.settjob.JobTree;
import com.iquantex.tspweb.param.settjob.UpdateJobInParam;
import com.iquantex.tspweb.service.settjob.RpstorSettJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author devin.chung
 * @date 2018/10/22
 */
@Service
@Slf4j
public class RpstorSettJobServiceImpl implements RpstorSettJobService {

    @Autowired
    private RpstorSettJobMapper mapper;
    @Autowired
    private RpstorSettTaskMapper taskMapper;
    @Autowired
    private RpstorSettChildtaskMapper childTaskMapper;

    @Override
    public RpstorSettJob getJob(Integer jobId) {
        return mapper.selectOneBy(RpstorSettJob.f_jobId, jobId);

    }

    /**
     * 判断settjob 是否为jobId的下一个job
     *
     * @param settJob
     * @param jobId
     * @return
     */
    private boolean checkNextNode(RpstorSettJob settJob, Integer jobId) {
        String preJobIdStr = settJob.getPreJobId();
        if (StringUtils.isEmpty(preJobIdStr)) {
            return false;
        }
        String jobids[] = preJobIdStr.split(",");

        List<String> jobList = Arrays.stream(jobids)
                .filter(str -> Integer.valueOf(str).equals(jobId))
                .collect(Collectors.toList());

        if (null != jobList && jobList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<JobTree> getJobTree(int jobId) {

        List<JobTree> jobTrees = new ArrayList<>();

        try {
            RpstorSettJob settJob = mapper.selectOneBy(RpstorSettJob.f_jobId, jobId);
            List<RpstorSettTask> settTasks = taskMapper.selectAllAsc(jobId);
            // 如果存在今天job工作已完成流水那么该job下所有任务都为已完成状态
            int jobStatus = settJob.getStatus();
            // 工作组装
            String treeJobId = "job" + jobId;
            JobTree jobTreeNode = parseJobTree(
                    treeJobId,
                    treeJobId,
                    jobId,
                    null,
                    null,
                    settJob.getJobName(),
                    jobStatus,
                    null,
                    null,
                    null,
                    null);
            jobTrees.add(jobTreeNode);

            for (RpstorSettTask settTask : settTasks) {

                int taskStatus = settTask.getStatus();
                // task组装
                List<RpstorSettChildtask> childtasks = childTaskMapper.selectByJobAndTaskAsc(jobId, settTask.getTaskId());
                String tid = "task" + settTask.getTaskId();


                JobTree taskTreeNode = parseJobTree(
                        tid,
                        treeJobId,
                        jobId,
                        settTask.getTaskId(),
                        null,
                        settTask.getTaskName(),
                        taskStatus,
                        null,
                        null,
                        null,
                        null);
                jobTrees.add(taskTreeNode);

                for (RpstorSettChildtask childtask : childtasks) {

                    int childTaskStatus = childtask.getStatus();
                    // 子任务组装
                    String cid = "ctask" + childtask.getChildtaskId();
                    JobTree cTaskTreeNode = parseJobTree(
                            cid,
                            tid,
                            jobId,
                            childtask.getTaskId(),
                            childtask.getChildtaskId(),
                            childtask.getChildtaskName(),
                            childTaskStatus,
                            childtask.getLastStatus(),
                            childtask.getLastTime(),
                            childtask.getIfRepeat(),
                            childtask.getIfSkip());
                    jobTrees.add(cTaskTreeNode);
                }
            }
        } catch (Exception e) {
            //log.error("获取流程树结构失败<{}>",e.getMessage());
            throw new RuntimeException(String.format("获取流程树结构失败:jobId<%s>", jobId), e);
        }
        return jobTrees;
    }

//    @Override
//    public EodJobTreePublishEvent JobTreeEvent(int jobId) {
//
//        EodJobTreePublishEvent event = new EodJobTreePublishEvent();
//        List<EodJobTreeNodePublishEvent> nodePublishList = new ArrayList<>();
//        List<JobTree> jobTrees = getJobTree(jobId);
//        for (JobTree jobTree : jobTrees) {
//            EodJobTreeNodePublishEvent treeNode = new EodJobTreeNodePublishEvent();
//            treeNode.setId(jobTree.getId());
//            treeNode.setPId(jobTree.getpId());
//            treeNode.setJobId(jobId);
//            if (null != jobTree.getTaskId()) {
//                treeNode.setTaskId(jobTree.getTaskId());
//            }
//
//            if (null != jobTree.getChildTaskId()) {
//                treeNode.setChildTaskId(jobTree.getChildTaskId());
//            }
//            treeNode.setName(jobTree.getName());
//            treeNode.setStatus(jobTree.getStatus());
//
//            if (null != jobTree.getLastStatus()) {
//
//                treeNode.setLastStatus(jobTree.getLastStatus());
//            }
//
//            if (null != jobTree.getLastTime()) {
//
//                treeNode.setLastTime(jobTree.getLastTime().getTime());
//            }
//
//            nodePublishList.add(treeNode);
//        }
//        event.setJobId(jobId);
//        event.setJobTreeList(nodePublishList);
//        return event;
//    }

    @Override
    public void update(UpdateJobInParam param) {
        RpstorSettJob settJob = new RpstorSettJob();
        settJob.setJobId(param.getJobId());

        Integer ifRunning = param.getIfRunning();
        if (null != ifRunning) {
            settJob.setIfRunning(ifRunning);
        }

        Integer status = param.getStatus();
        if (null != status) {
            settJob.setStatus(status);
        }

        mapper.updateByPrimaryKeySelective(settJob);
    }

    /**
     * 将jobId、taskI和childTaskId以 ‘-’拼接
     *
     * @param args 不限制参数
     * @return 如“1-1-1”
     */
    private String jointId(int... args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]);
            if ((args.length - 1) != i) {
                builder.append("-");
            }
        }
        return builder.toString();
    }

    /**
     * 生成树节点对象
     *
     * @param id
     * @param pId
     * @param jobId
     * @param taskId
     * @param childTaskId
     * @param name
     * @param status
     * @param ifRepeat
     * @param ifSkip
     * @return
     */
    private JobTree parseJobTree(String id, String pId, Integer jobId, Integer taskId, Integer childTaskId, String name, int status, Integer lastStatus, Date lastTime, Integer ifRepeat, Integer ifSkip) {
        JobTree tree = new JobTree();
        tree.setId(id);
        tree.setpId(pId);
        tree.setJobId(jobId);
        tree.setTaskId(taskId);
        tree.setChildTaskId(childTaskId);
        tree.setName(name);
        tree.setStatus(status);
        if (null != lastStatus) {
            tree.setLastStatus(lastStatus);
        }
        if (null != lastTime) {
            tree.setLastTime(lastTime);
        }
        if (null != ifRepeat) {
            tree.setIfRepeat(ifRepeat);
        }
        if (null != ifSkip) {
            tree.setIfSkip(ifSkip);
        }
        return tree;
    }
}
