package cn.throwx.octopus.server.filter;

/**
 * @author throwable
 * @description
 * @since 2020/7/21 14:08
 */
public interface TransformFilterChain {

    void doFilter(TransformContext context);

    void release();
}
