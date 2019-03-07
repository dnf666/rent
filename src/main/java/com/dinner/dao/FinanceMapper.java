package com.dinner.dao;

import com.dinner.model.Finance;
import com.dinner.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FinanceMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);

    List<Finance> selectByDateDesc(@Param("pager") Pager<Finance> pager,@Param("endTime") Date endTime, @Param("startTime") Date startTime);

    int countByDateDesc(@Param("endTime")Date endTime,@Param("startTime") Date startTime);

}
