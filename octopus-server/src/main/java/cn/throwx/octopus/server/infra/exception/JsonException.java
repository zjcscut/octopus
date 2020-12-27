package cn.throwx.octopus.server.infra.exception;

/**
 * @author throwable
 * @version v1
 * @description JSON解析异常
 * @since 2020/12/26 13:02
 */
public class JsonException extends RuntimeException {

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonException(Throwable cause) {
        super(cause);
    }
}
