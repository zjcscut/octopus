package cn.throwx.octopus.server.repository.mapper;

import cn.throwx.octopus.server.model.entity.CompressionCode;
import cn.throwx.octopus.server.model.entity.CompressionCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompressionCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CompressionCode record);

    int insertSelective(CompressionCode record);

    List<CompressionCode> selectByExample(CompressionCodeExample example);

    CompressionCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CompressionCode record, @Param("example") CompressionCodeExample example);

    int updateByExample(@Param("record") CompressionCode record, @Param("example") CompressionCodeExample example);

    int updateByPrimaryKeySelective(CompressionCode record);

    int updateByPrimaryKey(CompressionCode record);
}