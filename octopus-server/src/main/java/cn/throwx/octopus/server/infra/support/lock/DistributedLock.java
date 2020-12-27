package cn.throwx.octopus.server.infra.support.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author throwable
 * @version v1.0
 * @description 分布式锁
 * @since 2019/11/1 11:09
 */
public interface DistributedLock {

    /**
     * 阻塞加锁
     *
     * @param leaseTime leaseTime
     * @param unit      unit
     */
    void lock(long leaseTime, TimeUnit unit);

    /**
     * 尝试加锁
     *
     * @param waitTime  waitTime
     * @param leaseTime leaseTime
     * @param unit      unit
     * @return boolean
     */
    boolean tryLock(long waitTime, long leaseTime, TimeUnit unit);

    /**
     * 解锁
     */
    void unlock();

    /**
     * 是否锁定
     *
     * @return boolean
     */
    boolean isLock();

    /**
     * 当前线程是否持有锁
     *
     * @return boolean
     */
    boolean isHeldByCurrentThread();
}
