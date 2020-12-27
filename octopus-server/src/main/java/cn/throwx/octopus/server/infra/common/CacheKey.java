package cn.throwx.octopus.server.infra.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 23:04
 */
@RequiredArgsConstructor
@Getter
public enum CacheKey {

    /**
     * 客户端黑名单列表
     */
    BLOCK_IP_SET("octopus:block:ip:set", "禁用的客户端IP", -1L),

    /**
     * 可访问短链域名白名单列表
     */
    ACCESS_DOMAIN_SET("octopus:access:domain:set", "启用的短链域名", -1L),

    /**
     * 可访问的压缩码映射
     */
    ACCESS_CODE_HASH("octopus:access:code:hash", "可访问的压缩码映射", -1L),

    ;

    private final String key;
    private final String description;
    private final long expireSeconds;
}
