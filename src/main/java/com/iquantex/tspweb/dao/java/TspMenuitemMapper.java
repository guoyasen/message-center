package com.iquantex.tspweb.dao.java;

import com.iquantex.tspweb.model.TspMenuitem;
import com.iquantex.tspweb.param.TspMenuitemVO;
import com.iquantex.tspweb.param.TspWorkBenchVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TspMenuitemMapper extends Mapper<TspMenuitem> {
    List<TspMenuitemVO> selectMenuitemsById(@Param("sql") String sql);


    List<TspWorkBenchVO> selectWorkBenchById(@Param("sql") String sql);

    /**
     * 查询rule_id 不为空 或者 id=16（ETF基金实时指标监控）的菜单
     * @return
     */
    List<TspMenuitem> selectMenuitem();

    List<TspMenuitem> selectMenuitemById(@Param("id")  String id,@Param("userId") String userId);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Select("SELECT TSP_MENUITEMS_ID_SEQ.nextval FROM DUAL")
    long getNextID();


    int updateTspMenuitem(TspMenuitem tspMenuitem);

    int insertTspMentitem(TspMenuitem tspMenuitem);

    List<Map<String,String>> selectMenuToUser();
}