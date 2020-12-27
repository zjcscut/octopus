package cn.throwx.octopus.server.filter.spring;

import cn.throwx.octopus.server.infra.common.CommonConstant;
import cn.throwx.octopus.server.infra.support.spring.WebFluxServerResponseWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * @author thorwable
 * @description 排查URI的过滤器
 * @since 2020/6/16 10:21
 */
@Slf4j
@Order(value = Integer.MIN_VALUE + 3)
@Component
public class ExcludeUriFilter implements WebFilter {

    @Value("#{'${octopus.exclude.uris}'.split(',')}")
    private List<String> excludeUris;

    @Value("${octopus.error.page.url}")
    private String errorPageUrl;

    @Autowired
    private WebFluxServerResponseWriter webFluxServerResponseWriter;

    @Override
    @NonNull
    public Mono<Void> filter(ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        String uri = exchange.getRequest().getURI().toString();
        // 头像请求忽略掉
        if (CommonConstant.FAVICON.equals(uri)) {
            return Mono.empty();
        }
        if (Objects.nonNull(excludeUris) && !excludeUris.contains(uri)) {
            return chain.filter(exchange);
        }
        log.warn("URI异常,命中非法URI[i:{}],跳转到404页面", uri);
        return webFluxServerResponseWriter.redirect(exchange, errorPageUrl);
    }
}
