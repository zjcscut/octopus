package cn.throwx.octopus.server.repository;

import cn.throwx.octopus.server.model.entity.UrlMap;
import cn.throwx.octopus.server.repository.mapper.UrlMapMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UrlMapDao extends UrlMapMapper {

    List<UrlMap> selectAll();

    UrlMap selectByCompressionCode(@Param("compressionCode") String compressionCode);
}