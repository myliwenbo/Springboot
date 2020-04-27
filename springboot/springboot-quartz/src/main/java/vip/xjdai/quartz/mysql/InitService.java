package vip.xjdai.quartz.mysql;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import vip.xjdai.web.QuartzAPI;

@Service
public class InitService {

    @PostConstruct
    public void init() throws Exception {
        //去数据库查询
        System.out.println("初始化执行");
        QuartzAPI.startJob("任务1", "0/2 * * * * ?", MyJob.class);
    }

}
