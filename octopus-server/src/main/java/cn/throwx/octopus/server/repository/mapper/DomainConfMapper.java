package cn.throwx.octopus.server.repository.mapper;

import cn.throwx.octopus.server.model.entity.DomainConf;
import cn.throwx.octopus.server.model.entity.DomainConfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomainConfMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DomainConf record);

    int insertSelective(DomainConf record);

    List<DomainConf> selectByExample(DomainConfExample example);

    DomainConf selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DomainConf record, @Param("example") DomainConfExample example);

    int updateByExample(@Param("record") DomainConf record, @Param("example") DomainConfExample example);

    int updateByPrimaryKeySelective(DomainConf record);

    int updateByPrimaryKey(DomainConf record);
}