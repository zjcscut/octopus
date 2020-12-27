package cn.throwx.octopus.server.infra.util;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author throwable
 * @version v1
 * @description UA工具类 - 这里的正则不一定是满足大多数场景,酌情使用
 * @since 2020/12/26 12:53
 */
public enum UserAgentUtils {

    /**
     * 单例
     */
    X;

    private static final String PHONE_MESSAGE = "Mozilla/5.0\\s+\\((.*?)\\)";
    private static final String ANDROID_PHONE_TYPE = ".*;\\s+(.*?)\\s+Build";
    private static final String IOS_PHONE_TYPE = "(.*?);";
    private static final String ANDROID_SYSTEM_VERSION = ";\\s+Android\\s+(.*?)\\s?;";
    private static final String IOS_SYSTEM_VERSION = ";.*?OS\\s+(\\d+)_";

    private static final String IPHONE_VALUE = "iPhone";
    private static final String I_PAD_VALUE = "iPad";
    private static final String LINUX_VALUE = "Linux";

    /**
     * 从UA提取手机型号
     *
     * @param userAgent userAgent
     * @return UserAgentExtractResult
     */
    public UserAgentExtractResult extractSystemType(String userAgent) {
        UserAgentExtractResult result = new UserAgentExtractResult();
        String phoneType = null;
        String systemType = null;
        String systemVersion = null;
        String deviceString = findOneByRegex(userAgent, PHONE_MESSAGE);
        if (null != deviceString) {
            if (deviceString.contains(IPHONE_VALUE) || deviceString.contains(I_PAD_VALUE)) {
                phoneType = findOneByRegex(deviceString, IOS_PHONE_TYPE);
                systemType = "ios";
                systemVersion = findOneByRegex(deviceString, IOS_SYSTEM_VERSION);
            } else if (deviceString.contains(LINUX_VALUE)) {
                phoneType = findOneByRegex(deviceString, ANDROID_PHONE_TYPE);
                systemType = "android";
                systemVersion = findOneByRegex(deviceString, ANDROID_SYSTEM_VERSION);
            }
        }
        if (null == phoneType) {
            phoneType = UserAgentExtractResult.UNKNOWN;
        }
        if (null == systemType) {
            systemType = UserAgentExtractResult.UNKNOWN;
        }
        if (null == systemVersion) {
            systemVersion = UserAgentExtractResult.UNKNOWN;
        }
        result.setPhoneType(phoneType);
        result.setSystemType(systemType);
        result.setSystemVersion(systemVersion);
        return result;
    }

    public String findOneByRegex(String content, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        return m.find() ? m.group(1) : null;
    }

    @Data
    public static class UserAgentExtractResult {

        public static final String UNKNOWN = "unknown";

        /**
         * 手机型号
         */
        String phoneType;

        /**
         * 手机系统
         */
        String systemType;

        /**
         * 系统版本
         */
        String systemVersion;
    }
}
