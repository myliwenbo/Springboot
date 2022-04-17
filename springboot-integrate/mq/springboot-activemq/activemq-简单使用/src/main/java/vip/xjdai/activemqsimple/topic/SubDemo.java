package vip.xjdai.activemqsimple.topic;

import javax.jms.*;

public class SubDemo {
    private static String topicName = "test-topic";

    public static void main(String[] args) throws Exception {
        SubDemo.sub("订阅者1：");
        SubDemo.sub("订阅者2：");
        SubDemo.sub("订阅者3：");
        PubSubUtils.sendMessage(topicName);
    }

    private static void sub(String subName) throws Exception {
        Session session = PubSubUtils.getSession();
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Topic topic = session.createTopic(topicName);
        //6、使用会话对象创建生产者对象
        MessageConsumer consumer = session.createConsumer(topic);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(subName + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
