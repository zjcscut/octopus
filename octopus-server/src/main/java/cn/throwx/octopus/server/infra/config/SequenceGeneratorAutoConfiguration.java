package cn.throwx.octopus.server.infra.config;

import cn.throwx.octopus.server.infra.support.keygen.SequenceGenerator;
import cn.throwx.octopus.server.infra.support.keygen.SnowflakeSequenceGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author thorwable
 * @description
 * @since 2020/6/15 17:15
 */
@Configuration
public class SequenceGeneratorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SequenceGenerator snowflakeSequenceGenerator(@Value("${snowflake.worker.id}") Long workerId,
                                                        @Value("${snowflake.data.center.id}") Long dataCenterId) {
        SnowflakeSequenceGenerator sequenceGenerator = new SnowflakeSequenceGenerator(workerId, dataCenterId);
        sequenceGenerator.init();
        return sequenceGenerator;
    }
}
