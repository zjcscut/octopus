package cn.throwx.octopus.server.infra.config;

import cn.throwx.octopus.server.infra.support.spring.OctopusErrorWebExceptionHandler;
import cn.throwx.octopus.server.infra.support.spring.WebFluxServerResponseWriter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

/**
 * @author throwable
 * @version v1
 * @description 全局异常处理器配置
 * @since 2020/12/26 19:26
 */
@Configuration
public class OctopusWebFluxConfiguration {

    @Primary
    @Bean
    public ErrorWebExceptionHandler errorWebExceptionHandler(WebFluxServerResponseWriter webFluxServerResponseWriter,
                                                             @Value("${octopus.error.page.url}") String errorPageUrl) {
        OctopusErrorWebExceptionHandler errorWebExceptionHandler = new OctopusErrorWebExceptionHandler();
        errorWebExceptionHandler.setWebFluxServerResponseWriter(webFluxServerResponseWriter);
        errorWebExceptionHandler.setErrorPageUrl(errorPageUrl);
        return errorWebExceptionHandler;
    }

    @Bean
    public WebFluxServerResponseWriter webFluxServerResponseWriter(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                                                   ServerCodecConfigurer serverCodecConfigurer) {
        WebFluxServerResponseWriter webFluxServerResponseWriter = new WebFluxServerResponseWriter();
        webFluxServerResponseWriter.setMessageReaders(serverCodecConfigurer.getReaders());
        webFluxServerResponseWriter.setMessageWriters(serverCodecConfigurer.getWriters());
        webFluxServerResponseWriter.setViewResolvers(viewResolversProvider.getIfAvailable(Collections::emptyList));
        return webFluxServerResponseWriter;
    }
}
