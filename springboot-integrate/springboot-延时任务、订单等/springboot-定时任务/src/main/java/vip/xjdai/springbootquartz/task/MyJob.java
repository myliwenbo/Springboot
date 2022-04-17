package vip.xjdai.springbootquartz.task;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyJob implements Job {

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        // 1. 获取当前时间-30分钟 = 订单超时时间
        // 2. 去数据做判断，订单时间<=订单超时时间
        // 3. 订单未支付==超时
        // 4. 删除支付相关信息
        // 5. 短信提示~~~
        System.out.println("要去数据库扫描啦。。。");
    }

    public static void main(String[] args) throws Exception {
        // 创建任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1").build();
        // 创建触发器 每3秒钟执行一次
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group3")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(3).repeatForever())
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        // 将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);
        // 调度器开始调度任务
        scheduler.start();

    }

}