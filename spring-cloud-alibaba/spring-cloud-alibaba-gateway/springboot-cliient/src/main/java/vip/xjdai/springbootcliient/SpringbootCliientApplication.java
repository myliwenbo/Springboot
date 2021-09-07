package vip.xjdai.springbootcliient;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vip.xjdai.springbootcliient.model.Order;
import vip.xjdai.springbootcliient.serviice.OrderService;

@EnableFeignClients//开启Fegin
@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootCliientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCliientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    @RequestMapping("userController")
    static class UserController {

        @Autowired
        private OrderService orderService;

        @RequestMapping("getOrder")
        public Order getOrder() {
            return orderService.test();
        }
    }


}
