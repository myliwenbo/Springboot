package vip.xjdai.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.command.ActiveMQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.jms.*;
import java.io.Serializable;
import java.util.Map;

@Service("queueMessageListener")
public class QueueMessageListener {

    @Autowired
    OrderServiceImpl orderService;

    @Transactional(rollbackFor = Exception.class)
    // 接受消息方法
    @JmsListener(destination = "queue", containerFactory = "queueListener")
    public void queueOne(ActiveMQMessage message, Session session) throws JMSException {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Map<Object, Object> object = (Map<Object, Object>) objectMessage.getObject();
        int count = orderService.queryMessageCountByUserId(object.get("userId"));
        try {
            // System.out.println("one接受到的消息是：" + textMessage.getText());
            // 手动确认
            message.acknowledge();
        } catch (Exception e) {
            // 此不可省略 重发信息使用
            session.recover();
        }
    }


    public void onMessage(Message message) {

        if (message instanceof ObjectMessage) {
            try {

                // if (count == 0) {
                //     // orderService.updateAmount(message1.getAmount(), message1.getUserId());
                //     // orderService.insertMessage(message1.getUserId(), message1.getMessageId(), message1.getAmount(), "ok");
                // } else {
                //     logger.info("异常转账");
                // }

                RestTemplate restTemplate = createRestTemplate();
                JSONObject jo = new JSONObject();
                // jo.put("messageId", message1.getMessageId());
                jo.put("respCode", "OK");
                String url = "http://jack.bank_a.com:8080/alipay/order/callback?param=" + jo.toJSONString();
                restTemplate.getForObject(url, null);
            } catch (JMSException e) {
                e.printStackTrace();
                throw new RuntimeException("异常");
            }
        }

    }

    public RestTemplate createRestTemplate() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(3000);
        simpleClientHttpRequestFactory.setReadTimeout(2000);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }
}