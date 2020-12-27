package cn.throwx.octopus.server.infra.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 15:39
 */
@RequiredArgsConstructor
@Getter
public enum DomainStatus {

    /**
     * 可用状态
     */
    AVAILABLE(1),

    /**
     * 非法状态
     */
    INVALID(2),

    ;

    private final Integer value;
}
