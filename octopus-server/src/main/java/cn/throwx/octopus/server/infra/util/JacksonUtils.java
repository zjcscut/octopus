package cn.throwx.octopus.server.infra.util;

import cn.throwx.octopus.server.infra.exception.JsonException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author throwable
 * @version v1
 * @description JSON工具类
 * @since 2020/12/26 13:02
 */
public enum JacksonUtils {

    /**
     * 单例
     */
    X;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    public String format(Object content) {
        try {
            return MAPPER.writeValueAsString(content);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    public <T> T parse(String content, Class<T> targetClass) {
        try {
            return MAPPER.readValue(content, targetClass);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    public <T> T parse(String content, TypeReference<T> typeReference) {
        try {
            return MAPPER.readValue(content, typeReference);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }
}
