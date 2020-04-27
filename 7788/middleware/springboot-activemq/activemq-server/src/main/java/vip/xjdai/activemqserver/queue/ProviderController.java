package vip.xjdai.activemqserver.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/*
 * @author uv
 * @date 2018/9/15 14:54
 *
 */
@RestController
public class ProviderController
{

    @Resource(name = "queue1")
    private Queue  queue1;

    @Resource(name = "topic2")
    private Topic topic2;

    //注入springboot封装的工具类
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("send")
    public void send(String name)
    {
        //方法一：添加消息到消息队列
//        jmsMessagingTemplate.convertAndSend(queue1, name);
        jmsMessagingTemplate.convertAndSend(topic2, name);
        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        //jmsMessagingTemplate.convertAndSend("test", name);
    }
}