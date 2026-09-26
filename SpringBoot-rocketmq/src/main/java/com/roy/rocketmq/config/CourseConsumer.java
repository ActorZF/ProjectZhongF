package com.roy.rocketmq.config;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 注意下@RocketMQMessageListener这个注解的其他属性
 * @author ：楼兰
 * @description:
 **/
//消费者
@Component
//@RocketMQMessageListener(consumerGroup = "MyConsumerGroup", topic = "TestTopic",consumeMode= ConsumeMode.CONCURRENTLY,messageModel= MessageModel.BROADCASTING)
@RocketMQMessageListener(consumerGroup = "CourseConsumerGroup", topic = "CourseTopic")
//
public class CourseConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {

        System.out.println("当前学员情况消息 : "+ message);
    }
}
