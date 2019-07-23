package br.ouriques.Application.service;

import br.ouriques.Application.config.MessageBrokerConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageBrokerService {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public MessageBrokerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void send(String message) {
        rabbitTemplate.convertAndSend(MessageBrokerConfig.EXCHANGE_NAME, MessageBrokerConfig.FIRST_QUEUE_ROUTING_KEY, message);
    }
}
