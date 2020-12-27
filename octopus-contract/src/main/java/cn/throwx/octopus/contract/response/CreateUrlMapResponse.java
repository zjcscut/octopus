package cn.throwx.octopus.contract.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @author throwable
 * @description 创建长短链映射请求
 * @since 2020/11/18 16:09
 */
@RequiredArgsConstructor
@Getter
public class CreateUrlMapResponse implements Serializable {

    private final String requestId;

    private final String shortUrl;
}
