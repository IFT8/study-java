package cn.assupg.study;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueReceiver {

    public static void main(String[] args) throws JMSException, InterruptedException {

        //1、创建，连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://assupg-centos:61616");

        //2、通过连接工作工厂，创建一个连接
        Connection connection = connectionFactory.createConnection();

        //3、启动连接
        connection.start();

        //4、创建一个会话，通过连接拿到一个会话【可以配置是否事务，消息确认方式Session.AUTO_ACKNOWLEDGE[自动确认]】
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        //通过session会话，创建一个目的地【消息发送到哪里,queueName可以自定义】
        Destination destination = session.createQueue("my-queue");

        //通过session会话，创建一个生产者，需要指定发送到哪一个目的地；用于发布消息
        MessageConsumer consumer = session.createConsumer(destination);
        int i = 0;
        while (i < 3) {
            i++;
            TextMessage message = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("收到消息：" + message.getText());
        }

        //进行提交，以及关闭连接
        session.close();
        connection.close();
    }
}
