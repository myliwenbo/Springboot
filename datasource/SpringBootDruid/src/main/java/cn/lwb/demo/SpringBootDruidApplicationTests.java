package cn.lwb.demo;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.mapper.ScheduleJobMapper;
import cn.lwb.pojo.ScheduleJob;

/**
 * 测试
 * 
 * @author lwb
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDruidApplicationTests {

    @Resource
    private DataSource dataSource;

    @Test
    public void testConnection() throws Exception {
        System.out.println("测试" + this.dataSource);
    }

    @Resource
    private ScheduleJobMapper scheduleJobMapper;

    @Test
    public void testMybatis() throws Exception {
        ScheduleJob record = new ScheduleJob();
        record.setJobGroup("more");
        record.setJobName("1");
        scheduleJobMapper.insert(record);
    }

}
