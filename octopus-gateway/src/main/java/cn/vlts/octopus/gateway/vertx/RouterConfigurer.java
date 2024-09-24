package cn.vlts.octopus.gateway.vertx;

import io.vertx.ext.web.Router;

/**
 * Router configurer.
 *
 * @author throwable
 * @version v1
 * @since 2024/9/24 星期二 9:48
 */
@FunctionalInterface
public interface RouterConfigurer {

    void registerRoutes(Router router);
}
