package vip.xjdai.springbootfegin;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vip.xjdai.springbootfegin.service.ServiceProvider;

import java.util.List;

@EnableDiscoveryClient
@EnableFeignClients//开启Fegin
@SpringBootApplication
public class SpringbootFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFeginApplication.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @RestController
    public class TestController {

        @Autowired
        private ServiceProvider serviceProvider;

        @RequestMapping(value = "/serviceUrl/{str}", method = RequestMethod.GET)
        public String serviceUrl(@PathVariable String str) {
            return serviceProvider.test(str);
        }
    }
}