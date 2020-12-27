package cn.throwx.octopus.server.repository;

import cn.throwx.octopus.server.model.entity.DomainConf;
import cn.throwx.octopus.server.repository.mapper.DomainConfMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainConfDao extends DomainConfMapper {

    List<DomainConf> selectAll();

    DomainConf selectByDomain(@Param("domain") String domain);
}