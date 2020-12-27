package cn.throwx.octopus.server.service;

import cn.throwx.octopus.server.model.entity.VisitStatistics;
import cn.throwx.octopus.server.repository.TransformEventRecordDao;
import cn.throwx.octopus.server.repository.VisitStatisticsDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author throwable
 * @description 统计服务
 * @since 2020/7/23 17:43
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsService {

    private final TransformEventRecordDao transformEventRecordDao;
    private final VisitStatisticsDao visitStatisticsDao;

    /**
     * 处理周期性的访客统计
     *
     * @param start start
     * @param end   end
     */
    public void processVisitStatisticsDuration(OffsetDateTime start, OffsetDateTime end) {
        List<VisitStatistics> selective = transformEventRecordDao.queryVisitStatisticsDuration(start, end);
        for (VisitStatistics visitStatistics : selective) {
            VisitStatistics selectiveVisitStatistics
                    = visitStatisticsDao.selectByUniqueKey(visitStatistics.getStatisticsDate(),
                    visitStatistics.getCompressionCode(), visitStatistics.getShortUrlDigest(), visitStatistics.getLongUrlDigest());
            if (null == selectiveVisitStatistics) {
                visitStatisticsDao.insertSelective(visitStatistics);
            } else {
                visitStatistics.setId(selectiveVisitStatistics.getId());
                visitStatisticsDao.updateByPrimaryKeySelective(visitStatistics);
            }
        }
    }
}
