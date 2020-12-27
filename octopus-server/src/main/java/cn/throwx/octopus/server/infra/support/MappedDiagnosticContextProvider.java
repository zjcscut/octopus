package cn.throwx.octopus.server.infra.support;

import lombok.NonNull;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author throwable
 * @description TRACE_ID提供者
 * @since 2020/7/23 10:28
 */
@Component
public class MappedDiagnosticContextProvider {

    public void process(@NonNull Runnable runnable) {
        String uuid = UUID.randomUUID().toString();
        MDC.put("TRACE_ID", uuid);
        try {
            runnable.run();
        } finally {
            MDC.remove("TRACE_ID");
        }
    }
}
