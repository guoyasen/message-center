package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.RpstorSettJob;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface RpstorSettJobMapper extends Mapper<RpstorSettJob> {
    /**
     * 根据jobId重置状态
     */
    @Update("update " + RpstorSettJob.TABLE + " SET STATUS = 0 where job_id = #{jobId}")
    void resetStatus(int jobId);
}