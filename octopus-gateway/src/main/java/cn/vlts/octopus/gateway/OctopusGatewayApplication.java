package cn.vlts.octopus.gateway;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Octopus gateway application.
 *
 * @author throwable
 * @version v1
 * @since 2024/9/23 00:03
 */
@SpringBootApplication
public class OctopusGatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(OctopusGatewayApplication.class)
                .web(WebApplicationType.NONE)
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .build()
                .run(args);
        final Vertx vertx = context.getBean(Vertx.class);
        context.getBeansOfType(AbstractVerticle.class).forEach((_, verticle) -> vertx.deployVerticle(verticle));
    }
}
