package br.ouriques.Application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageBrokerConfig {


    public static final String EXCHANGE_NAME = "app-exchange";
    public static final String FIRST_QUEUE = "appGenericQueue";
    public static final String SECOND_QUEUE = "appSpecificQueue";
    public static final String FIRST_QUEUE_ROUTING_KEY = "first.messages.key";
    public static final String SECOND_QUEUE_ROUTING_KEY = "second.messages.key";

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue appFirstQueue() {
        return new Queue(FIRST_QUEUE);
    }

    @Bean
    public Queue appSecondQueue() {
        return new Queue(SECOND_QUEUE);
    }

    @Bean
    public Binding declareBindingGeneric() {
        return BindingBuilder.bind(appFirstQueue()).to(appExchange()).with(FIRST_QUEUE_ROUTING_KEY);
    }

    @Bean
    public Binding declareBindingSpecific() {
        return BindingBuilder.bind(appSecondQueue()).to(appExchange()).with(SECOND_QUEUE_ROUTING_KEY);
    }
}
