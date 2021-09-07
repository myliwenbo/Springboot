package vip.xjdai.web;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import vip.xjdai.web.domain.ScheduleJob;

public class QuartzAPI {

    //1.创建Scheduler的工厂
    private static SchedulerFactory gSchedulerFactory  = new StdSchedulerFactory();
    private static String           JOB_GROUP_NAME     = "MY_JOBGROUP_NAME";
    private static String           TRIGGER_GROUP_NAME = "MY_TRIGGERGROUP_NAME";

    public static Scheduler getScheduler() {
        try {
            Scheduler scheduler = gSchedulerFactory.getScheduler();
            return scheduler;
        } catch (SchedulerException e) {
            throw new BizException("获取调度器 失败");
        }

    }

    /**
     * 创建一个任务默认分组
     * @param <T>
     * @param jobName 任务名称
     * @param clazz   任务Class
     * @return
     */
    public static <T> JobDetail addApi(String jobName, Class<? extends Job> clazz) {
        //创建一个JobDetail实例，指定Quartz
        JobBuilder newJob = JobBuilder.newJob(clazz);
        //job的描述
        newJob.withDescription(null);
        // 任务名，任务组
        newJob.withIdentity(jobName, JOB_GROUP_NAME);
        //不删除数据库数据
        newJob.storeDurably(true);
        // 部署创建任务执行类
        return newJob.build();
    }

    /**
     * 获取任务触发器
     * @param expression 任务表达式
     * @return 达式调任务触发器
     */
    public static CronScheduleBuilder getTriggerExpression(String expression) {
        // 表达式任务触发器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
            .cronSchedule(expression);
        //次数触发器
        /*SimpleScheduleBuilder repeatHourlyForever = SimpleScheduleBuilder.repeatHourlyForever(5);*/
        // 按新的cronExpression表达式构建一个新的trigger
        //添加触发器
        return scheduleBuilder;
    }

    /**
     * 设置定时器
     * @param triggerName
     * @param expression
     * @return
     */
    public static Trigger setTrigger(String triggerName, String expression) {
        //2.定时器
        TriggerBuilder<Trigger> newTrigger = TriggerBuilder.newTrigger();
        //添加描述
        newTrigger.withDescription(null);
        //触发器名称  触发器分组
        newTrigger.withIdentity(triggerName, TRIGGER_GROUP_NAME);
        //设置三秒启动
        Date date = new Date(System.currentTimeMillis() + 3 * 1000L);
        newTrigger.startAt(date);
        //默认当前时间启动
        newTrigger.startNow();
        CronScheduleBuilder triggerExpression = getTriggerExpression(expression);
        newTrigger.withSchedule(triggerExpression);
        //部署,创建Trigger
        return newTrigger.build();
    }

    /**
     * 启动任务
     * @param <T> 任务Class
     * @param triggerName   定时器名称
     * @param expression    执行表达式
     * @throws Exception
     */
    public static <T> void startJob(String triggerName, String expression,
                                    Class<? extends Job> clazz) throws Exception {
        Trigger setTrigger = setTrigger(triggerName, expression);
        JobDetail jobDetail = addApi(triggerName, clazz);
        //3.注册任务和定时器
        Scheduler sched = gSchedulerFactory.getScheduler();
        sched.scheduleJob(jobDetail, setTrigger);
        // 启动  
        if (!sched.isShutdown()) {
            sched.start();
        }
    }

    /**
     * 关闭所有定时任务 
     * @throws SchedulerException
     */
    public static void shutdownJobs() throws SchedulerException {
        Scheduler sched = gSchedulerFactory.getScheduler();
        //判断是否关闭了，如果没关闭在去关闭
        if (!sched.isShutdown()) {
            sched.shutdown();
        }

    }

    /**
     * 启动所有定时任务 
     * @throws SchedulerException
     */
    public static void startAllJobs() throws SchedulerException {
        Scheduler sched = gSchedulerFactory.getScheduler();
        sched.start();

    }

    /**
     * 暂停一个任务
     * @param jobName
     * @param jobGroupName
     */
    public static void pauseJob(String jobName,
                                String jobGroupName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobName);
        Scheduler sched = gSchedulerFactory.getScheduler();
        sched.pauseJob(jobKey);

    }

    /**
     * 恢复一个定时任务
     * @param jobName   
     * @param jobGroupName
     */
    public static void recoverJob(String jobName,
                                  String jobGroupName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobName);
        Scheduler sched = gSchedulerFactory.getScheduler();
        sched.resumeJob(jobKey);
    }

    /**
     * 删除一个任务
     * @param jobName 任务
     * @param jobGroupName 任务分组
     * @param triggerName 触发器名称
     * @param triggerGroupName 触发器分组
     */
    public static void removeJob(String jobName, String jobGroupName, String triggerName,
                                 String triggerGroupName) {
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
        JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            Trigger trigger = (Trigger) sched.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            sched.pauseTrigger(triggerKey);// 停止触发器  
            sched.unscheduleJob(triggerKey);// 移除触发器  
            sched.deleteJob(jobKey);// 删除任务
        } catch (Exception e) {
            throw new BizException("删除任务 失败");
        }
    }

    /**
     * 根据名称和分组删除任务
     * 
     * @param scheduleJob 
     * @throws SchedulerException
     */
    public static void deleteJob(ScheduleJob scheduleJob) {
        Scheduler scheduler = getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),
            scheduleJob.getJobGroup());
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            throw new BizException("删除任务 失败");
        }

    }

    /**
     * @Description: 修改一个任务的触发时间 
     * @param triggerName 
     * @param triggerGroupName
     * @param expression
     */
    public static void modifyJobTime(String triggerName, String triggerGroupName,
                                     String expression) {
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(expression)) {
                // trigger已存在，则更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                    .cronSchedule(expression);
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                    .withSchedule(scheduleBuilder).build();
                // 按新的trigger重新设置job执行
                sched.resumeTrigger(triggerKey);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取任务表达式，并且进行异常处理
     * 按新的cronExpression表达式构建一个新的trigger
     * @param cronExpression 表达式
     * @return
     */
    public static CronScheduleBuilder getScheduleAndverifyCron(String cronExpression) {
        //添加触发器
        try {
            // 表达式任务触发器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(cronExpression);
            //次数触发器
            /*SimpleScheduleBuilder repeatHourlyForever = SimpleScheduleBuilder.repeatHourlyForever(5);*/
            return scheduleBuilder;
        } catch (Exception e) {
            throw new BizException("cron表达式有误，不能被解析！");

        }
    }

}
