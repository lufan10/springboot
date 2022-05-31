package com.cn.service.config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class CoreConfig {

    @Bean
    /**
     * 消息队列，可以有多组
     */
    public Queue directQueue(){
        return new Queue("direct_queue");
    }

    @Bean
    /**
     * 直交换机
     */
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }

    @Bean
    /**
     * 消息队列，可以有多组
     */
    public Queue topicQueue(){
        return new Queue("topic_queue");
    }

    @Bean
    /**
     * 主题交换机
     */
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }

}
