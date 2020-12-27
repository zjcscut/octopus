package cn.throwx.octopus.server.infra.exception;

/**
 * @author thorwable
 * @description 锁异常
 * @since 2020/6/15 18:36
 */
public class LockException extends RuntimeException {

    public LockException(String message) {
        super(message);
    }

    public LockException(String message, Throwable cause) {
        super(message, cause);
    }

    public LockException(Throwable cause) {
        super(cause);
    }
}
