package cn.throwx.octopus.server.cache;

import cn.throwx.octopus.server.infra.common.CacheKey;
import cn.throwx.octopus.server.infra.common.DomainStatus;
import cn.throwx.octopus.server.model.entity.DomainConf;
import cn.throwx.octopus.server.repository.DomainConfDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 23:08
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AccessDomainCacheManager implements CommandLineRunner {

    private final StringRedisTemplate stringRedisTemplate;
    private final DomainConfDao domainConfDao;

    public boolean checkDomainValid(String domain) {
        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        return Boolean.TRUE.equals(opsForSet.isMember(CacheKey.ACCESS_DOMAIN_SET.getKey(), domain));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("开始加载短链域名白名单到缓存......");
        refreshAllAccessDomainCache();
        log.info("加载短链域名白名单到缓存完毕......");
    }

    void refreshAllAccessDomainCache() {
        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        String[] values = domainConfDao.selectAll()
                .stream()
                .filter(x -> Objects.equals(DomainStatus.AVAILABLE.getValue(), x.getDomainStatus()))
                .map(DomainConf::getDomainValue)
                // 这里如果存在端口,只取点分多段的IP
                .map(value -> value.split(":")[0])
                .toArray(String[]::new);
        if (values.length > 0) {
            opsForSet.add(CacheKey.ACCESS_DOMAIN_SET.getKey(), values);
        }
    }
}
