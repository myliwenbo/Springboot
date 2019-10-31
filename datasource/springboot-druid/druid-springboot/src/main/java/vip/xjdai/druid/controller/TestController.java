package vip.xjdai.druid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.druid.mapper.ScheduleJobMapper;
import vip.xjdai.druid.model.ScheduleJob;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController
{

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @RequestMapping("test")
    public List< ScheduleJob > test()
    {
        ScheduleJob record = new ScheduleJob();
        record.setJobGroup("more");
        record.setJobName("1");
        scheduleJobMapper.insert(record);
        return scheduleJobMapper.selectByExample(null);

    }
}
