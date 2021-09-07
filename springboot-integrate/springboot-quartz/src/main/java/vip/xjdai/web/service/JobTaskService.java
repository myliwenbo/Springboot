package vip.xjdai.web.service;

import java.util.List;

import vip.xjdai.web.domain.ScheduleJob;

public interface JobTaskService {

    /**
     * 获取所有的定时任务
     * @return
     */
    List<ScheduleJob> listAll();

    /**
     * 添加定时任务
     * @param scheduleJob
     * @return 
     */
    ScheduleJob add(ScheduleJob scheduleJob);

    /**
     * 启动或者关闭任务
     * @param scheduleJob
     * @return
     */
    ScheduleJob changeStatus(ScheduleJob scheduleJob);

    /**
     * 更新任务表达式
     * @param scheduleJob
     * @return
     */
    ScheduleJob updateCron(ScheduleJob scheduleJob);

}
