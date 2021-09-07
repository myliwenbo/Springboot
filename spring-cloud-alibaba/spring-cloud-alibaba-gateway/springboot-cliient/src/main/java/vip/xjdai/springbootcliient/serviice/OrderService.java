package vip.xjdai.springbootcliient.serviice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.xjdai.springbootcliient.model.Order;

@FeignClient(value = "gateway")  //声明调用的提供者的name
public interface OrderService {

    @RequestMapping("/service/orderController/test")
    public Order test();

}