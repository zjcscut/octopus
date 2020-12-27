package cn.throwx.octopus.server.repository.mapper;

import cn.throwx.octopus.server.model.entity.VisitStatistics;
import cn.throwx.octopus.server.model.entity.VisitStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitStatisticsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VisitStatistics record);

    int insertSelective(VisitStatistics record);

    List<VisitStatistics> selectByExample(VisitStatisticsExample example);

    VisitStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VisitStatistics record, @Param("example") VisitStatisticsExample example);

    int updateByExample(@Param("record") VisitStatistics record, @Param("example") VisitStatisticsExample example);

    int updateByPrimaryKeySelective(VisitStatistics record);

    int updateByPrimaryKey(VisitStatistics record);
}