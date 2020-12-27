CREATE DATABASE `db_octopus` CHARSET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci';

USE `db_octopus`;

CREATE TABLE `url_map`
(
    `id`               BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    `short_url`        VARCHAR(32)     NOT NULL COMMENT '短链URL',
    `long_url`         VARCHAR(768)    NOT NULL COMMENT '长链URL',
    `short_url_digest` VARCHAR(128)    NOT NULL COMMENT '短链摘要',
    `long_url_digest`  VARCHAR(128)    NOT NULL COMMENT '长链摘要',
    `compression_code` VARCHAR(16)     NOT NULL COMMENT '压缩码',
    `description`      VARCHAR(256) COMMENT '描述',
    `url_status`       TINYINT         NOT NULL DEFAULT 1 COMMENT 'URL状态,1:正常,2:已失效',
    `create_time`      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`        DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator`          VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '创建者',
    `editor`           VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '更新者',
    `deleted`          TINYINT         NOT NULL DEFAULT 0 COMMENT '软删除标识',
    `version`          BIGINT          NOT NULL DEFAULT 1 COMMENT '版本号',
    UNIQUE uniq_compression_code (`compression_code`),
    INDEX idx_short_url (`short_url`),
    INDEX idx_short_url_digest (`short_url_digest`),
    INDEX idx_long_url_digest (`long_url_digest`)
) COMMENT 'URL映射表';

CREATE TABLE `domain_conf`
(
    `id`            BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    `domain_value`  VARCHAR(16)     NOT NULL COMMENT '域名',
    `protocol`      VARCHAR(8)      NOT NULL DEFAULT 'https' COMMENT '协议,https或者http',
    `domain_status` TINYINT         NOT NULL DEFAULT 1 COMMENT '域名状态,1:正常,2:已失效',
    `create_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`     DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator`       VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '创建者',
    `editor`        VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '更新者',
    `deleted`       TINYINT         NOT NULL DEFAULT 0 COMMENT '软删除标识',
    `version`       BIGINT          NOT NULL DEFAULT 1 COMMENT '版本号',
    UNIQUE uniq_domain (`domain_value`)
) COMMENT '域名配置';

CREATE TABLE `compression_code`
(
    `id`               BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    `compression_code` VARCHAR(16)     NOT NULL COMMENT '压缩码',
    `code_status`      TINYINT         NOT NULL DEFAULT 1 COMMENT '压缩码状态,1:未使用,2:已使用,3:已失效',
    `sequence_value`   VARCHAR(64)     NOT NULL COMMENT '序列(盐)',
    `strategy`         VARCHAR(8)      NOT NULL DEFAULT 'sequence' COMMENT '策略,sequence或者hash',
    `create_time`      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`        DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator`          VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '创建者',
    `editor`           VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '更新者',
    `deleted`          TINYINT         NOT NULL DEFAULT 0 COMMENT '软删除标识',
    `version`          BIGINT          NOT NULL DEFAULT 1 COMMENT '版本号',
    UNIQUE uniq_compression_code (`compression_code`)
) COMMENT '压缩码';

CREATE TABLE `visit_statistics`
(
    `id`                            BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    `create_time`                   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`                     DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator`                       VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '创建者',
    `editor`                        VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '更新者',
    `deleted`                       TINYINT         NOT NULL DEFAULT 0 COMMENT '软删除标识',
    `version`                       BIGINT          NOT NULL DEFAULT 1 COMMENT '版本号',
    `statistics_date`               DATE            NOT NULL DEFAULT '1970-01-01' COMMENT '统计日期',
    `pv_count`                      BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '页面流量数',
    `uv_count`                      BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '独立访客数',
    `ip_count`                      BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '独立IP数',
    `effective_redirection_count`   BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '有效跳转数',
    `ineffective_redirection_count` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '无效跳转数',
    `compression_code`              VARCHAR(16)     NOT NULL COMMENT '压缩码',
    `short_url_digest`              VARCHAR(128)    NOT NULL COMMENT '短链摘要',
    `long_url_digest`               VARCHAR(128)    NOT NULL COMMENT '长链摘要',
    UNIQUE uniq_date_code_digest (`statistics_date`, `compression_code`)
) COMMENT '访问数据统计';

CREATE TABLE `transform_event_record`
(
    `id`               BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    `create_time`      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `edit_time`        DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator`          VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '创建者',
    `editor`           VARCHAR(32)     NOT NULL DEFAULT 'admin' COMMENT '更新者',
    `deleted`          TINYINT         NOT NULL DEFAULT 0 COMMENT '软删除标识',
    `version`          BIGINT          NOT NULL DEFAULT 1 COMMENT '版本号',
    `unique_identity`  VARCHAR(128)    NOT NULL COMMENT '唯一身份标识,SHA-1(客户端IP-UA)',
    `client_ip`        VARCHAR(64)     NOT NULL COMMENT '客户端IP',
    `short_url`        VARCHAR(32)     NOT NULL COMMENT '短链URL',
    `long_url`         VARCHAR(768)    NOT NULL COMMENT '长链URL',
    `short_url_digest` VARCHAR(128)    NOT NULL COMMENT '短链摘要',
    `long_url_digest`  VARCHAR(128)    NOT NULL COMMENT '长链摘要',
    `compression_code` VARCHAR(16)     NOT NULL COMMENT '压缩码',
    `record_time`      DATETIME        NOT NULL COMMENT '记录时间戳',
    `user_agent`       VARCHAR(2048) COMMENT 'UA',
    `cookie_value`     VARCHAR(2048) COMMENT 'cookie',
    `query_param`      VARCHAR(2048) COMMENT 'URL参数',
    `province`         VARCHAR(32) COMMENT '省份',
    `city`             VARCHAR(32) COMMENT '城市',
    `phone_type`       VARCHAR(64) COMMENT '手机型号',
    `browser_type`     VARCHAR(64) COMMENT '浏览器类型',
    `browser_version`  VARCHAR(128) COMMENT '浏览器版本号',
    `os_type`          VARCHAR(32) COMMENT '操作系统型号',
    `device_type`      VARCHAR(32) COMMENT '设备型号',
    `os_version`       VARCHAR(32) COMMENT '操作系统版本号',
    `transform_status` TINYINT         NOT NULL DEFAULT 0 COMMENT '转换状态,1:转换成功,2:转换失败,3:重定向成功,4:重定向失败',
    INDEX idx_record_time (`record_time`),
    INDEX idx_compression_code (`compression_code`),
    INDEX idx_short_url_digest (`short_url_digest`),
    INDEX idx_long_url_digest (`long_url_digest`),
    INDEX idx_unique_identity (`unique_identity`)
) COMMENT '转换事件记录';