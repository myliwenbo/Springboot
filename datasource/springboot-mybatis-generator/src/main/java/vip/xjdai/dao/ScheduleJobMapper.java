package vip.xjdai.dao;

import cn.lwb.generator.mybatis.base.BaseMapper;
import vip.xjdai.domain.ScheduleJob;

public interface ScheduleJobMapper extends BaseMapper {
    int insert(ScheduleJob record);

    int insertSelective(ScheduleJob record);
}