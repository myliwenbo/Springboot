package vip.xjdai.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vip.xjdai.web.domain.ScheduleJob;
import vip.xjdai.web.service.JobTaskService;

@RestController
@RequestMapping("quartz")
public class QuartzController {

    @Autowired
    private JobTaskService jobTaskService;

    @RequestMapping("quaryAll")
    public List<ScheduleJob> queryAll() {
        List<ScheduleJob> list = jobTaskService.listAll();
        return list;
    }

    @RequestMapping("add")
    @ResponseBody
    public ScheduleJob taskList(ScheduleJob scheduleJob) {
        ScheduleJob restjob = jobTaskService.add(scheduleJob);
        return restjob;
    }

    @RequestMapping("changeJobStatus")
    @ResponseBody
    public ScheduleJob changeJobStatus(ScheduleJob scheduleJob) {
        ScheduleJob rest = jobTaskService.changeStatus(scheduleJob);
        return rest;

    }

    @RequestMapping("updateCron")
    @ResponseBody
    public ScheduleJob updateCron(ScheduleJob scheduleJob) {

        return jobTaskService.updateCron(scheduleJob);

    }

}
