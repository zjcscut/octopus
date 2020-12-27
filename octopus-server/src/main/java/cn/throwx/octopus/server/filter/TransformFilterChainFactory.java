package cn.throwx.octopus.server.filter;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author throwable
 * @description
 * @since 2020/7/21 16:25
 */
@Component
public class TransformFilterChainFactory implements BeanFactoryAware {

    private ListableBeanFactory beanFactory;

    @SuppressWarnings("NullableProblems")
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }

    /**
     * 创建TransformFilter链
     */
    public TransformFilterChain buildTransformFilterChain(TransformContext context) {
        Map<String, TransformFilter> filters = beanFactory.getBeansOfType(TransformFilter.class);
        List<TransformFilterInstance> instances = Lists.newArrayList();
        filters.forEach((k, v) -> instances.add(new TransformFilterInstance(v, v.order(), k)));
        // 排序,order小的在前,大的在后
        instances.sort(Comparator.comparingInt(TransformFilterInstance::getOrder));
        DefaultTransformFilterChain filterChain = new DefaultTransformFilterChain();
        // 二次封装,添加名称为beanName,并且初始化
        instances.forEach(instance -> {
            TransformFilter filter = instance.getFilter();
            BaseNamingTransformFilter baseNamingTransformFilter = new BaseNamingTransformFilter(filter) {
                @Override
                public String filterName() {
                    return instance.getFilterName();
                }
            };
            filterChain.addTransformFilter(baseNamingTransformFilter);
            baseNamingTransformFilter.init(context);
        });
        return filterChain;
    }

    /**
     * 转换过滤器实例
     */
    @RequiredArgsConstructor
    @Getter
    private static class TransformFilterInstance {

        private final TransformFilter filter;
        private final int order;
        private final String filterName;
    }
}
