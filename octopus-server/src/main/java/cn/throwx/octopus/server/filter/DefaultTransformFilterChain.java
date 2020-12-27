package cn.throwx.octopus.server.filter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author throwable
 * @description
 * @since 2020/7/21 16:25
 */
@Slf4j
public class DefaultTransformFilterChain implements TransformFilterChain {

    private int pos = 0;
    private int n = 0;
    private TransformFilter[] filters = new TransformFilter[0];

    @Override
    public void doFilter(TransformContext context) {
        if (this.pos < this.n) {
            TransformFilter transformFilter = this.filters[this.pos++];
            transformFilter.doFilter(this, context);
        }
    }

    void addTransformFilter(TransformFilter filter) {
        TransformFilter[] newFilters = this.filters;
        for (TransformFilter newFilter : newFilters) {
            if (newFilter == filter) {
                return;
            }
        }
        // 扩容
        if (this.n == this.filters.length) {
            newFilters = new TransformFilter[this.n + 10];
            System.arraycopy(this.filters, 0, newFilters, 0, this.n);
            this.filters = newFilters;
        }
        this.filters[this.n++] = filter;
    }

    @Override
    public void release() {
        for (int i = 0; i < this.n; ++i) {
            this.filters[i] = null;
        }
        this.pos = 0;
        this.n = 0;
    }
}
