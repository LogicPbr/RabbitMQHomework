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
public class MyProducerFanout {
    private final static String EXCHANGE_NAME = "broadcast_e";

    public static void main(String[] args) throws Exception {
        // 创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 配置url
        factory.setUri(ResourceUtil.getKey("rabbitmq.uri"));
        // 创建连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        // 填写消息
        String msg = "Hello world, Rabbit MQ";
        // 推送消息
        channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
        // 关闭通道
        channel.close();
        // 关闭连接
        conn.close();
    }
}

