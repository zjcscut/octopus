package cn.throwx.octopus.server.repository.mapper;

import cn.throwx.octopus.server.model.entity.TransformEventRecord;
import cn.throwx.octopus.server.model.entity.TransformEventRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransformEventRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransformEventRecord record);

    int insertSelective(TransformEventRecord record);

    List<TransformEventRecord> selectByExample(TransformEventRecordExample example);

    TransformEventRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransformEventRecord record, @Param("example") TransformEventRecordExample example);

    int updateByExample(@Param("record") TransformEventRecord record, @Param("example") TransformEventRecordExample example);

    int updateByPrimaryKeySelective(TransformEventRecord record);

    int updateByPrimaryKey(TransformEventRecord record);
}