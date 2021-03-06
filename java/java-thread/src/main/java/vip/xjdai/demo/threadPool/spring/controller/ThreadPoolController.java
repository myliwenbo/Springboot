package vip.xjdai.demo.threadPool.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.demo.threadPool.spring.service.ThreadPoolService;

@RestController
@RequestMapping("threadPoolController")
public class ThreadPoolController
{

    @Autowired
    private ThreadPoolService threadPoolService;


    @RequestMapping("threadPoolController")
    public void testThreadPool(){
        System.out.println(Thread.currentThread().getName());
        threadPoolService.getThreadName();
        threadPoolService.executeThread();
    }


}
