package vip.xjdai.springbootprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootProfileApplication {

    public static void main(String[] args) {
        SpringApplication value = new SpringApplication(SpringbootProfileApplication.class);
        value.setWebApplicationType(WebApplicationType.NONE);
        value.setAdditionalProfiles("dev");
        ConfigurableApplicationContext run = value.run(args);
        System.out.println(run.getBean("beanADev"));
        System.out.println(run.getBean("beanAPrd"));
        System.out.println(run.getBean("beanATest"));
    }

}
