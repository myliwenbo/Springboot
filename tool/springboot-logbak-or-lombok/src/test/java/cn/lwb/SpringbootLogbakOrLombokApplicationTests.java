package cn.lwb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.log.mybatis.ScheduleJob;
import cn.lwb.log.mybatis.ScheduleJobMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootLogbakOrLombokApplication.class)
public class SpringbootLogbakOrLombokApplicationTests {

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @Test
    public void contextLoads() {
        ScheduleJob record = new ScheduleJob();
        record.setJobGroup("more");
        record.setJobName("1");
        scheduleJobMapper.insert(record);
    }

}
