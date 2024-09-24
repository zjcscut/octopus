package cn.vlts.octopus.gateway.common;

/**
 * Vertx status code.
 *
 * @author throwable
 * @since 2024/9/24 星期二 11:13
 */
public class VertxStatusCode {

    public static final int NO_MATCH_ROUTE = 404;

    public static final int NO_MATCH_HTTP_METHOD = 405;

    public static final int NO_MATCH_ACCEPT = 406;

    public static final int NO_MATCH_CONTENT_TYPE = 415;

    public static final int NO_MATCH_REQUEST_BODY = 400;

    public static final int INTERNAL_SERVER_ERROR = 500;
}
