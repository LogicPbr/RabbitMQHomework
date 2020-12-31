package com.logic.homework.simple;

import com.logic.homework.util.ResourceUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 * 消息生产者
 */
public class MyProducerDirect {
    private final static String EXCHANGE_NAME = "session_e";
    private final static String QUEUE_NAME = "session_q";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(ResourceUtil.getKey("rabbitmq.uri"));
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        // 发送消息
        String msg = "Hello world, Rabbit MQ";

        // String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish(EXCHANGE_NAME, "session", null, msg.getBytes());

        channel.close();
        conn.close();
    }
}

