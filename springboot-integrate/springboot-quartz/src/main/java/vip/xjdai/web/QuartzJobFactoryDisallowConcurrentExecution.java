package vip.xjdai.web;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import vip.xjdai.TaskUtils;
import vip.xjdai.web.domain.ScheduleJob;

/**
 * 
 * @Description: 若一个方法一次执行不完下次轮转时则等待该方法执行完后才执行下一次操作
 * @author chenjianlin
 */
//禁止并发执行多个相同定义的Job
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap()
            .get("scheduleJob");
        TaskUtils.invokMethod(scheduleJob);

    }
}