package cn.throwx.octopus.server.infra.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author thorwable
 * @description 分布式锁KEY
 * @since 2020/6/15 20:02
 */
@RequiredArgsConstructor
@Getter
public enum LockKey {

    /**
     * 创建短链映射场景
     */
    CREATE_URL_MAP("octopus:url:map:create", "创建URL映射", 0L, 10000L),

    /**
     * 编辑短链映射场景
     */
    EDIT_URL_MAP("octopus:url:map:edit", "修改URL映射", 0L, 10000L),

    /**
     * 访问统计任务
     */
    VISITOR_STATS_TASK("octopus:visitor:stats:task", "访问统计任务", 0L, 10000L),

    ;

    private final String code;
    private final String desc;
    private final long waitTime;
    private final long releaseTime;
}
