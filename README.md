# spring-rabbitmq-delayed-exchange
Exploring spring rabbitm with delayed exchange plugin

Preferences: http://www.rabbitmq.com/community-plugins.html
Preferences: https://github.com/rabbitmq/rabbitmq-delayed-message-exchange

# instalation
To provide dalyed message in rabbitmq we should install rabbitmq_delayed_message_exchange plugin
  
**Installation**

    Binary builds are available from the RabbitMQ Community Plugins page : http://www.rabbitmq.com/community-plugins.html
    
**Enabling the Plugin**
    
    Then run the following command:
    rabbitmq-plugins enable rabbitmq_delayed_message_exchange

or we can use configured docker image :

**Docker Images**
  
  Images rabbitmq with plugins :
  
  1. managment
  2. delayed-message 
  
    image : tetsuobe/rabbitmq-delayed-message-exchange

# description
 Project show how to use and configure spring ampq with rabbitmq delayed message exchange.
 
 To see how to configure rabbitmq by spring, craete exchange, queue, binding and configuration :
 https://github.com/PolomskiBartlomiej/spring-rabbitmq-basic
 
 To configurare spring amqp to send delayed message we can configure RabbitTemplate: 
    
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
  
 

