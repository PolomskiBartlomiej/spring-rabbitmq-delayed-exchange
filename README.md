# spring-rabbitmq-delayed-exchange
Preferences: http://www.rabbitmq.com/community-plugins.html

# description
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
    

