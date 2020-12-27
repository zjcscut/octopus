package cn.throwx.octopus.server.cache.dto;

import lombok.Data;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 15:57
 */
@Data
public class UrlMapCacheDto {

    private Long id;

    private String shortUrl;

    private String longUrl;

    private String compressionCode;

    private String description;

    private Boolean enable;
}
