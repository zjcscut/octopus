package cn.throwx.octopus.server.filter;

import cn.throwx.octopus.server.infra.common.TransformStatus;
import cn.throwx.octopus.server.infra.support.spring.WebFluxServerResponseWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author throwable
 * @description 重定向转换过滤器
 * @since 2020/7/21 19:16
 */
@Slf4j
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class RedirectionTransformFilter implements TransformFilter {

    @Autowired
    private WebFluxServerResponseWriter webFluxServerResponseWriter;

    @Override
    public int order() {
        return 3;
    }

    @Override
    public void init(TransformContext context) {

    }

    @Override
    public void doFilter(TransformFilterChain chain,
                         TransformContext context) {
        // 转换成功,进行重定向
        if (TransformStatus.TRANSFORM_SUCCESS == context.getTransformStatus()) {
            String longUrlString = context.getParam(TransformContext.PARAM_LONG_URL_KEY);
            try {
                if (StringUtils.isNotBlank(longUrlString)) {
                    Runnable redirectAction = webFluxServerResponseWriter.redirectAction(
                            context.getParam(TransformContext.PARAM_SERVER_WEB_EXCHANGE_KEY),
                            longUrlString
                    );
                    context.setRedirectAction(redirectAction);
                    context.setParam(TransformContext.PARAM_TARGET_LONG_URL_KEY, longUrlString);
                    context.setTransformStatus(TransformStatus.REDIRECTION_SUCCESS);
                } else {
                    context.setTransformStatus(TransformStatus.REDIRECTION_FAIL);
                    log.warn("重定向到长链接失败,长链值为空,压缩码:{}", context.getCompressionCode());
                }
            } catch (Exception e) {
                log.error("重定向到长链接[{}]失败,压缩码:{}", longUrlString, context.getCompressionCode(), e);
                context.setTransformStatus(TransformStatus.REDIRECTION_FAIL);
            }
        }
        chain.doFilter(context);
    }
}
