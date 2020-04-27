package vip.xjdai.web;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import vip.xjdai.TaskUtils;
import vip.xjdai.web.domain.ScheduleJob;

/**
 * 
 * @Description: 计划任务执行处 无状态
 * @author chenjianlin
 */
public class QuartzJobFactory implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap()
            .get("scheduleJob");
        TaskUtils.invokMethod(scheduleJob);
    }
}