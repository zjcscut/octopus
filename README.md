# 短链接服务Octopus的实现与源码开放

## 前提

半年前（`2020-06`）左右，疫情触底反弹，公司的业务量不断提升，运营部门为了方便短信、模板消息推送等渠道的投放，提出了一个把长链接压缩为短链接的功能需求。当时为了快速推广，使用了一些比较知名的第三方短链压缩平台，存在一些问题：

- 收费贵
- 一些情况下，短链域名在部分第三方平台例如微信会被封杀
- 回源数据没有办法定制处理方案，无法打通整个业务链路进行数据分析和跟踪

基于此类问题，决定自研一个（长链接压缩为）短链接服务，当时刚好同步进行微服务拆分，内部很多微服务需要重新命名，组内的一个妹子说不如就用`Github`的吉祥物去命名`octopus cat`（章鱼猫）去命名，但是考虑到版权问题，去掉了她最喜欢的猫，剩下章鱼，以`octopus`命名：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-1.png)

（项目的描述还打错字了，应该是"短链接"）因为实现的功能并不复杂，初版于`2020-06`月底就发布。`octopus`的实现参考了互联网中几篇关于"短链服务实现"浏览量比较高的文章，下面从实现原理、服务实现和部署架构等方面展开谈谈。

<!-- more -->

## 基本原理

短链服务的核心就是构建短链接和长链接的唯一映射关系，依赖到一个高性能、排列组合数量大而且破解难度大的映射标识生成算法。

### 构建唯一映射关系

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-4.png)

上图是笔者收到的京东白条分期还款结果提醒短信，短信内容也包含了一个短链`https://3.cn/j/xxxxxxx`，把它拷贝到浏览器中打开，发现客户端会重定向到长链`https://jrmkt.jd.com/ptp/wl/vouchers.html?activityId=${activityId}&uep_p=${uep_p}&uep_template_id=${uep_template_id}&uep_timestamp=${uep_timestamp}`，然后跳入一个`H5`的登录页，登录后再跳进一个白条攻略页面。这里其实一个长链其实可以压成多个短链，短链可以相同域名，也可以使用不同的域名：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-5.png)

访问`https://3.cn/j/xxxxxxx`短链接具体的交互流程猜测如下：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-8.png)

> jrmkt.jd.com和3.cn查证都是doge东的域名

构建唯一映射关系其实就是基于一个固定的长链接，映射到一个或者多个可以动态生成的短链接，这个唯一映射关系，要求生成的短链接满足：

- 不容易被破解（使用数字例如数据库的自增主键作为唯一映射标识容易被人遍历出来进行恶意调用）
- 不能重复（一个短链接只能对应一个长链接，当然一个长链接可以对应多个短链接）
- 长度尽可能短，这是因为第三方推送的报文内容一般有长度限制，如果短链过长，会导致不容易传输，还会令到推送内容字数受限（试想运营商短信投放内容最大长度为`30`个字符长度，短链已经占了`20`个字符长度，剩下只有`10`个字符长度让运营同事去发挥，显然不合理）
- 如果链接过长，生成的二维码里面的"码点"会十分密集，不利于客户端识别和传输，刚好笔者公司运营有使用二维码的场景，所以必须尽可能缩短链接的长度

总的来说，这个唯一映射关系中的映射标识需要像`Hash`算法生成的`Hash`码那样具备高唯一性和低碰撞频率，同时具备短小易传输的特点，具体如何去生成映射唯一标识见下一节"压缩码生成算法"。

### 压缩码生成算法

这里的"压缩码"（`compression_code`）是笔者杜撰出来的名词，在本文中它的含义是短链接`URL`的路径部分（为了节省长度，除了协议和域名部分，短链的`URL`只有第一段路径）：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-2.png)

其中，协议部分基本是固定为`https://`（从安全性来看不建议使用`http://`），短链域名可以购买尽可能长度短的域名如`t.cn`，不过有先见之明的资本家一般会把所有优质的短域名买下并且把价格提到很高，所以域名的长度基本也是很难控制的因素，剩下可控的就是压缩码部分。压缩码部分是可控的，但因为它是`URL`的一部分，只要确保所使用的字符不会被`URL`编码转义，那么长度是人为可控的。假设我们使用的是`26`个字母的大小写，加上`10`个数字，那么对于`N`位压缩码可以表示的最大组合数量为：

- `N = 4`，组合数为`62 ^ 4 = 14_776_336`，`147`万接近`148`万
- `N = 5`，组合数为`62 ^ 5 = 916_132_832`，`9.16`亿左右
- `N = 6`，组合数为`62 ^ 6 = 56_800_235_584`，`568`亿左右

一般来说，组合数越小破解的难度就越小，组合数越大，要求压缩码长度越大，所以常用的长度就是`4`、`5`和`6`，而且后期可以对失效的长链进行压缩码回收或者禁用，这三个长度对于绝大对数生产短链的应用场景都能满足。`octopus`在实现的时候选用的是`6`位长度的压缩码，无他，因为有现成的成熟的参考方案：`62`进制数刚好由字符`0-9 a-z A-Z`组成，生成压缩码的时候，只需要生成一个唯一的`10`进制数，然后再基于此`10`进制数转换为`62`进制数数即可。说到这里，看起来的方案如下：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-6.png)

虚线部分一般依赖一种高效而且低冲突的摘要算法，如`MurmurHash`，而第`(1)`步的实线部分就是生成一个全局唯一的`10`进制序列，常用的手法有：

- 数据库自增序列（如自增主键）
- `Snowflake`算法
- 自研的类似`UUID`算法生成全局唯一的序列值

考虑到之前笔者钻研过`Snowflake`算法的原理，这里简单使用`Snowflake`算法生成自增序列，使用了下面的流程进行压缩码生成和分配：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-7.png)

因为运用部门对短链生成的批量不大，而且短链域名只有一个，**所以简单起见，一次压缩操作直接消耗掉一个压缩码，不考虑不同短链域名对同一个压缩码进行共享，也不考虑压缩码的回收问题**。

## 服务实现

短链服务的主访问入口一般`QPS`极高，因此需要想尽一切办法降低该入口的耗时，考虑可以用`Redis`做缓存承载入口的流量，基础架构选型如下：

- `JDK1.8+`：生产部署使用`JDK11`
- `MVC`框架与容器：`spring-boot-starter-webflux`或者`spring-cloud-gateway`，主要是必须使用`Netty`作为底层通讯容器
- 内部`RPC`框架：`Dubbo`
- 服务注册与发现：`Nacos`
- 可选`APM`工具：`Pinpoint`

中间件依赖（因为之前整个服务集群都上云了，低负载的服务共用了部分中间件）：

- `MySQL8.x`
- `Redis5.x`普通主从或者哨兵集群
- `RabbitMQ3.8.x`集群，使用镜像队列

服务的设计图如下：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-3.png)

最新的版本考虑把黑白名单的拦截器去掉，**替换成一个基于布隆过滤器现实的拦截器**。服务使用了两个拦截器（虽然`Filter`翻译是过滤器，但是出于习惯，下文称为拦截器）链，容器提供的拦截器组成的拦截器链主要是负责服务安全、调用链跟踪的功能，而服务内部自定义的拦截器链主要是实现请求参数解析、`URL`转换、重定向和异步事件记录等功能。

模块划分：

```shell
- (ROOT) octopus
  - octopus-contract
  - octopus-server
```

`octopus-contract`模块必须脱离父`POM`的管理，方便单独迭代更新。

### 数据库设计

一共使用了`5`个表：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-10.png)

具体的初始化`DDL`如下：

```sql
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
```

### 压缩码生成模块实现

压缩码生成的方法比较简单：

```java
private final SequenceGenerator sequenceGenerator;    # <------------- 雪花算法序列生成器
@Value("${compress.code.batch:100}")
private Integer compressCodeBatch;
......


private void generateBatchCompressionCodes() {
    for (int i = 0; i < compressCodeBatch; i++) {
        long sequence = sequenceGenerator.generate();
        CompressionCode compressionCode = new CompressionCode();
        compressionCode.setSequenceValue(String.valueOf(sequence));
        String code = ConversionUtils.X.encode62(sequence);    # <-------------- 10进制转62进制
        code = code.substring(code.length() - 6);
        compressionCode.setCompressionCode(code);
        compressionCodeDao.insertSelective(compressionCode);
    }
}
```

总是批量生成可用的压缩码，查询的时候只需要查出当前未被使用的第一个压缩码即可。

### 容器拦截器链实现

容器的拦截器需要实现`org.springframework.web.server.WebFilter`（`WebFlux`的`Filter`接口），主要有四个实现（顺序如下）：

- `MappedDiagnosticContextFilter`：引入`transmittable-thread-local`通过`MDC`做`TraceId`的请求上下文绑定，`WebFlux`的线程模型和常见的`Servlet`容器的线程模型不一样，这里不能直接使用`ThreadLocal`或者`Slf4j`中原有的`MDC`实现
- `BlockIpFilter`：判断客户端请求`IP`是否命中黑名单
- `AccessDomainFilter`：判断域名是否命中短链域名白名单（可选的，因为外部已经通过`NGINX`做了一次拦截，这个实现是可有可无的）
- `ExcludeUriFilter`：判断当前请求的`URI`是否命中了`URI`黑名单

这里简单展示一下`MappedDiagnosticContextFilter`的实现：

```java
@Order(value = Integer.MIN_VALUE)
@Component
public class MappedDiagnosticContextFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String uuid = UUID.randomUUID().toString();
        MDC.put("TRACE_ID", uuid);
        return chain.filter(exchange).then(Mono.fromRunnable(() -> MDC.remove("TRACE_ID")));
    }
}
```

上面的`TRACE_ID`是配合项目的`logback.xml`中的`pattern`使用。另外需要参考`https://github.com/alibaba/transmittable-thread-local/blob/master/docs/requirement-scenario.md`中`logback`与`transmittable-thread-local`做集成的场景：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-12.png)

这里为了方便管理和升级版本，笔者直接把`logback-mdc-ttl`的源码实现改造好后放到项目中。

### 服务内部拦截器链实现

服务内部的拦截器链主要负责请求参数解析、`URL`映射转换、重定向和访问转换结果记录，顶层接口设计如下：

```java
public interface TransformFilter {

    default int order() {
        return 1;
    }

    default void init(TransformContext context) {

    }

    void doFilter(TransformFilterChain chain,
                  TransformContext context);
}
```

`TransformContext`是一个属性承载类，本质是一个普通的`JavaBean`，设计如下：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-13.png)

目前内置了`4`个拦截器实现，包括：

- `ExtractRequestHeaderTransformFilter`：请求头解析
- `UrlTransformFilter`：`URL`转换
- `RedirectionTransformFilter`：重定向处理
- `TransformEventProcessTransformFilter`：转换事件记录

以`UrlTransformFilter`为例子，源码如下：

```java
@Slf4j
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class UrlTransformFilter implements TransformFilter {

    @Autowired
    private UrlMapCacheManager urlMapCacheManager;

    @Override
    public int order() {
        return 2;
    }

    @Override
    public void init(TransformContext context) {

    }

    @Override
    public void doFilter(TransformFilterChain chain,
                         TransformContext context) {
        String compressionCode = context.getCompressionCode();
        UrlMap urlMap = urlMapCacheManager.loadUrlMapCacheByCompressCode(compressionCode);
        context.setTransformStatus(TransformStatus.TRANSFORM_FAIL);
        if (Objects.nonNull(urlMap)) {
            context.setTransformStatus(TransformStatus.TRANSFORM_SUCCESS);
            context.setParam(TransformContext.PARAM_LONG_URL_KEY, urlMap.getLongUrl());
            context.setParam(TransformContext.PARAM_SHORT_URL_KEY, urlMap.getShortUrl());
            chain.doFilter(context);
        } else {
            log.warn("压缩码[{}]不存在或异常,终止TransformFilterChain执行,并且重定向到404页面......", compressionCode);
            throw new RedirectToErrorPageException(String.format("[c:%s]", compressionCode));
        }
    }
}
```

所有的服务内拦截器的`scope`都是`prototype`，意味着每次初始化拦截器链都会重新创建对应的`Bean`。

### 主控制器实现

因为`octopus`只做短链访问的入口，后台管理的功能交给另外的服务实现，此服务只有一个控制器，控制器里面只有一个方法：

```java
@RequiredArgsConstructor
@RestController
public class OctopusController {

    private final UrlMapService urlMapService;

    @GetMapping(path = "/{compressionCode}")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<Void> dispatch(@PathVariable(name = "compressionCode") String compressionCode, ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        TransformContext context = new TransformContext();
        context.setCompressionCode(compressionCode);
        context.setParam(TransformContext.PARAM_SERVER_WEB_EXCHANGE_KEY, exchange);
        if (Objects.nonNull(request.getRemoteAddress())) {
            context.setParam(TransformContext.PARAM_REMOTE_HOST_NAME_KEY, request.getRemoteAddress().getHostName());
        }
        HttpHeaders httpHeaders = request.getHeaders();
        Set<String> headerNames = httpHeaders.keySet();
        if (!CollectionUtils.isEmpty(headerNames)) {
            headerNames.forEach(headerName -> {
                String headerValue = httpHeaders.getFirst(headerName);
                context.setHeader(headerName, headerValue);
            });
        }
        // 处理转换
        urlMapService.processTransform(context);
        // 这里有一个技巧,flush用到的线程和内部逻辑处理的线程不是同一个线程,所有要用到TTL  --  和Servlet容器不一样,所以目前写的比较别扭
        return Mono.fromRunnable(context.getRedirectAction());
    }
}
```

这个主控制的分发压缩码方法只负责封装参数调用服务内部拦截器链进行后续的处理。然后添加一个全局的异常处理器，把所有的异常或者非法操作引导到一个自定义的`404`页面（甚至可以在上面挂一点广告）：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-11.png)

### Dubbo契约实现

`octopus-contract`是一个完全独立的模块，甚至可以说它是一个完全独立的项目，主要作用是提供契约`API`，让其他服务引入，让`octopus-server`模块进行实现。契约接口定义如下：

```java
public interface OctopusApi {

    Response<CreateUrlMapResponse> createUrlMap(CreateUrlMapRequest request);
}
```

基于`Dubbo`的实现如下：

```java
@DubboService(retries = -1)
public class DefaultOctopusApi implements OctopusApi {

    @Autowired
    private UrlMapService urlMapService;

    @Value("${default.octopus.domain}")
    private String domain;

    @Override
    public Response<CreateUrlMapResponse> createUrlMap(CreateUrlMapRequest request) {
        UrlMap urlMap = new UrlMap();
        urlMap.setUrlStatus(UrlMapStatus.AVAILABLE.getValue());
        urlMap.setLongUrl(request.getLongUrl());
        urlMap.setDescription(request.getDescription());
        String shortUrl = urlMapService.createUrlMap(domain, urlMap);
        return Response.succeed(new CreateUrlMapResponse(request.getRequestId(), shortUrl));
    }
}
```

生产中契约模块做了比较多的特性定制，这里只举一个简单实现的例子。

## 部署架构

`octopus`服务集群单独部署，支持无限添加节点，部署架构的关键在于网络架构，内层的负载均衡使用了`Nginx`，最外层的负载均衡使用了云负载均衡，如阿里云的`SLB`或者`UCloud`的`ULB`。添加或者移除短链域名，关键在于修改`Nginx`的配置。基本的架构如下：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-19.png)

只要保证负载均衡池指向`octopus`集群即可，短链的域名可能动态增删，操作完之后只需要`nginx -s -reload`刷新一下`Nginx`的配置即可。

## 使用短链服务

先在`domain_conf`表写入一条本地域名和端口的数据：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-14.png)

编写一个集成测试类，创建一个短链映射：

```java
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
// 某次执行的结果如下：生成的短链:http://localhost:9099/Myt8qW
```

基于本地配置启动项目，然后访问`http://localhost:9099/Myt8qW`，效果如下：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-15.gif)

日志如下：

```shell
[2020-12-27 19:29:22,285] [INFO] cn.throwx.octopus.server.application.consumer.TransformEventConsumer [org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1] [1c603903-e8d8-4072-aa97-6abf614b9411] - 接收到URL转换事件,内容:{"clientIp":"192.168.211.113","compressionCode":"Myt8qW","userAgent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36","cookieValue":"Webstorm-734c3b68=9b8b3560-41f5-478a-93d0-b02128b1022f; __gads=ID=28121bd829638f67-2286c86e7fc400d3:T=1604132165:RT=1604132165:S=ALNI_MbsMQROv6swaC8kf4ux2suZm_GZXA; Hm_lvt_4df6907aebab752244c3ca1432b4ff57=1605930058,1607228133","timestamp":1609068562262,"shortUrlString":"http://localhost:9099/Myt8qW","longUrlString":"https://throwx.cn/2020/08/24/canal-ha-cluster-guide","transformStatusValue":3}......
[2020-12-27 19:29:22,353] [INFO] cn.throwx.octopus.server.application.consumer.TransformEventConsumer [org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1] [1c603903-e8d8-4072-aa97-6abf614b9411] - 记录URL转换事件完成......
```

查看转换事件记录表的数据：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-16.png)

## 后续功能迭代

前期方案有一个安全隐患：没有做压缩码的白名单，容易被基于短链域名，伪造压缩码拼接短链接的方法进行攻击。解决方案是在容器的拦截器链添加或者替换一个基于布隆过滤器实现的压缩码（短链接）白名单拦截器，这样就能在前期拦截了绝大部分恶意伪造的压缩码，让极少量命中了错误率部分的恶意压缩码流到后面的处理逻辑中进行判断。另外，可以引入`Caffeine`配合`Redis`做两级缓存，毕竟本地缓存的速度更快。

## 小结

`octopus`初版是一个`4`小时紧急迭代出来的一个微型项目，到现在为止更新了很多次，生产上已经基本稳定。文中描述的版本是公司生产版本的移植版，精简了大量代码同时移除了一些业务耦合的设计，这里把源码开放出来，让一些有可能用到短链服务的场景提供一个可参考但尽可能不要复制的解决思路。源码仓库：

- `Gitee`：`https://gitee.com/throwableDoge/octopus`
- `Github`：`https://github.com/zjcscut/octopus`

代码都在`main`分支。

## 彩蛋

最近鸽了很长一段时间，原因是年底比较多业务功能迭代，内部的一个标签服务重构花了大量时间。笔者一直在摸索着通过"分片"、"异步"等等思想，在时间可控的前提下，对小数据量（百万和千万级别）前提下，通过常用的关系型数据库、缓存、消息队列等非大数据平台架构替代实现《用户画像方法论与工程化解决方案》里面提到的解决方案。

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-17.png)

标签服务内部的代号是"千寻"，取自于辛弃疾《青玉案元夕》中的"众里寻他千百度"，项目名来自于宫崎骏的动漫《千与千寻》的女主千寻（千寻罗马音是`chihiro`）：

![](https://throwable-blog-1256189093.cos.ap-guangzhou.myqcloud.com/202012/o-c-g-w-18.png)

待后面项目上线一段时间稳定后，应该会抽时间写一个系列谈谈怎么不用大数据那套体系，提供用户画像的工程化解决方案。

（本文完 c-10-d e-a-20201227）