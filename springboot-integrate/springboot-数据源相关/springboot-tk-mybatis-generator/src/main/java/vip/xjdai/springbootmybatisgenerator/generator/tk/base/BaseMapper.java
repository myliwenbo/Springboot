package vip.xjdai.springbootmybatisgenerator.generator.tk.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

//自定义父接口
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}