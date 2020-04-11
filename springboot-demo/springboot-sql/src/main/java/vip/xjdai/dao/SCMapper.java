package vip.xjdai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import vip.xjdai.domain.SC;
import vip.xjdai.domain.SCExample;

public interface SCMapper {
    long countByExample(SCExample example);

    int deleteByExample(SCExample example);

    int insert(SC record);

    int insertSelective(SC record);

    List<SC> selectByExample(SCExample example);

    int updateByExampleSelective(@Param("record") SC record, @Param("example") SCExample example);

    int updateByExample(@Param("record") SC record, @Param("example") SCExample example);
}