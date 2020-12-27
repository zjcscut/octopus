package cn.throwx.octopus.server.infra.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author thorwable
 * @description 压缩码状态
 * @since 2020/6/15 20:21
 */
@RequiredArgsConstructor
@Getter
public enum CompressionCodeStatus {

    /**
     * 可用
     */
    AVAILABLE(1),

    /**
     * 已经使用
     */
    USED(2),

    /**
     * 非法
     */
    INVALID(3),

    ;

    private final Integer value;
}
