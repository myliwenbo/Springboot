package cn.lwb.quartz.servlet;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import cn.lwb.quartz.QuatzUtils;
import cn.lwb.quartz.job.MyJob;

@Service
public class InitService {

    @PostConstruct
    public void init() throws Exception {
        //去数据库查询
        System.out.println("初始化执行");
        QuatzUtils.startJob("任务1", "0/2 * * * * ?", MyJob.class);
    }

}
