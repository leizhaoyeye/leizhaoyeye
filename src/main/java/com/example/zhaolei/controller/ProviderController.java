package com.example.zhaolei.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("MQ—Controller")
@RequestMapping("/api/mq")
@Slf4j
public class ProviderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 简单模式
     */
    @GetMapping("/simple")
    public  void testSimple() {
        //        发送消息 (路由key,消息体)
        rabbitTemplate.convertAndSend("hello", "你吃到了甜甜圈");
    }


    /**
     * 工作队列模式
     */
    @GetMapping("/work")
    public  void testWork() {
        //        发送消息 (路由key,消息体)
        for (int i = 1; i <11 ; i++) {
            rabbitTemplate.convertAndSend("work", "吃到了第" + i + "个甜甜圈");
        }
    }

    /**
     * 广播模式
     */
    @GetMapping("/fanout")
    public  void testFanout() {
        //        发送消息 (交换机名称,路由key,消息体)
        rabbitTemplate.convertAndSend("fanoutExchange","", "这是一条广播:今天是交电费的日子");
    }

    /**
     * 路由模式
     */
    @GetMapping("/direct")
    public  void testDirect() {
        //        发送消息 (交换机名称,路由key,消息体)
        rabbitTemplate.convertAndSend("directExchange","apple", "吃到了苹果味甜甜圈");
        rabbitTemplate.convertAndSend("directExchange","milk", "吃到了牛奶味甜甜圈");
    }

    /**
     * 通配符模式
     */
    @GetMapping("/topic")
    public void testTopic(){
        //        发送消息 (交换机名称,路由key,消息体)
        rabbitTemplate.convertAndSend("topicExchange","rabbit.key1", "匹配了rabbit.key1");
        rabbitTemplate.convertAndSend("topicExchange","rabbit.key1.key2", "匹配了rabbit.key1.key2");
    }





}
