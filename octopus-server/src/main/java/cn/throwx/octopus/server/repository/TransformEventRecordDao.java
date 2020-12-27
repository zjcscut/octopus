package cn.throwx.octopus.server.repository;

import cn.throwx.octopus.server.model.entity.VisitStatistics;
import cn.throwx.octopus.server.repository.mapper.TransformEventRecordMapper;
import org.apache.ibatis.annotations.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface TransformEventRecordDao extends TransformEventRecordMapper {

    List<VisitStatistics> queryVisitStatisticsDuration(@Param("start") OffsetDateTime start,
                                                       @Param("end") OffsetDateTime end);
}