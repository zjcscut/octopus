package cn.throwx.octopus.server.infra.config;

import cn.throwx.octopus.server.infra.common.RabbitQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2020/12/26 14:41
 */
@RequiredArgsConstructor
@Configuration
public class RabbitAutoConfiguration implements SmartInitializingSingleton {

    private final AmqpAdmin amqpAdmin;

    @Override
    public void afterSingletonsInstantiated() {
        Stream.of(RabbitQueue.values()).forEach(queue -> {
            String queueName = queue.getQueueName();
            Queue queueToUse = new Queue(queueName);
            amqpAdmin.declareQueue(queueToUse);
            CustomExchange exchange = new CustomExchange(queue.getExchangeName(), queue.getExchangeType());
            amqpAdmin.declareExchange(exchange);
            Binding binding = BindingBuilder.bind(queueToUse).to(exchange).with(queue.getRoutingKey()).noargs();
            amqpAdmin.declareBinding(binding);
        });
    }
}
