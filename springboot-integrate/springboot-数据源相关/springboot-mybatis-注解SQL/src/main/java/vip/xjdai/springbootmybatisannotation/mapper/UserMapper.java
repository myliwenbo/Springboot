package vip.xjdai.springbootmybatisannotation.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //Result 修饰返回的结果集，参考 http://www.mybatis.org/mybatis-3/zh/java-api.html
    @Select("SELECT * FROM users")
    @Results({@Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class), @Result(property = "nickName", column = "nick_name")})
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({@Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class), @Result(property = "nickName", column = "nick_name")})
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}
