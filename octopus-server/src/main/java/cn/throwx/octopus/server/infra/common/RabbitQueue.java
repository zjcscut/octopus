package cn.throwx.octopus.server.infra.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 16:16
 */
@RequiredArgsConstructor
@Getter
public enum RabbitQueue {

    /**
     * 短链转换事件
     */
    TRANSFORM_EVENT_QUEUE(
            RabbitQueueRaw.TRANSFORM_EVENT_QUEUE,
            RabbitQueueRaw.TRANSFORM_EVENT_QUEUE,
            RabbitQueueRaw.TRANSFORM_EVENT_QUEUE,
            "fanout"
    ),

    ;
    private final String queueName;
    private final String exchangeName;
    private final String routingKey;
    private final String exchangeType;
}
