package spring.rabbitmq.delayedexchange.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequiredArgsConstructor
public class DelayedMessagePublisher {
    private final RabbitTemplate template;
    private final Exchange exchange;
}
