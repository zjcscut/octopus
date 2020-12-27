package cn.throwx.octopus.server.filter.spring;

import cn.throwx.octopus.server.cache.AccessDomainCacheManager;
import cn.throwx.octopus.server.infra.support.spring.WebFluxServerResponseWriter;
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
@Order(value = Integer.MIN_VALUE + 2)
@Component
public class AccessDomainFilter implements WebFilter {

    @Autowired
    private WebFluxServerResponseWriter webFluxServerResponseWriter;

    @Autowired
    private AccessDomainCacheManager accessDomainCacheManager;

    @Value("${octopus.error.page.url}")
    private String errorPageUrl;

    @Override
    @NonNull
    public Mono<Void> filter(ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String domain = request.getURI().getHost();
        if (accessDomainCacheManager.checkDomainValid(domain)) {
            return chain.filter(exchange);
        } else {
            log.warn("请求异常,命中非法域名[d:{}],跳转到404页面", domain);
            return webFluxServerResponseWriter.redirect(exchange, errorPageUrl);
        }
    }
}
