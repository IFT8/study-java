package cn.assupg.study;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueSender {

    public static void main(String[] args) throws JMSException, InterruptedException {

        //1、ConnectionFactory 连接工厂，用于创建连接对象，以连接到JMS的provider
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://assupg-centos:61616");

        //2、Connection：封装了客户与JMS提供者之间的一个虚拟的连接
        Connection connection = connectionFactory.createConnection();
        //2.1、启动连接
        connection.start();

        //3、Session：是生产和消费消息的一个单线程上下文（会话用于创建消息生产者producer、消息消费者consumer 和消息message等，会话提供了一个事务性的上下文，在这个上下文中，一组发送和接收被组合到一个原子操作中）
        //  boolean transacted                              事务
        //  int acknowledgeMode Session.AUTO_ACKNOWLEDGE    签收方式
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        //4、Destination：消息发送到的目的地
        Destination destination = session.createQueue("my-queue");

        //通过session会话，创建一个生产者，需要指定发送到哪一个目的地；用于发布消息
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 3; i++) {
            TextMessage message = session.createTextMessage("message--" + i);
            producer.send(message); //通过消息生产者，发出消息

            Thread.sleep(1000);
            System.out.println(message.getText());
        }

        session.commit();//进行提交，以及关闭连接
        session.close();
        connection.close();
    }
}
