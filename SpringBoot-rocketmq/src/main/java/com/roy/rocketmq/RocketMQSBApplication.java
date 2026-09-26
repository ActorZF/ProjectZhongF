package com.roy.rocketmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：楼兰
 * @description:
 **/

@SpringBootApplication
@MapperScan("com.roy.rocketmq.mapper")  // ⚠️ 扫描 Mapper 所在的包
public class RocketMQSBApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMQSBApplication.class,args);
    }
}
