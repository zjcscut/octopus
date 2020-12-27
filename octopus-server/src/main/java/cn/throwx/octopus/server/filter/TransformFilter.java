package cn.throwx.octopus.server.filter;

/**
 * @author throwable
 * @description 短链转换Filter
 * @since 2020/7/21 14:08
 */
public interface TransformFilter {

    /**
     * 顺序系数
     *
     * @return int
     */
    default int order() {
        return 1;
    }

    /**
     * 初始化钩子方法
     *
     * @param context context
     */
    default void init(TransformContext context) {

    }

    /**
     * 执行过滤
     *
     * @param chain   chain
     * @param context context
     */
    void doFilter(TransformFilterChain chain,
                  TransformContext context);
}
