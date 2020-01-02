package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.RpstorSettChildtask;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RpstorSettChildtaskMapper extends Mapper<RpstorSettChildtask> {
    @Select("select * from " + RpstorSettChildtask.TABLE + " where JOB_ID = #{jobId}  and TASK_ID = #{taskId} and IF_RUNING = 1 order by CHILDTASK_ID asc")
    List<RpstorSettChildtask> selectByJobAndTaskAsc(@Param("jobId") Integer jobId, @Param("taskId") Integer taskId);

    @Select("select * from " + RpstorSettChildtask.TABLE + " where JOB_ID = #{jobId} and IF_RUNING = 1 order by TASK_ID,CHILDTASK_ID asc")
    List<RpstorSettChildtask> selectByJobAsc(@Param("jobId") Integer jobId);

    /**
     * 重置状态
     */
    @Update("update " + RpstorSettChildtask.TABLE + " SET STATUS = 0  where job_id = #{jobId}")
    void resetStatus(int jobId);

    /**
     * 根据父级d获取子任务列表
     *
     * @param jobId  所属工作流程id
     * @param taskId 上级任务id
     * @return
     */
    @Select("select * from " + RpstorSettChildtask.TABLE + " where JOB_ID = #{jobId} and TASK_ID = #{taskId}")
    List<RpstorSettChildtask> listByParentId(@Param("jobId") Integer jobId, @Param("taskId") Integer taskId);
}