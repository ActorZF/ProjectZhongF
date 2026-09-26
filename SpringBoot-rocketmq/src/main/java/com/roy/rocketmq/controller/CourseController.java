package com.roy.rocketmq.controller;

import com.roy.rocketmq.domain.Course;
import com.roy.rocketmq.config.SpringProducer;
import com.roy.rocketmq.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final String topic = "CourseTopic";
    @Resource
    private CourseService courseService;
    @Resource
    private SpringProducer producer;

    @RequestMapping("/getCourseMQ")
    public String getCourseMQ(){
        List<Course> ulList = courseService.SelectByName("新媒体运营");
        producer.sendMessage(topic,ulList.get(0).toString());
        return "消息发送完成";
    }
}
