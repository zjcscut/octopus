package cn.throwx.octopus.server.infra.exception;

/**
 * @author throwable
 * @description 需要重定向的异常
 * @since 2020/7/21 11:17
 */
public class RedirectToErrorPageException extends RuntimeException {

    public RedirectToErrorPageException(String message) {
        super(message);
    }

    public RedirectToErrorPageException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedirectToErrorPageException(Throwable cause) {
        super(cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
