package vip.xjdai.demo.threadPool.spring.service;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ThreadPoolServiceImpl implements ThreadPoolService
{
    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor;

    @Async("taskExecutor")
    @Override
    public void getThreadName()
    {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //单独执行
    @Override
    public void executeThread()
    {

    }

}
