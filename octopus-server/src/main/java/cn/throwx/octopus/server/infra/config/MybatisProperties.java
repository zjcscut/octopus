package cn.throwx.octopus.server.infra.config;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2020/1/22 9:56
 */
@Data
@ConfigurationProperties(prefix = MybatisProperties.PREFIX)
public class MybatisProperties {

    public static final String PREFIX = "spring.mybatis";

    private Map<String, String> properties;

    private List<String> mapperLocations;

    private String mapperPackages;

    private String configLocation;

    private String typeAliasesPackage;

    private String typeHandlersPackage;

    private List<MybatisPlugin> plugins;

    private static final ResourcePatternResolver RESOLVER = new PathMatchingResourcePatternResolver();

    public Resource[] getMapperResourceArray() {
        if (null == mapperLocations) {
            return new Resource[0];
        }
        List<Resource> resources = Lists.newArrayList();
        for (String location : mapperLocations) {
            try {
                resources.addAll(Arrays.asList(RESOLVER.getResources(location)));
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return resources.toArray(new Resource[0]);
    }
}
