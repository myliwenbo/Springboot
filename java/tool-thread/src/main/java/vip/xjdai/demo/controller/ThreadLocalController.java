package vip.xjdai.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.demo.threadLocal.ThreadLocalUtils;
import vip.xjdai.demo.threadLocal.User;

@RestController
@RequestMapping("test")
public class ThreadLocalController
{
    @Autowired
    private ThradLocalService thradLocalService;


    /*
     * 1. 使用工具并发访问 100个线程
     * 2. 如何知道当前线程获取的数据是准确的呢?
     * 3. 如何知道当前线程获取的数据在后面获取的数据也是正确的呢?暂时没想到方法
     *
     */

    /**
     * 测试并发线程的ThreadLocal
     */
    @RequestMapping("test")
    public void Test(@RequestBody User user){
        ThreadLocalUtils.set(user);
        thradLocalService.setUser();
    }


}
