package cn.throwx.octopus.server.infra.config;

import lombok.Data;

import java.util.Map;

/**
 * @author throwable
 * @version v1.0
 * @description Mybatis插件
 * @since 2019/8/26 10:59
 */
@Data
public class MybatisPlugin {

    private String beanName;
    private String enableEnv;
    private Map<String, String> properties;
}
