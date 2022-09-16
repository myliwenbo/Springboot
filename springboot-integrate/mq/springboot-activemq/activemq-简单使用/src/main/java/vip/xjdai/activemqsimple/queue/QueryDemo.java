package vip.xjdai.activemqsimple.queue;

import lombok.SneakyThrows;

import javax.jms.*;

public class QueryDemo {
    public static final String queueName = "test-queue";

    public static void main(String[] args) throws Exception {
        QueryUtils.sendMessage();
        // 同步消息，只能获取一次消息..
        // new Thread(() -> synchronizeMessage(consumer)).start();
        // 异步消息，采用监听器的方式，会在后台一直监听消息...
        new Thread(() -> asyMessage("监听器-1")).start();
        new Thread(() -> asyMessage("监听器-2")).start();
        new Thread(() -> asyMessage("监听器-3")).start();
    }

    /**
     * 同步消息
     *
     * @param consumer
     */
    @SneakyThrows
    public static void synchronizeMessage() {
        Session session = QueryUtils.getSession();
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue(queueName);
        //6、使用会话对象创建生产者对象
        MessageConsumer consumer = session.createConsumer(queue);
        Message message = consumer.receive();
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("点对点1：" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 异步消息
     *
     * @param consumer
     * @param s
     */
    @SneakyThrows
    public static void asyMessage(String name) {
        Session session = QueryUtils.getSession();
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue(queueName);
        //6、使用会话对象创建生产者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(name + "-点对点：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
