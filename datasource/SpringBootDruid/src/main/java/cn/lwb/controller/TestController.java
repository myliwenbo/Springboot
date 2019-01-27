package cn.lwb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lwb.mapper.ScheduleJobMapper;
import cn.lwb.pojo.ScheduleJob;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @RequestMapping("test")
    public void test() {
        ScheduleJob record = new ScheduleJob();
        record.setJobGroup("more");
        record.setJobName("1");
        scheduleJobMapper.insert(record);

    }
}
