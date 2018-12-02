package spring.rabbitmq.delayedexchange.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import spring.rabbitmq.delayedexchange.domain.MessageEvent;

@RequiredArgsConstructor
public class DelayedMessagePublisher {

    private static final int DELAY = 1000;

    private final RabbitTemplate template;
    private final Exchange exchange;

    public void sendDelayedMessage(MessageEvent messageEvent) {
        template.convertAndSend(exchange.getName(),messageEvent,
                message -> {
                    message.getMessageProperties().setDelay(DELAY);
                    return message;
                });
    }
}
