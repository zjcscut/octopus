package cn.throwx.octopus.server.cache;

import cn.throwx.octopus.server.infra.common.CacheKey;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 23:02
 */
@Component
@RequiredArgsConstructor
public class BlockIpCacheManager {

    private final StringRedisTemplate stringRedisTemplate;

    public boolean isInBlockList(String clientIp) {
        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        return Boolean.TRUE.equals(opsForSet.isMember(CacheKey.BLOCK_IP_SET.getKey(), clientIp));
    }
}

