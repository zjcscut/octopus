package cn.throwx.octopus.server.filter;


import cn.throwx.octopus.server.cache.UrlMapCacheManager;
import cn.throwx.octopus.server.infra.common.TransformStatus;
import cn.throwx.octopus.server.infra.exception.RedirectToErrorPageException;
import cn.throwx.octopus.server.model.entity.UrlMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * @author throwable
 * @description 短链转换过滤器
 * @since 2020/7/21 17:55
 */
@Slf4j
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class UrlTransformFilter implements TransformFilter {

    @Autowired
    private UrlMapCacheManager urlMapCacheManager;

    @Override
    public int order() {
        return 2;
    }

    @Override
    public void init(TransformContext context) {

    }

    @Override
    public void doFilter(TransformFilterChain chain,
                         TransformContext context) {
        String compressionCode = context.getCompressionCode();
        UrlMap urlMap = urlMapCacheManager.loadUrlMapCacheByCompressCode(compressionCode);
        context.setTransformStatus(TransformStatus.TRANSFORM_FAIL);
        if (Objects.nonNull(urlMap)) {
            context.setTransformStatus(TransformStatus.TRANSFORM_SUCCESS);
            context.setParam(TransformContext.PARAM_LONG_URL_KEY, urlMap.getLongUrl());
            context.setParam(TransformContext.PARAM_SHORT_URL_KEY, urlMap.getShortUrl());
            chain.doFilter(context);
        } else {
            log.warn("压缩码[{}]不存在或异常,终止TransformFilterChain执行,并且重定向到404页面......", compressionCode);
            throw new RedirectToErrorPageException(String.format("[c:%s]", compressionCode));
        }
    }
}
