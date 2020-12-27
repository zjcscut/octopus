package cn.throwx.octopus.server.infra.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 19:41
 */
public enum StringLimitUtils {

    /**
     * 单例
     */
    X;

    public String limitString(String value, int limit) {
        if (StringUtils.isBlank(value)) {
            return value;
        }
        int len = value.length();
        if (len > limit) {
            return value.substring(0, limit);
        }
        return value;
    }
}
