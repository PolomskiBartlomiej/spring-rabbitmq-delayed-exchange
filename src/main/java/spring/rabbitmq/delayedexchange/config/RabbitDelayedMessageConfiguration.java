package spring.rabbitmq.delayedexchange.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.rabbitmq.delayedexchange.config.bind.DelayedMessage;
import spring.rabbitmq.delayedexchange.publisher.DelayedMessagePublisher;

import static spring.rabbitmq.delayedexchange.config.DelayedMessageNamespace.DELAYED_MESSAGE_QUEUE;


@Configuration
public class RabbitDelayedMessageConfiguration {

    @Bean
    @DelayedMessage Queue
    delayedMessageQueue() {
        return QueueBuilder
                .durable(DELAYED_MESSAGE_QUEUE)
                .build();
    }

    @Bean
    @DelayedMessage Exchange
    delayedMessageExchange() {
        return ExchangeBuilder
                .directExchange(DELAYED_MESSAGE_QUEUE)
                .delayed()
                .build();
    }

    @Bean Binding
    delayedMessageBinder(@DelayedMessage Queue queue, @DelayedMessage Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DELAYED_MESSAGE_QUEUE).noargs();
    }

    @Bean DelayedMessagePublisher
    delayedMessagePublisher(RabbitTemplate template, @DelayedMessage Exchange exchange) {
        return new DelayedMessagePublisher(template, exchange);
    }
}
