package vip.xjdai.springbootfegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-provider")//声明调用的提供者的name
public interface ServiceProvider {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String test(@PathVariable String string);
}
