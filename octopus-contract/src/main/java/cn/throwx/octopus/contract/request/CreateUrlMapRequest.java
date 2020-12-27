package cn.throwx.octopus.contract.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author throwable
 * @description 创建长短链映射请求
 * @since 2020/11/18 0018 16:09
 */
@Data
public class CreateUrlMapRequest implements Serializable {

    private String requestId;

    private String longUrl;

    private String description;
}
