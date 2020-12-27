package cn.throwx.octopus.server.filter;

import cn.throwx.octopus.server.infra.common.TransformStatus;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

/**
 * @author thorwable
 * @description
 * @since 2020/6/15 18:00
 */
@Data
public class TransformContext {

    public static final String PARAM_CLIENT_ID_KEY = "CLIENT_ID";
    public static final String PARAM_UA_KEY = "UA";
    public static final String PARAM_COOKIE_KEY = "COOKIE";
    public static final String PARAM_SHORT_URL_KEY = "SL";
    public static final String PARAM_LONG_URL_KEY = "LL";
    public static final String PARAM_TARGET_LONG_URL_KEY = "RLL";
    public static final String PARAM_REMOTE_HOST_NAME_KEY = "RHN";
    public static final String PARAM_SERVER_WEB_EXCHANGE_KEY = "__SWE__";

    final ThreadLocal<Runnable> redirectAction = new TransmittableThreadLocal<>();

    private String compressionCode;

    private TransformStatus transformStatus;

    private Map<String, String> headers = Maps.newHashMap();

    private Map<String, Object> params = Maps.newHashMap();

    public void setTransformStatus(TransformStatus transformStatus) {
        this.transformStatus = transformStatus;
    }

    public Integer getTransformStatusValue() {
        return transformStatus.getValue();
    }

    public void addHeader(String key, String value) {
        headers.putIfAbsent(key, value);
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public void releaseHeaders() {
        headers = null;
    }

    public void addParam(String key, Object value) {
        params.putIfAbsent(key, value);
    }

    public void setParam(String key, Object value) {
        params.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getParam(String key) {
        return (T) params.get(key);
    }

    public void setRedirectAction(Runnable redirectAction) {
        this.redirectAction.set(redirectAction);
    }

    public Runnable getRedirectAction() {
        Runnable redirectAction = this.redirectAction.get();
        return Objects.nonNull(redirectAction) ? redirectAction : () -> {};
    }

    public void release() {
        headers = null;
        params = null;
    }
}
