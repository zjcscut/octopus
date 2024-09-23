package cn.vlts.octopus.gateway.vertx;

import cn.vlts.octopus.gateway.config.HttpServerProperties;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Vertx main verticle.
 *
 * @author throwable
 * @since 2024/9/24 00:15
 */
@Slf4j
@RequiredArgsConstructor
public class MainVerticle extends AbstractVerticle implements ApplicationContextAware {

    private final AtomicBoolean running = new AtomicBoolean();

    private final HttpServerProperties httpServerProperties;

    private ApplicationContext context;

    private HttpServer httpServer;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    @Override
    public void start() throws Exception {
        if (running.compareAndSet(false, true)) {
            Integer port = httpServerProperties.getPort();
            HttpServerOptions options = new HttpServerOptions();
            Router mainRouter = Router.router(vertx);
            httpServer = vertx.createHttpServer(options).requestHandler(mainRouter);
            httpServer.listen(port).onComplete(asyncResult -> {
                if (asyncResult.succeeded()) {
                    log.info("HTTP server start successfully, listen on port: {}", port);
                } else {
                    log.error("HTTP server start failed", asyncResult.cause());
                }
            });
        }
    }

    @Override
    public void stop() throws Exception {
        if (running.compareAndSet(true, false)) {
            Optional.ofNullable(httpServer).ifPresent(HttpServer::close);
        }
    }
}
