package com.example.zhaolei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerController {

    @RabbitListener(queuesToDeclare = @Queue("hello"))//队列名称
    public void customer(String message){
        System.out.println(message);
        log.info("我是简单模式消费者，消费的消息为："+message);
    }


    //work 工作模式，默认是公平策略，一人一条，可以配置为非公平策略     非公平策略：配置文件加 + spring.rabbitmq.listener.simple.prefetch=1
    @RabbitListener(queuesToDeclare = @Queue("work"))//队列名称
    public void customer1(String message) throws InterruptedException {
        Thread.sleep(1000);
        log.info("我是工作队列模式消费者赵磊，消费的消息为："+message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))//队列名称
    public void customer2(String message){
        log.info("我是工作队列模式消费者王叶，消费的消息为："+message);
    }




    @RabbitListener(bindings = @QueueBinding(   //队列与交换机绑定
            value = @Queue,         //创建临时队列 (@Queue)
            exchange = @Exchange(   //声明交换机
                    name = "fanoutExchange",type = "fanout")))  //交换机名称，交换机类型
    public void customerFanout1(String message) {
        System.out.println("我是广播模式消费者赵磊"+message);
    }

    @RabbitListener(bindings = @QueueBinding(   //队列与交换机绑定
            value = @Queue,         //创建临时队列 (@Queue)
            exchange = @Exchange(   //声明交换机
                    name = "fanoutExchange",type = "fanout")))  //交换机名称，交换机类型
    public void customerFanout2(String message){
        System.out.println("我是广播模式消费者王叶"+message);
    }



    @RabbitListener(bindings = @QueueBinding(   //队列与交换机绑定
            value = @Queue,         //创建临时队列 (@Queue)
            key = {"milk"}, //路由key 可以指定多个，多个时使用{}
            exchange = @Exchange(   //声明交换机
                    name = "directExchange",type = "direct")))  //交换机名称，交换机类型
    public void customerDirect1(String message) {
        System.out.println("我是路由模式的消费者，路由key是 milk ===>"+message);
    }


    @RabbitListener(bindings = @QueueBinding(   //队列与交换机绑定
            value = @Queue,             //创建临时队列 (@Queue)
            key = {"milk","apple"},               //指定路由key
            exchange = @Exchange(       //声明交换机
                    name = "directExchange",type = "direct")))  //交换机名称，交换机类型
    public void customerDirect2(String message){
        System.out.println("我是路由模式的消费者，路由key是 milk 和 apple ===>"+message);
    }


    /**
     * *   匹配一个词						例：rabbit.a
     * #   匹配一个或多个词					例：rabbit.a或rabbit.a.b等
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(   //队列与交换机绑定
            value = @Queue,         //创建临时队列 (@Queue)
            key = "rabbit.*",        //路由key 可以指定多个，多个时使用{}
            exchange = @Exchange(   //声明交换机
                    name = "topicExchange",type = "topic")))  //交换机名称，交换机类型
    public void customerTopic1(String message) {
        System.out.println("我是通配符模式的消费者，路由key是rabbit.*===>"+message);
    }


    @RabbitListener(bindings = @QueueBinding(   //队列与交换机绑定
            value = @Queue,             //创建临时队列 (@Queue)
            key = "rabbit.#",           //指定路由key
            exchange = @Exchange(       //声明交换机
                    name = "topicExchange",type = "topic")))  //交换机名称，交换机类型
    public void customerTopic2(String message){
        System.out.println("我是通配符模式的消费者，路由key是rabbit.#===>"+message);
    }


}
