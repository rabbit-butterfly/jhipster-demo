package com.jumore.zhxf.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jumore.zhxf.domain.ReportCount;
import com.jumore.zhxf.service.dto.SimpleReportCountRes;

/**
 * Spring Data JPA repository for the ReportCount entity.
 */
public interface ReportCountRepository extends JpaRepository<ReportCount, Long> {

	Page<ReportCount> findByEventId(Long eventId, Pageable pageable);

	Page<ReportCount> findByEventIdAndUserId(Long eventId, Long userId, Pageable pageable);

	/**
	 * 统计活动报数据数
	 * 
	 * @param eventId
	 * @return
	 */
	@Query(value = "select ifnull(sum(completed_num),0) from zhxf_report_count where event_id = :eventId", nativeQuery = true)
	Long selectSumCompletedNumByEvnetId(@Param("eventId") Long eventId);

	@Query(value = "select ifnull(sum(completed_num),0) from zhxf_report_count where event_id = :eventId and user_id = :userId", nativeQuery = true)
	Long selectSumCompletedNumByEvnetIdAndUserId(@Param("eventId") Long eventId, @Param("userId") Long userId);

	@Query(value = "select new com.jumore.zhxf.service.dto.SimpleReportCountRes(" + "c.id,"
			+ "(select title from Event where id =c.eventId), " + "c.personName," + "c.completedNum ) "
			+ "FROM ReportCount c " + "ORDER BY c.createdTime desc")
	List<SimpleReportCountRes> getDanMu(Pageable pageable);

	@Query(value = "select max(createdTime) as createdTime from ReportCount where eventId = :eventId and userId= :userId ")
	ZonedDateTime selectLastCreatedTime(@Param("eventId") Long eventId, @Param("userId") Long userId);

}
