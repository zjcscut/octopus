package cn.throwx.octopus.server.infra.support.spring;

import cn.throwx.octopus.server.infra.exception.RedirectToErrorPageException;
import cn.throwx.octopus.server.infra.util.IpUtils;
import cn.throwx.octopus.server.infra.util.JacksonUtils;
import cn.throwx.octopus.server.infra.util.StringLimitUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.lang.NonNull;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 19:25
 */
@Slf4j
public class OctopusErrorWebExceptionHandler implements ErrorWebExceptionHandler {

    private WebFluxServerResponseWriter webFluxServerResponseWriter;

    private static final int LIMIT_LEN = 128;

    private String errorPageUrl;

    public void setErrorPageUrl(String url) {
        this.errorPageUrl = url;
    }

    public void setWebFluxServerResponseWriter(WebFluxServerResponseWriter webFluxServerResponseWriter) {
        this.webFluxServerResponseWriter = webFluxServerResponseWriter;
    }

    @Override
    @NonNull
    public Mono<Void> handle(ServerWebExchange serverWebExchange, @NonNull Throwable throwable) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        String clientIp = IpUtils.X.extractClientIp(request);
        log.error("处理URI:{}请求发生异常,客户端IP:{},", request.getURI(), clientIp, throwable);
        if (throwable instanceof RedirectToErrorPageException) {
            // 重定向到404页面
            return webFluxServerResponseWriter.redirect(
                    serverWebExchange,
                    errorPageUrl
            );
        } else {
            // 输出JSON字符串内容
            ControllerResponse controllerResponse = new ControllerResponse();
            String message = StringLimitUtils.X.limitString(throwable.getMessage(), LIMIT_LEN);
            controllerResponse.setCode(ControllerResponse.ERROR);
            controllerResponse.setMessage(message);
            return webFluxServerResponseWriter.write(
                    serverWebExchange,
                    JacksonUtils.X.format(controllerResponse),
                    throwable
            );
        }
    }

    @Data
    private static class ControllerResponse {

        public static final Long ERROR = 500L;

        private Long code;
        private String message;
    }
}
