package com.logic.homework.simple;

import com.logic.homework.util.ResourceUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 * 消息消费者
 */
public class MyConsumerFanout {
    private final static String EXCHANGE_NAME = "broadcast_e";
    private final static String QUEUE_NAME = "broadcast_q";

    public static void main(String[] args) throws Exception {
        // 创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 配置url
        factory.setUri(ResourceUtil.getKey("rabbitmq.uri"));
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout",true, false, null);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" Waiting for message....");
        // 绑定队列和交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag );
                System.out.println("deliveryTag : " + envelope.getDeliveryTag() );
            }
        };

        // 消费者开始获取消息
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}

