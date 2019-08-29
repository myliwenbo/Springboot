/**
 * 
 */
package vip.xjdai.simple.mq;

import com.rabbitmq.client.Channel;

import vip.xjdai.utisl.MQUtils;

/**
 * @author lwb
 *
 */
public class Send {

    //队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        Channel channel = MQUtils.setQueueByQueueName(QUEUE_NAME);
        for (int i = 0; i < 20; i++) {
            //发送的消息
            String message = "";
            for (int j = 0; j <= i; j++) {
                message += ".";
            }

            message += i;
            // 往队列中发出一条消息
            // 参数1: 转发器
            // 参数2: 队列名称
            // 参数3: 消息是否序列化 是(MessageProperties.PERSISTENT_TEXT_PLAIN) 否:传null值即可
            // 参数4: 要发送的信息 
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        //关闭频道和连接
        MQUtils.ColseMQAndChannel();
    }
}
