package spring.rabbitmq.delayedexchange.domain;

import lombok.Value;

@Value
public class MessageEvent {
    String text;
}
