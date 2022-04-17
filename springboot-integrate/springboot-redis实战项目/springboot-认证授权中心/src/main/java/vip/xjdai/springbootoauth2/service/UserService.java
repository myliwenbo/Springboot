package vip.xjdai.springbootoauth2.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vip.xjdai.springbootcommons.model.dao.Diners;
import vip.xjdai.springbootcommons.model.domain.SignInIdentity;
import vip.xjdai.springbootcommons.utils.AssertUtil;
import vip.xjdai.springbootoauth2.mapper.DinersMapper;

import javax.annotation.Resource;

/**
 * 登录校验
 */
@Service
public class UserService implements UserDetailsService {

    @Resource
    private DinersMapper dinersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AssertUtil.isNotEmpty(username, "请输入用户名");
        LambdaQueryWrapper<Diners> objectQueryWrapper = new QueryWrapper<Diners>().lambda();
        objectQueryWrapper.eq(Diners::getUsername, username);
        Diners diners = dinersMapper.selectOne(objectQueryWrapper);
        if (diners == null) {
            throw new UsernameNotFoundException("用户名或密码错误，请重新输入");
        }
        // 初始化登录认证对象
        SignInIdentity signInIdentity = new SignInIdentity();
        // 拷贝属性
        BeanUtils.copyProperties(diners, signInIdentity);
        return signInIdentity;
    }

}
