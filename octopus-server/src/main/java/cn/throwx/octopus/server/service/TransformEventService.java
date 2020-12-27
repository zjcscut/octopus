package cn.throwx.octopus.server.service;

import cn.throwx.octopus.server.infra.util.JacksonUtils;
import cn.throwx.octopus.server.infra.util.UserAgentUtils;
import cn.throwx.octopus.server.model.entity.TransformEventRecord;
import cn.throwx.octopus.server.repository.TransformEventRecordDao;
import eu.bitwalker.useragentutils.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.Optional;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 17:01
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class TransformEventService {

    private final TransformEventRecordDao transformEventRecordDao;

    @Transactional(rollbackFor = Exception.class)
    public void recordTransformEvent(TransformEventRecord record) {
        // 身份唯一标识,算法:SHA-1(客户端IP + '-' + UserAgent)
        String uniqueIdentity = DigestUtils.sha1Hex(record.getClientIp() + "-" + record.getUserAgent());
        record.setUniqueIdentity(uniqueIdentity);
        record.setShortUrlDigest(DigestUtils.sha1Hex(record.getShortUrl()));
        record.setLongUrlDigest(DigestUtils.sha1Hex(record.getLongUrl()));
        try {
            URL url = new URL(record.getShortUrl());
            // 短链的附加参数
            if (StringUtils.isNotEmpty(url.getQuery())) {
                record.setQueryParam(url.getQuery());
            }
        } catch (Exception e) {
            log.warn("解析TransformEvent事件中短链的查询参数异常,事件内容:{}", JacksonUtils.X.format(record), e);
        }
        // 解析User-Agent
        if (StringUtils.isNotEmpty(record.getUserAgent())) {
            try {
                UserAgent userAgent = UserAgent.parseUserAgentString(record.getUserAgent());
                OperatingSystem operatingSystem = userAgent.getOperatingSystem();
                // 操作系统
                Optional.ofNullable(operatingSystem).ifPresent(x -> {
                    record.setOsType(x.getName());
                    record.setOsVersion(x.getName());
                    Optional.ofNullable(x.getDeviceType()).ifPresent(deviceType -> {
                        record.setDeviceType(deviceType.getName());
                        // 操作系统组别作为手机类型 - 具体的手机型号
                        if (DeviceType.MOBILE == deviceType) {
                            UserAgentUtils.UserAgentExtractResult result
                                    = UserAgentUtils.X.extractSystemType(record.getUserAgent());
                            record.setPhoneType(result.getPhoneType());
                            record.setOsType(result.getSystemType());
                            record.setOsVersion(result.getSystemVersion());
                        }
                    });
                });
                // 浏览器类型
                Browser browser = userAgent.getBrowser();
                Optional.ofNullable(browser).ifPresent(x -> record.setBrowserType(x.getGroup().getName()));
                // 浏览器版本
                Version browserVersion = userAgent.getBrowserVersion();
                Optional.ofNullable(browserVersion).ifPresent(x -> record.setBrowserVersion(x.getVersion()));
            } catch (Exception e) {
                log.error("解析TransformEvent中的UserAgent异常,事件内容:{}", JacksonUtils.X.format(record), e);
            }
        }
        transformEventRecordDao.insertSelective(record);
    }
}
