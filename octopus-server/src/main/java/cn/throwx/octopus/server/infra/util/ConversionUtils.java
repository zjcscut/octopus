package cn.throwx.octopus.server.infra.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author throwable
 * @version v1
 * @description 进制转换器
 * @since 2020/12/26 12:57
 */
public enum ConversionUtils {

    /**
     * 单例
     */
    X;

    private static final String CHARS = "oNWxUYwrXdCOIj4ck6M8RbiQa3H91pSmZTAh70zquLnKvt2VyEGlBsPJgDe5Ff";
    private static final int SCALE = 62;
    private static final int MIN_LENGTH = 5;

    /**
     * 数字转62进制
     *
     * @param num num
     * @return String
     */
    public String encode62(long num) {
        StringBuilder builder = new StringBuilder();
        int remainder;
        while (num > SCALE - 1) {
            remainder = Long.valueOf(num % SCALE).intValue();
            builder.append(CHARS.charAt(remainder));
            num = num / SCALE;
        }
        builder.append(CHARS.charAt(Long.valueOf(num).intValue()));
        String value = builder.reverse().toString();
        return StringUtils.leftPad(value, MIN_LENGTH, '0');
    }

    /**
     * 62进制转为数字
     *
     * @param string string
     * @return long
     */
    public long decode62(String string) {
        string = string.replace("^0*", "");
        long value = 0;
        char tempChar;
        int tempCharValue;
        for (int i = 0; i < string.length(); i++) {
            tempChar = string.charAt(i);
            tempCharValue = CHARS.indexOf(tempChar);
            value += (long) (tempCharValue * Math.pow(SCALE, string.length() - i - 1));
        }
        return value;
    }
}
