package cn.lwb.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.config.ConfigFour;
import cn.lwb.config.ConfigOne;
import cn.lwb.config.ConfigThree;
import cn.lwb.config.ConfigTwo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigReadApplicationTests {

    @Autowired
    private ConfigOne configOne;

    @Autowired
    private ConfigTwo configTwo;
    @Autowired
    private ConfigThree configThree;
    @Autowired
    private ConfigFour configFour;

    @Test
    public void contextLoads() {
        configOne.read();
        System.out.println(configTwo.druidDataSource().toString());
        System.out.println(configThree.toString());
        System.out.println(configFour.toString());
    }
}
