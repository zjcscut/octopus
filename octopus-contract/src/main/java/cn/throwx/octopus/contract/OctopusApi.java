package cn.throwx.octopus.contract;

import cn.throwx.octopus.contract.request.CreateUrlMapRequest;
import cn.throwx.octopus.contract.response.CreateUrlMapResponse;
import cn.throwx.octopus.contract.response.Response;

/**
 * @author throwable
 * @version v1
 * @description 短链服务契约
 * @since 2020/12/25 0:12
 */
public interface OctopusApi {

    /**
     * 创建长短链映射
     *
     * @param request request
     * @return Response
     */
    Response<CreateUrlMapResponse> createUrlMap(CreateUrlMapRequest request);
}
