package cn.throwx.octopus.server.infra.support.keygen;

import lombok.RequiredArgsConstructor;

/**
 * @author thorwable
 * @description 雪花算法序列生成器
 * @since 2020/6/15 17:14
 */
@RequiredArgsConstructor
public class SnowflakeSequenceGenerator implements SequenceGenerator {

    private final long workerId;
    private final long dataCenterId;

    private JavaSnowflake javaSnowflake;

    public void init() {
        this.javaSnowflake = new JavaSnowflake(workerId, dataCenterId);
    }

    @Override
    public long generate() {
        return javaSnowflake.nextId();
    }
}
