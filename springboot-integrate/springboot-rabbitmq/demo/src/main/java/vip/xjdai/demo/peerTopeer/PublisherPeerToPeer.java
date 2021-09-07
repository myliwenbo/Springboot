package vip.xjdai.demo.peerTopeer;

import com.rabbitmq.client.Channel;
import org.junit.jupiter.api.Test;
import vip.xjdai.demo.demo.MQUtils;

public class PublisherPeerToPeer {

    // 发送者
    // 队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = MQUtils.getMQAndChannel();
        // 指定一个队列
        // 参数1：队列名称
        // 参数2：队列是否进行序列化 true(是)
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 往队列中发出一条消息，注意该方法有很多重载，根据需要查看API
        // 参数1: 转发器
        // 参数2: 队列名称
        // 参数3: 消息是否序列化 是(MessageProperties.PERSISTENT_TEXT_PLAIN) 否:传null值即可
        // 参数4: 要发送的信息
        channel.basicPublish("", QUEUE_NAME, null, "hello world!".getBytes());
        MQUtils.ColseMQAndChannel();
    }

    @Test
    public void workQueues() throws Exception {
        Channel channel = MQUtils.getMQAndChannel();
        // 指定一个队列
        // 参数1：队列名称
        // 参数2：队列是否进行序列化 true(是)
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 50; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (i + "").getBytes());
        }
        MQUtils.ColseMQAndChannel();

    }
}
