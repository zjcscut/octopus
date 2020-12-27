package cn.throwx.octopus.contract.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/25 0:13
 */
@Data
public class PaginationResponse<T> implements Serializable {

    public static final Long SUCCESS = 200L;
    public static final Long ERROR = 500L;
    public static final Long BAD_REQUEST = 400L;

    private Long code;
    private String message;
    private T payload;
}
