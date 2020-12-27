package cn.throwx.octopus.server.infra.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author throwable
 * @version v1
 * @description 时区常量
 * @since 2020/12/26 12:46
 */
@Getter
@RequiredArgsConstructor
public enum TimeZoneConstant {

    /**
     * 中国时区
     */
    CHINA(ZoneId.of("Asia/Shanghai"), "上海-中国时区", ZoneOffset.of("+08:00"));

    private final ZoneId zoneId;
    private final String description;
    private final ZoneOffset offset;
}
