package cn.throwx.octopus.server.filter.spring;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author thorwable
 * @description TRACE_ID处理拦截器
 * @since 2020/5/29 22:41
 */
@Order(value = Integer.MIN_VALUE)
@Component
public class MappedDiagnosticContextFilter implements WebFilter {

    @Override
    @NonNull
    public Mono<Void> filter(@NonNull ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        String uuid = UUID.randomUUID().toString();
        MDC.put("TRACE_ID", uuid);
        return chain.filter(exchange).then(Mono.fromRunnable(() -> MDC.remove("TRACE_ID")));
    }
}
