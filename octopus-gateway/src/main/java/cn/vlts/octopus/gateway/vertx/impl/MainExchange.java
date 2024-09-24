package cn.vlts.octopus.gateway.vertx.impl;

import cn.vlts.octopus.gateway.common.VertxStatusCode;
import cn.vlts.octopus.gateway.config.MainExchangeProperties;
import cn.vlts.octopus.gateway.vertx.RouterConfigurer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Main exchange.
 *
 * @author throwable
 * @version v1
 * @since 2024/9/24 星期二 11:56
 */
@Slf4j
public class MainExchange implements RouterConfigurer {

    private static final String COMPRESS_CODE_KEY = "compressCode";

    private static final String COMPRESS_CODE_PATTERN = "/:" + COMPRESS_CODE_KEY;

    private static final String CONTENT_TYPE_KEY = "Content-Type";

    private final MainExchangeProperties mainExchangeProperties;

    public MainExchange(MainExchangeProperties mainExchangeProperties) {
        this.mainExchangeProperties = mainExchangeProperties;
    }

    @Override
    public void registerRoutes(Router router) {
        router.route(COMPRESS_CODE_PATTERN)
                .method(HttpMethod.POST)
                .method(HttpMethod.GET)
                .method(HttpMethod.PUT)
                .handler(ctx -> {
                    String compressCode = ctx.pathParam(COMPRESS_CODE_KEY);
                    if (!StringUtils.hasLength(compressCode)) {
                        throw new IllegalArgumentException("");
                    }
                    HttpServerRequest request = ctx.request();
                })
                .failureHandler(ctx -> {
                    Throwable throwable = ctx.failure();
                    if (Objects.nonNull(throwable)) {
                        log.error("Process request failed, uri: {}", ctx.request().uri(), throwable);
                    }
                    ctx.response()
                            .putHeader(CONTENT_TYPE_KEY, mainExchangeProperties.getFailureContentType())
                            .setStatusCode(mainExchangeProperties.getFailureStatusCode())
                            .end(mainExchangeProperties.getFailureContent());
                });
    }
}
