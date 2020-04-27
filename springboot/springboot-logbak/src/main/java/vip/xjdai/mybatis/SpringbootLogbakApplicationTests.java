package vip.xjdai.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLogbakApplicationTests {

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @Test
    public void contextLoads() {
        ScheduleJob record = new ScheduleJob();
        record.setJobGroup("more");
        record.setJobName("1");
        scheduleJobMapper.insert(record);
        ScheduleJobExample example = new ScheduleJobExample();
        List<ScheduleJob> selectByExample = scheduleJobMapper.selectByExample(example);
        System.out.println(selectByExample.toString());
    }

}
