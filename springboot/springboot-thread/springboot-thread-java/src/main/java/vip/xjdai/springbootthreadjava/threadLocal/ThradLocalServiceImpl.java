package vip.xjdai.springbootthreadjava.threadLocal;

import org.springframework.stereotype.Service;


@Service
public class ThradLocalServiceImpl implements ThradLocalService
{
    @Override
    public void setUser()
    {
        User user = ThreadLocalUtils.get();
        System.out.println(user.getThread());
        new ThreadLocal<>();

    }
}
