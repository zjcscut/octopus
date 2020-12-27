package cn.throwx.octopus.server.infra.support.mybatis;

import cn.throwx.octopus.server.infra.common.TimeZoneConstant;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 12:45
 */
public class OffsetDateTimeTypeHandler extends BaseTypeHandler<OffsetDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OffsetDateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, Timestamp.from(parameter.toInstant()));
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(columnName);
        return getOffsetDateTime(timestamp);
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(columnIndex);
        return getOffsetDateTime(timestamp);
    }

    @Override
    public OffsetDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp timestamp = cs.getTimestamp(columnIndex);
        return getOffsetDateTime(timestamp);
    }

    private static OffsetDateTime getOffsetDateTime(Timestamp timestamp) {
        return Optional.ofNullable(timestamp)
                .map(ts -> OffsetDateTime.ofInstant(ts.toInstant(), TimeZoneConstant.CHINA.getOffset()))
                .orElse(null);
    }
}
