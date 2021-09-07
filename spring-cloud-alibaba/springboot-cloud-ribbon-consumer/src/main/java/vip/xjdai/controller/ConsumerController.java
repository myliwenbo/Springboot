/**
 * 
 */
package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import vip.xjdai.pojo.User;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "getUser")
    public String helloConsumer()
    {
        return restTemplate.getForEntity("http://HELLO-SERVICE/request/getUser", String.class).getBody();
    }

    /**
     * Get传参
     * @return
     */
    @RequestMapping(value = "getUserOne")
    public String getUserOne()
    {
        ResponseEntity<String> responseEntity = restTemplate
            .getForEntity("http://HELLO-SERVICE/request/getUserOne?name={1} ", String.class, "didi");
        return responseEntity.getBody();
    }

    /**
     * 返回的是一个对象
     * @return
     */
    @RequestMapping(value = "addUserGet")
    public User addUserGet()
    {
        ResponseEntity<User> responseEntity = restTemplate
            .getForEntity("http://HELLO-SERVICE/request/addUserGet?name={1} ", User.class, "didi");
        return responseEntity.getBody();
    }

    /**
     * 返回的是一个对象
     * @return
     */
    @RequestMapping(value = "addUserPost")
    public User addUserPost()
    {
        User user = new User();
        user.setName("didi");
        ResponseEntity<User> postForEntity = restTemplate.postForEntity("http://HELLO-SERVICE/request/addUserPost",
            user, User.class);
        return postForEntity.getBody();
    }
}
