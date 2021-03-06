package com.dmd.mall.mapper;

import com.dmd.mall.model.domain.CoachApplyBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ChenYanbing
 * @title: CoachApplyMapper
 * @projectName dmd-master
 * @description: TODO 教练申请
 * @date 2019/9/1915:10
 */

public interface CoachApplyMapper {
    /**
     * 教练申请新增
     * @param coachApplyBean
     * @return
     */
    int addCoachApply(CoachApplyBean coachApplyBean);
}
