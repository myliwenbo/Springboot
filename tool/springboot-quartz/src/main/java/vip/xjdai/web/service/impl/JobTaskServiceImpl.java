package vip.xjdai.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vip.xjdai.web.BizException;
import vip.xjdai.web.QuartzUtils;
import vip.xjdai.web.domain.ScheduleJob;
import vip.xjdai.web.mapper.ScheduleJobMapper;
import vip.xjdai.web.service.JobTaskService;

@Service
public class JobTaskServiceImpl implements JobTaskService {

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @PostConstruct
    public void init() throws Exception {
        // 这里获取任务信息数据
        List<ScheduleJob> jobList = scheduleJobMapper.getAll();
        for (ScheduleJob job : jobList) {
            add(job);
        }
    }

    @Override
    public List<ScheduleJob> listAll() {
        return scheduleJobMapper.getAll();
    }

    @Override
    public ScheduleJob add(ScheduleJob scheduleJob) {
        //校验执行表达式
        QuartzUtils.getScheduleAndverifyCron(scheduleJob.getCronExpression());
        //校验class是否存在
        Object verifClass = QuartzUtils.verifClass(scheduleJob.getSpringId());
        //校验spring类是否存在
        QuartzUtils.verifyClassAndMethod(verifClass, scheduleJob.getMethodName());
        scheduleJobMapper.insert(scheduleJob);
        return scheduleJob;
    }

    /**
     * 从数据库中查询job
     */
    public ScheduleJob getTaskById(String jobId) {
        return scheduleJobMapper.selectByPrimaryKey(jobId);
    }

    @Override
    public ScheduleJob changeStatus(ScheduleJob scheduleJob) {
        ScheduleJob taskById = getTaskById(scheduleJob.getJobId());
        ScheduleJob update = new ScheduleJob();
        update.setJobStatus(scheduleJob.getJobStatus());
        if (update.getJobStatus().equals("1")) {
            try {
                QuartzUtils.addJobDetail(scheduleJob);
            } catch (SchedulerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (update.getJobStatus().equals("0")) {
            QuartzUtils.deleteJob(scheduleJob);
        } else {
            throw new BizException("传递参数错误");
        }
        scheduleJobMapper.updateByPrimaryKeySelective(update);
        return taskById;
    }

    /**
     * 获取所有计划中的任务列表
     * 
     * @return
     * @throws SchedulerException
     */
    public List<ScheduleJob> getAllJob() throws SchedulerException {
        Scheduler scheduler = QuartzUtils.getScheduler();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
        for (JobKey jobKey : jobKeys) {
            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
            for (Trigger trigger : triggers) {
                ScheduleJob job = new ScheduleJob();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setDescription("触发器:" + trigger.getKey());
                Trigger.TriggerState triggerState = scheduler
                    .getTriggerState(trigger.getKey());
                job.setJobStatus(triggerState.name());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
                jobList.add(job);
            }
        }
        return jobList;
    }

    /**
     * 所有正在运行的job
     * 
     * @return
     * @throws SchedulerException
     */
    public List<ScheduleJob> getRunningJob() throws SchedulerException {
        Scheduler scheduler = QuartzUtils.getScheduler();
        List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
        List<ScheduleJob> jobList = new ArrayList<ScheduleJob>(executingJobs.size());
        for (JobExecutionContext executingJob : executingJobs) {
            ScheduleJob job = new ScheduleJob();
            JobDetail jobDetail = executingJob.getJobDetail();
            JobKey jobKey = jobDetail.getKey();
            Trigger trigger = executingJob.getTrigger();
            job.setJobName(jobKey.getName());
            job.setJobGroup(jobKey.getGroup());
            job.setDescription("触发器:" + trigger.getKey());
            Trigger.TriggerState triggerState = scheduler
                .getTriggerState(trigger.getKey());
            job.setJobStatus(triggerState.name());
            if (trigger instanceof CronTrigger) {
                CronTrigger cronTrigger = (CronTrigger) trigger;
                String cronExpression = cronTrigger.getCronExpression();
                job.setCronExpression(cronExpression);
            }
            jobList.add(job);
        }
        return jobList;
    }

    /**
     * 更新job时间表达式
     * 
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void updateJobCron(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = QuartzUtils.getScheduler();

        TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(),
            scheduleJob.getJobGroup());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
            .cronSchedule(scheduleJob.getCronExpression());

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
            .withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }

    /**
     * 立即执行job
     * 
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void runAJobNow(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = QuartzUtils.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),
            scheduleJob.getJobGroup());
        scheduler.triggerJob(jobKey);
    }

    @Override
    public ScheduleJob updateCron(ScheduleJob scheduleJob) {

        return null;
    }

}
