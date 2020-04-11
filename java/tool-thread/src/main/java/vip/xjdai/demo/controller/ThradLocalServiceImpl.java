package vip.xjdai.demo.controller;

import org.springframework.stereotype.Service;
import vip.xjdai.demo.threadLocal.ThreadLocalUtils;
import vip.xjdai.demo.threadLocal.User;

@Service
public class ThradLocalServiceImpl implements ThradLocalService
{
    @Override
    public void setUser()
    {
        User user = ThreadLocalUtils.get();
        System.out.println(user.getThread());

    }
}
