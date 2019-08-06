package com.weyon.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxu
 * @description rabbit消息生产者
 * @date 2019-06-14
 **/
@Service
@Slf4j
public class MqProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息给消费者
     * @param queueKey 队列名称
     * @param object 自定义参数
     */
    public void sendQueue(String queueKey, Object object) {
        amqpTemplate.convertAndSend(queueKey, object);
    }

    /**
     * 发送延时队列
     * @param queueKey 队列名称
     * @param object 自定义参数
     * @param delay 延时时间
     */
    public void sendQueue(String queueKey, Object object, int delay) {
        amqpTemplate.convertAndSend(queueKey, object, message -> {
            message.getMessageProperties().setExpiration(delay + "");
            return message;
        });
    }
}
