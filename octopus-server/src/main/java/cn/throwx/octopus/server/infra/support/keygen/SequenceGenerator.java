package cn.throwx.octopus.server.infra.support.keygen;

/**
 * @author thorwable
 * @description 序列生成器
 * @since 2020/6/15 17:13
 */
public interface SequenceGenerator {

    /**
     * 生成整型序列
     *
     * @return long
     */
    long generate();
}
