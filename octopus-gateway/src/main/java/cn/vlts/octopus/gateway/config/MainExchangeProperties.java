package cn.vlts.octopus.gateway.config;

import cn.vlts.octopus.gateway.common.VertxStatusCode;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static cn.vlts.octopus.gateway.config.MainExchangeProperties.PREFIX;

/**
 * Main exchange properties.
 *
 * @author throwable
 * @version v1
 * @since 2024/9/24 00:17
 */
@Data
@ConfigurationProperties(prefix = PREFIX)
public class MainExchangeProperties {

    public static final String PREFIX = "main.exchange";

    private static final String DEFAULT_FAILURE_CONTENT_TYPE = "text/plain";

    private static final String DEFAULT_FAILURE_CONTENT = "Internal Server Error";

    private Integer failureStatusCode = VertxStatusCode.INTERNAL_SERVER_ERROR;

    private String failureContentType = DEFAULT_FAILURE_CONTENT_TYPE;

    private String failureContent = DEFAULT_FAILURE_CONTENT;
}
