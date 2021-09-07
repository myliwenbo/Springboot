package vip.xjdai.mapper;

import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer tbUserId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer tbUserId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    //这个方式我自己加的
    List<TUser> selectAllUser();
}