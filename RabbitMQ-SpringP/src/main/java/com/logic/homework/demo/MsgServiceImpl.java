package com.logic.homework.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * CopyRright(c)2017-2020 Logic  <p>
 * Package com.logic.homework.demo
 * FileName  MsgServiceImpl <p>
 * Describe  <p>
 * author   logic <p>
 * version  v1.0 <p>
 * CreateDate  2020-12-31 18:01 <p>
 */
@Service
public class MsgServiceImpl implements IMsgService {

    @Value("${rabbitmq.directexchange}")
    private String directExchange;
    @Value("${rabbitmq.topicexchange}")
    private String topicExchange;
    @Value("${rabbitmq.fanoutexchange}")
    private String fanoutExchange;

    @Value("${rabbitmq.directroutingkey1}")
    private String directRoutingKey1;
    @Value("${rabbitmq.topicroutingkey1}")
    private String topicRoutingKey1;

    @Autowired
    AmqpTemplate aqmpTemplate;

    @Override
    public void directSend(String msg) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", msg);
        aqmpTemplate.convertAndSend(directExchange, directRoutingKey1, JSON.toJSONString(map));
    }

    @Override
    public void topicSend(String msg) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", msg);
        aqmpTemplate.convertAndSend(topicExchange, topicRoutingKey1, JSON.toJSONString(map));
    }

    @Override
    public void fanoutSend(String msg) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", msg);
        aqmpTemplate.convertAndSend(fanoutExchange, "", JSON.toJSONString(map));
    }
}
