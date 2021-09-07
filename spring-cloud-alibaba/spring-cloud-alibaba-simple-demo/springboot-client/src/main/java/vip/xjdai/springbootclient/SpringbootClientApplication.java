package vip.xjdai.springbootclient;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootClientApplication.class, args);
    }



    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    public class TestController {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private DiscoveryClient discoveryClient;

        @RequestMapping(value = "/serviceUrl/{str}", method = RequestMethod.GET)
        public String serviceUrl(@PathVariable String str) {
            ServiceInstance serviceInstance = discoveryClient.getInstances("service-provider").get(0);
            return restTemplate.getForObject("http://" + serviceInstance.getServiceId() + "/echo/" + str, String.class);
        }

        @RequestMapping(value = "/serviceURI/{str}", method = RequestMethod.GET)
        public String serviceURI(@PathVariable String str) {
            ServiceInstance serviceInstance = discoveryClient.getInstances("service-provider").get(0);
            return restTemplate.getForObject(serviceInstance.getUri() + "/echo/" + str, String.class);
        }
        @RequestMapping(value = "/serviceURIList/{str}", method = RequestMethod.GET)
        public String serviceURIList(@PathVariable String str) {
            List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
            int i = RandomUtil.randomInt(instances.size());
            ServiceInstance serviceInstance = instances.get(i);
            return restTemplate.getForObject(serviceInstance.getUri() + "/echo/" + str, String.class);
        }

    }
}
