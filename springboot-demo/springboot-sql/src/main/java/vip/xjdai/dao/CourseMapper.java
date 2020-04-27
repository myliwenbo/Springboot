package vip.xjdai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import vip.xjdai.domain.Course;
import vip.xjdai.domain.CourseExample;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);
}