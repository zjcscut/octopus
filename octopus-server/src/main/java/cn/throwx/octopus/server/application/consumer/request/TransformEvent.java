package cn.throwx.octopus.server.application.consumer.request;

import lombok.Data;

/**
 * @author throwable
 * @description 转换事件
 * @since 2020/7/21 14:37
 */
@Data
public class TransformEvent {

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 压缩码
     */
    private String compressionCode;

    /**
     * user-agent
     */
    private String userAgent;

    /**
     * cookie
     */
    private String cookieValue;

    /**
     * 记录时间戳
     */
    private Long timestamp;

    /**
     * 短链字符串
     */
    private String shortUrlString;

    /**
     * 长链字符串
     */
    private String longUrlString;

    /**
     * 转换状态值
     */
    private Integer transformStatusValue;
}
