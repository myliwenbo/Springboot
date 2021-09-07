package vip.xjdai.springbootservice;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServiceApplication.class, args);
    }

    @RestController
    @RequestMapping("orderController")
    static class OrderController {

        @RequestMapping("test")
        public Order test() {
            Order order = new Order();
            order.setItmeName("小米");
            return order;
        }

        @Data
        static class Order {
            private String itmeName;
        }
    }

}
