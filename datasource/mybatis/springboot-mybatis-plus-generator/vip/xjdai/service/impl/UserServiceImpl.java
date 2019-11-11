package vip.xjdai.service.impl;

import vip.xjdai.domain.UserEntity;
import vip.xjdai.mapper.UserMapper;
import vip.xjdai.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liwenbo
 * @since 2019-11-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
