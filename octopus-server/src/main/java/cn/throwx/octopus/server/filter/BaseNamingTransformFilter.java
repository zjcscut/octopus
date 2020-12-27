package cn.throwx.octopus.server.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author throwable
 * @description 抽象命名过滤器
 * @since 2020/7/21 17:30
 */
@Slf4j
@RequiredArgsConstructor
public abstract class BaseNamingTransformFilter implements TransformFilter {

    private final TransformFilter delegate;

    /**
     * 定义过滤器名称
     *
     * @return String
     */
    public abstract String filterName();

    @Override
    public int order() {
        return delegate.order();
    }

    @Override
    public void init(TransformContext context) {
        delegate.init(context);
    }

    @Override
    public void doFilter(TransformFilterChain chain,
                         TransformContext context) {
        if (log.isDebugEnabled()) {
            log.debug("Entry TransformFilter {}...", filterName());
        }
        long start = System.nanoTime();
        try {
            delegate.doFilter(chain, context);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("Exit TransformFilter {},execution cost {} ms...", filterName(), TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
            }
        }
    }
}
