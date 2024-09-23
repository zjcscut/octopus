package cn.vlts.octopus.gateway;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
        ConfigurableApplicationContext context = SpringApplication.run(OctopusGatewayApplication.class, args);
        final Vertx vertx = context.getBean(Vertx.class);
        context.getBeansOfType(AbstractVerticle.class).forEach((_, verticle) -> vertx.deployVerticle(verticle));
    }
}
