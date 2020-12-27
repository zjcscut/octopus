package cn.throwx.octopus.server.service;

import cn.throwx.octopus.server.OctopusServerApplication;
import cn.throwx.octopus.server.infra.common.UrlMapStatus;
import cn.throwx.octopus.server.model.entity.UrlMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 17:55
 */
@Slf4j
@SpringBootTest(classes = OctopusServerApplication.class, properties = "spring.profiles.active=local")
@RunWith(SpringRunner.class)
public class UrlMapServiceTest {

    @Autowired
    private UrlMapService urlMapService;

    @Test
    public void createUrlMap() {
        String domain = "localhost:9099";
        UrlMap urlMap = new UrlMap();
        urlMap.setUrlStatus(UrlMapStatus.AVAILABLE.getValue());
        urlMap.setLongUrl("https://throwx.cn/2020/08/24/canal-ha-cluster-guide");
        urlMap.setDescription("测试短链");
        String url = urlMapService.createUrlMap(domain, urlMap);
        log.info("生成的短链:{}", url);
    }
}