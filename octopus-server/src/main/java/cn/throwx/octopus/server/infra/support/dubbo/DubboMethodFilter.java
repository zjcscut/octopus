package cn.throwx.octopus.server.infra.support.dubbo;

import cn.throwx.octopus.server.infra.util.JacksonUtils;
import cn.throwx.octopus.server.infra.util.StringLimitUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author throwable
 * @description Dubbo方法过滤器
 * @since 2020/12/11 0011 11:58
 */
@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER})
@Slf4j
public class DubboMethodFilter implements Filter {

    private static final int LIMIT_LEN = 50;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.nanoTime();
        Result result = null;
        boolean error = false;
        Exception exception = null;
        try {
            result = invoker.invoke(invocation);
        } catch (Exception e) {
            ContractResponse response = new ContractResponse();
            response.setCode(ContractResponse.ERROR);
            response.setMessage(StringLimitUtils.X.limitString(e.getMessage(), LIMIT_LEN));
            error = true;
            result = new AppResponse(response);
            exception = e;
        } finally {
            long end = System.nanoTime();
            long cost = TimeUnit.NANOSECONDS.toMillis(end - start);
            String params = JacksonUtils.X.format(invocation.getArguments());
            String methodName = invoker.getInterface().getName() + "#" + invocation.getMethodName();
            if (error) {
                log.error("拦截到Dubbo请求处理发生异常,请求方法:{},请求参数:{},耗时:{} ms",
                        methodName,
                        params,
                        cost,
                        exception
                );
            } else {
                log.info("拦截到Dubbo请求处理成功,请求方法:{},请求参数:{},响应结果:{},耗时:{} ms",
                        methodName,
                        params,
                        Objects.nonNull(result) ? JacksonUtils.X.format(result.getValue()) : null,
                        cost
                );
            }
        }
        return result;
    }

    @Data
    private static class ContractResponse implements Serializable {

        public static final Long ERROR = 500L;

        private Long code;
        private String message;
    }
}
