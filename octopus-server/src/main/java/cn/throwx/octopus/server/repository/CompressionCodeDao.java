package cn.throwx.octopus.server.repository;

import cn.throwx.octopus.server.model.entity.CompressionCode;
import cn.throwx.octopus.server.repository.mapper.CompressionCodeMapper;

public interface CompressionCodeDao extends CompressionCodeMapper {

    CompressionCode getLatestAvailableCompressionCode();
}