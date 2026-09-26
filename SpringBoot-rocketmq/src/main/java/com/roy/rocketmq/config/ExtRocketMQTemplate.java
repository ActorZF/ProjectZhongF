package com.roy.rocketmq.config;

import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.annotation.ExtRocketMQConsumerConfiguration;
import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * @author ：楼兰
 * @description:
 **/
@ExtRocketMQTemplateConfiguration()
//@ExtRocketMQConsumerConfiguration(topic="stock_consumer_group")
public class ExtRocketMQTemplate extends RocketMQTemplate {

@Resource
private RocketMQTemplate rocketMQTemplate;
    public void getGXH(){
        rocketMQTemplate.convertAndSend(""+"tagA","message");
    }
}
