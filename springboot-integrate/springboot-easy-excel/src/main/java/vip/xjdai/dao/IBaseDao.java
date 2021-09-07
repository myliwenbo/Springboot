package vip.xjdai.dao;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Title: IBaseDao
 * <p>
 * Description:
 *
 * @author 瞿宇龙
 * @version V1.0
 * @since 2020/2/20
 */
public interface IBaseDao<T> extends IService<T> {

    public List<T> listBatchByEntityList(List<T> data);


}
