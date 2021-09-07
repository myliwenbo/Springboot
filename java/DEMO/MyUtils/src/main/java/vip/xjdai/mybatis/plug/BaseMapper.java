package vip.xjdai.mybatis.plug;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 编写通用Mapper
 *
 * @param <T> 需要跟数据库做查询或者
 * @author lwb
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
