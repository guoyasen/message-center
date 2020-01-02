package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.RpstorSettTask;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RpstorSettTaskMapper extends Mapper<RpstorSettTask> {
    /**
     * 查找某个工作id下的所有子任务，按照task_id的升序排列
     *
     * @param jobId
     * @return
     */
    @Select("select * from " + RpstorSettTask.TABLE + " where job_id = #{jobId} order by task_id")
    List<RpstorSettTask> selectAllAsc(@Param("jobId") int jobId);

    /**
     * 重置状态
     */
    @Update("update " + RpstorSettTask.TABLE + " SET STATUS = 0  where job_id = #{jobId}")
    void resetStatus(int jobId);
}