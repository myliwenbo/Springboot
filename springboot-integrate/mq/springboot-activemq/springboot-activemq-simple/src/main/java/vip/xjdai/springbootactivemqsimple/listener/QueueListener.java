package vip.xjdai.springbootactivemqsimple.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {
    // 接受消息方法
    @JmsListener(destination = "queue",containerFactory="queueListener")
    public void queueOne(String text) {
        System.out.println("one接受到的消息是：" + text);
    }
    // 接受消息方法
    @JmsListener(destination = "queue",containerFactory="queueListener")
    public void queueTwo(String text) {
        System.out.println("TWO接受到的消息是：" + text);
    }

}
