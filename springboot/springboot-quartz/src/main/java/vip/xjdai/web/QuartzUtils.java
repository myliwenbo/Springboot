package vip.xjdai.web;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
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

public class QuartzUtils {

    //1.创建Scheduler的工厂
    private static SchedulerFactory gSchedulerFactory  = new StdSchedulerFactory();
    private static String           JOB_GROUP_NAME     = "MY_JOBGROUP_NAME";
    private static String           TRIGGER_GROUP_NAME = "MY_TRIGGERGROUP_NAME";

    public static Object verifClass(String springId) {
        Object obj = null;
        if (StringUtils.isNotBlank(springId)) {
            obj = SpringUtils.getBean(springId);
        } else {
            throw new BizException("未找到目标类！");
        }
        return obj;
    }

    /**
     * 校验方法和实体类
     * @param springId   springBeanID
     * @param methodName 方法名称
     * @return
     */
    public static Method verifyClassAndMethod(Object obj, String methodName) {
        Class<? extends Object> clazz = obj.getClass();
        try {
            Method method = clazz.getMethod(methodName);
            if (method == null) {
                throw new BizException("未找到目标方法！");
            }
            return method;
        } catch (NoSuchMethodException | SecurityException e) {
            throw new BizException("获取目标方法失败");
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
     * 创建一个任务，默认分组
     * @param <T>
     * @param jobName 任务名称
     * @param clazz   任务Class
     * @return
     */
    public static <T> JobDetail addJobDetail(String jobName, Class<? extends Job> clazz) {
        JobDetail addJobDetail = addJobDetail(jobName, JOB_GROUP_NAME, clazz);
        return addJobDetail;
    }

    /**
     * 创建一个任务，自定义分组
     * @param <T>
     * @param jobName 任务名称
     * @param clazz   任务Class
     * @return
     */
    public static JobDetail addJobDetail(String jobName, String jobGroup,
                                         Class<? extends Job> clazz) {
        // 1、创建一个JobDetail实例，指定Quartz
        JobBuilder newJob = JobBuilder.newJob(clazz);
        // 任务名，任务组
        newJob.withIdentity(jobName, jobGroup);
        // 部署创建任务执行类
        return newJob.build();
    }

    /**
     * Trigger 说明
     * <br/>
     * job执行的时间触发规则
     * @param triggerName  触发器名称
     * @param cron 触发器表达式
     * @return
     */
    public static Trigger getTrigger(String triggerName, String triggerGroup,
                                     String cron) {
        //获取触发器类型
        CronScheduleBuilder scheduleBuilder = QuartzUtils.getCronScheduleBuilder(cron);
        //触发器
        TriggerBuilder<Trigger> newTrigger = TriggerBuilder.newTrigger();
        //添加描述
        newTrigger.withDescription(null);
        //触发器名称  触发器分组
        newTrigger.withIdentity(triggerName, triggerGroup);
        //添加触发器
        newTrigger.withSchedule(scheduleBuilder);
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

    /**
     * 启动任务
     * @param triggerName   分组名称
     * @param expression    任务表达式
     * @param clazz         具体的任务
     * @throws Exception
     */
    public static <T> void startJob(String triggerName, String expression,
                                    Class<? extends Job> clazz) throws Exception {
        Trigger setTrigger = QuartzUtils.getTrigger(triggerName, TRIGGER_GROUP_NAME,
            expression);
        JobDetail jobDetail = addJobDetail(triggerName, clazz);
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
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
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
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
     * @param jobName
     */
    public static void removeJob(String jobName) {
        removeJob(jobName, JOB_GROUP_NAME, jobName, TRIGGER_GROUP_NAME);
    }

    public static Scheduler getScheduler() {
        try {
            Scheduler scheduler = gSchedulerFactory.getScheduler();
            return scheduler;
        } catch (SchedulerException e) {
            throw new BizException("获取调度器 失败");
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
     * @param time
     * @author qgw 
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
     * <pre>
     * 获取触发器类型
     * 按新的cron表达式构建一个新的触发器
     * </pre>
     * @param cron cronExpression 表达式
     * @return
     */
    public static CronScheduleBuilder getCronScheduleBuilder(String cron) {
        //添加触发器
        try {
            // 表达式任务触发器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            //次数触发器
            /*SimpleScheduleBuilder repeatHourlyForever = SimpleScheduleBuilder.repeatHourlyForever(5);*/
            return scheduleBuilder;
        } catch (Exception e) {
            throw new BizException("cron表达式有误，不能被解析！");

        }
    }

    public static void addJobDetail(ScheduleJob job) throws SchedulerException {
        //根据名称和分组获获取触发器
        Scheduler scheduler = getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(),
            job.getJobGroup());
        scheduler.getTrigger(triggerKey);
        //触发器
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // 不存在，创建一个
        if (null == trigger) {
            Class<? extends Job> clazz = ScheduleJob.CONCURRENT_IS
                .equals(job.getIsConcurrent()) ? QuartzJobFactory.class
                    : QuartzJobFactoryDisallowConcurrentExecution.class;
            //添加任务
            JobDetail jobDetail = addJobDetail(job.getJobName(), job.getJobGroup(),
                clazz);
            jobDetail.getJobDataMap().put("scheduleJob", job);
            QuartzUtils.getTrigger(job.getJobName(), job.getJobName(),
                job.getCronExpression());
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(job.getCronExpression());
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                .withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

}
