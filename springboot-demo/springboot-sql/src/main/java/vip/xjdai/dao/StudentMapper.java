package vip.xjdai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import vip.xjdai.domain.Student;
import vip.xjdai.domain.StudentExample;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);
}