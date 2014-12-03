package hello;

import hello.messaging.Receiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:/integration.xml")
public class HelloWorldApp
{

    public static void main(String[] args)
    {
        SpringApplication.run(HelloWorldApp.class, args);
    }


    // ================ Messaging Config with RabbitMQ

    final public static String queueName = "helloWorldQueue";



//   Need adapt this config, to match the XML one: integration.xml.
//
//
//    @Bean
//    Queue queue()
//    {
//        return new Queue(queueName, false);
//    }
//
//    @Bean
//    TopicExchange exchange()
//    {
//        return new TopicExchange("spring-boot-exchange");
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange)
//    {
//        return BindingBuilder.bind(queue).to(exchange).with(queueName);
//    }
//
//    @Bean
//    Receiver receiver()
//    {
//        return new Receiver();
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver)
//    {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter)
//    {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }



}