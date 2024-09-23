package cn.vlts.octopus.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static cn.vlts.octopus.gateway.config.HttpServerProperties.PREFIX;

/**
 * HTTP server properties.
 *
 * @author throwable
 * @version v1
 * @since 2024/9/24 00:17
 */
@Data
@ConfigurationProperties(prefix = PREFIX)
public class HttpServerProperties {

    public static final String PREFIX = "vertx.http.server";

    private static final Integer DEFAULT_PORT = 8080;

    private Boolean enabled;

    private Integer port = DEFAULT_PORT;
}
