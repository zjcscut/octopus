package cn.throwx.octopus.server.infra.config;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2020/3/12 11:08
 */
@RequiredArgsConstructor
@Configuration
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
@EnableConfigurationProperties(value = {MybatisProperties.class})
public class MybatisAutoConfiguration {

    private final MybatisProperties mybatisProperties;

    @Value("${spring.profiles.active:product}")
    public String env;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, BeanFactory beanFactory) {
        MybatisProperties mybatis = mybatisProperties;
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        if (null != mybatis.getProperties()) {
            Properties cp = new Properties();
            for (Map.Entry<String, String> pair : mybatis.getProperties().entrySet()) {
                cp.setProperty(pair.getKey(), pair.getValue());
            }
            bean.setConfigurationProperties(cp);
        }
        bean.setConfigLocation(new ClassPathResource(mybatisProperties.getConfigLocation()));
        bean.setMapperLocations(mybatis.getMapperResourceArray());
        if (null != mybatis.getTypeAliasesPackage()) {
            bean.setTypeAliasesPackage(mybatis.getTypeAliasesPackage());
        }
        if (null != mybatis.getPlugins()) {
            List<Interceptor> interceptors = Lists.newArrayList();
            for (MybatisPlugin plugin : mybatis.getPlugins()) {
                String enableEnv = plugin.getEnableEnv();
                if (null != enableEnv && enableEnv.contains(env)) {
                    Interceptor interceptor = beanFactory.getBean(plugin.getBeanName(), Interceptor.class);
                    if (null != plugin.getProperties()) {
                        Properties cp = new Properties();
                        for (Map.Entry<String, String> pair : plugin.getProperties().entrySet()) {
                            cp.setProperty(pair.getKey(), pair.getValue());
                        }
                        cp.put("beanFactory", beanFactory);
                        interceptor.setProperties(cp);
                    }
                    interceptors.add(interceptor);
                }
            }
            bean.setPlugins(interceptors.toArray(new Interceptor[0]));
        }
        bean.setTypeHandlersPackage(mybatis.getTypeHandlersPackage());
        return bean;
    }

    @Bean
    @ConditionalOnMissingBean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager) {
        return new TransactionTemplate(platformTransactionManager);
    }

    @Bean
    @ConditionalOnMissingBean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
