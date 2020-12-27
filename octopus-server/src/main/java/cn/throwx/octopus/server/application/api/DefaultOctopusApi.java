package cn.throwx.octopus.server.application.api;

import cn.throwx.octopus.contract.OctopusApi;
import cn.throwx.octopus.contract.request.CreateUrlMapRequest;
import cn.throwx.octopus.contract.response.CreateUrlMapResponse;
import cn.throwx.octopus.contract.response.Response;
import cn.throwx.octopus.server.infra.common.UrlMapStatus;
import cn.throwx.octopus.server.model.entity.UrlMap;
import cn.throwx.octopus.server.service.UrlMapService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 17:39
 */
@DubboService(retries = -1)
public class DefaultOctopusApi implements OctopusApi {

    @Autowired
    private UrlMapService urlMapService;

    @Value("${default.octopus.domain}")
    private String defaultDomain;

    @Override
    public Response<CreateUrlMapResponse> createUrlMap(CreateUrlMapRequest request) {
        UrlMap urlMap = new UrlMap();
        urlMap.setUrlStatus(UrlMapStatus.AVAILABLE.getValue());
        urlMap.setLongUrl(request.getLongUrl());
        urlMap.setDescription(request.getDescription());
        String shortUrl = urlMapService.createUrlMap(defaultDomain, urlMap);
        return Response.succeed(new CreateUrlMapResponse(request.getRequestId(), shortUrl));
    }
}
