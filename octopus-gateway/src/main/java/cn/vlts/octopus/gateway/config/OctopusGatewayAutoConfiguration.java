package cn.vlts.octopus.gateway.config;

import cn.vlts.octopus.gateway.vertx.MainVerticle;
import cn.vlts.octopus.gateway.vertx.impl.MainExchange;
import io.vertx.core.Vertx;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author throwable
 * @since 2024/9/24 00:17
 */
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(value = {HttpServerProperties.class, MainExchangeProperties.class})
public class OctopusGatewayAutoConfiguration {

    private final HttpServerProperties httpServerProperties;

    private final MainExchangeProperties mainExchangeProperties;

    @Bean(destroyMethod = "close")
    public Vertx vertx() {
        return Vertx.vertx();
    }

    @Bean
    @ConditionalOnProperty(value = "vertx.http.server.enabled", havingValue = "true")
    public MainVerticle mainVerticle() {
        return new MainVerticle(httpServerProperties);
    }


    @Bean
    @ConditionalOnProperty(value = "vertx.http.server.enabled", havingValue = "true")
    public MainExchange mainExchange() {
        return new MainExchange(mainExchangeProperties);
    }
}
