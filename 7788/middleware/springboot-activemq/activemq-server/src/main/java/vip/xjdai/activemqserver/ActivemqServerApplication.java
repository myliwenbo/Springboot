package vip.xjdai.activemqserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActivemqServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ActivemqServerApplication.class, args);
    }

}
