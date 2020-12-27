package cn.throwx.octopus.server.application.consumer;

import cn.throwx.octopus.server.application.consumer.request.TransformEvent;
import cn.throwx.octopus.server.infra.common.RabbitQueueRaw;
import cn.throwx.octopus.server.infra.common.TimeZoneConstant;
import cn.throwx.octopus.server.infra.support.MappedDiagnosticContextProvider;
import cn.throwx.octopus.server.infra.util.BeanCopierUtils;
import cn.throwx.octopus.server.infra.util.JacksonUtils;
import cn.throwx.octopus.server.model.entity.TransformEventRecord;
import cn.throwx.octopus.server.service.TransformEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 17:01
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class TransformEventConsumer {

    private final TransformEventService transformEventService;
    private final MappedDiagnosticContextProvider mappedDiagnosticContextProvider;

    /**
     * 接收和处理URL转换事件
     */
    @RabbitListener(queues = {RabbitQueueRaw.TRANSFORM_EVENT_QUEUE}, concurrency = "1-5")
    public void onTransformEvent(String content) {
        mappedDiagnosticContextProvider.process(() -> {
            log.info("接收到URL转换事件,内容:{}......", content);
            TransformEvent event = JacksonUtils.X.parse(content, TransformEvent.class);
            TransformEventRecord record = new TransformEventRecord();
            BeanCopierUtils.X.copy(event, record);
            record.setRecordTime(OffsetDateTime.ofInstant(Instant.ofEpochMilli(event.getTimestamp()), TimeZoneConstant.CHINA.getZoneId()));
            record.setTransformStatus(event.getTransformStatusValue());
            record.setShortUrl(event.getShortUrlString());
            record.setLongUrl(event.getLongUrlString());
            transformEventService.recordTransformEvent(record);
            log.info("记录URL转换事件完成......");
        });
    }
}
