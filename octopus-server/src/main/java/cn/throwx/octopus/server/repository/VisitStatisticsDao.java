package cn.throwx.octopus.server.repository;

import cn.throwx.octopus.server.model.entity.VisitStatistics;
import cn.throwx.octopus.server.repository.mapper.VisitStatisticsMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

public interface VisitStatisticsDao extends VisitStatisticsMapper {

    VisitStatistics selectByUniqueKey(@Param("statisticsDate") LocalDate statisticsDate,
                                      @Param("compressionCode") String compressionCode,
                                      @Param("shortUrlDigest") String shortUrlDigest,
                                      @Param("longUrlDigest") String longUrlDigest);
}