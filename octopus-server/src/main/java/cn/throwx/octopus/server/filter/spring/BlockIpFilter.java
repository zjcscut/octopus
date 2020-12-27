package cn.throwx.octopus.server.filter.spring;

import cn.throwx.octopus.server.cache.BlockIpCacheManager;
import cn.throwx.octopus.server.infra.support.spring.WebFluxServerResponseWriter;
import cn.throwx.octopus.server.infra.util.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 23:10
 */
@Slf4j
@Order(value = Integer.MIN_VALUE + 1)
@Component
public class BlockIpFilter implements WebFilter {

    @Autowired
    private WebFluxServerResponseWriter webFluxServerResponseWriter;

    @Autowired
    private BlockIpCacheManager blockIpCacheManager;

    @Value("${octopus.error.page.url}")
    private String errorPageUrl;

    @Override
    @NonNull
    public Mono<Void> filter(ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String clientIp = IpUtils.X.extractClientIp(exchange.getRequest());
        if (!blockIpCacheManager.isInBlockList(clientIp)) {
            return chain.filter(exchange);
        }
        log.warn("请求异常,命中IP黑名单[i:{}:{}],跳转到404页面", clientIp, request.getURI());
        return webFluxServerResponseWriter.redirect(exchange, errorPageUrl);
    }
}
