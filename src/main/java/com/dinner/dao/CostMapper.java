package com.dinner.dao;

import com.dinner.model.Cost;
import com.dinner.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);
    List<Cost> filter(@Param("pager") Pager<Cost> pager, @Param("cost") Cost cost);

    Integer countCostsByKeys(Cost cost);

    List<Cost> selectByDateDesc(@Param("pager") Pager<Cost> pager, @Param("endTime") Date endTime,@Param("startTime") Date startTime);
}
