package cn.throwx.octopus.server.infra.support.lock;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

/**
 * @author throwable
 * @version v1.0
 * @description 分布式锁工厂
 * @since 2020/11/1 11:33
 */
@Component
@RequiredArgsConstructor
public class DistributedLockFactory {

    private static final String DISTRIBUTED_LOCK_PATH_PREFIX = "dl:";
    private final RedissonClient redissonClient;

    /**
     * 提供分布式锁
     *
     * @param lockKey lockKey
     * @return DistributedLock
     */
    public DistributedLock provideDistributedLock(String lockKey) {
        String lockPath = DISTRIBUTED_LOCK_PATH_PREFIX + lockKey;
        return new RedissonDistributedLock(redissonClient, lockPath);
    }
}
