package com.logic.homework.util;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * CopyRright(c)2017-2020 Logic  <p>
 * Package com.logic.homework
 * FileName  RabbitMQConfig <p>
 * Describe  <p>
 * author   logic <p>
 * version  v1.0 <p>
 * CreateDate  2020-12-31 17:33 <p>
 */
@Configuration
public class RabbitConfig {
    /**
     * 所有的消息发送都会转换成JSON格式发到交换机
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate aqmpTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}
