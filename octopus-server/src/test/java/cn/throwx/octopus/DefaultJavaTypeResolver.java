package cn.throwx.octopus;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * @author throwable
 * @version v1.0
 * @description MBG的类型处理器
 * SMALLINT和TINYINT使用Integer接收
 * DATE使用LocalDate接收
 * TIMESTAMP和DATETIME使用OffsetDateTime接收
 * @since 2020/12/25 0:13
 */
public class DefaultJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public DefaultJavaTypeResolver() {
        super();
        typeMap.put(Types.SMALLINT, new JdbcTypeInformation("SMALLINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
        typeMap.put(Types.TINYINT, new JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
        typeMap.put(Types.DATE, new JdbcTypeInformation("DATE",
                new FullyQualifiedJavaType(LocalDate.class.getName())));
        typeMap.put(Types.TIMESTAMP, new JdbcTypeInformation("TIMESTAMP",
                new FullyQualifiedJavaType(OffsetDateTime.class.getName())));
    }
}
