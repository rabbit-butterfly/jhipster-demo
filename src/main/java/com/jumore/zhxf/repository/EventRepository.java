package com.jumore.zhxf.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jumore.zhxf.domain.Event;
import com.jumore.zhxf.service.dto.SimpleEventRes;

/**
 * Spring Data JPA repository for the Event entity.
 */
public interface EventRepository extends JpaRepository<Event, Long> {


	List<Event> findByEndDateAfterAndStatusEqualsOrderByCreatedTimeDesc(Date date,Integer status);

	long countByEndDateAfter(Date date);

	@Query(value = "SELECT new com.jumore.zhxf.service.dto.SimpleEventRes( "  
			   + "c.id," 
		       + "c.title)" 
		   + "FROM Event c " 
		   + "WHERE c.status = 1 and c.endDate > now() and EXISTS (select 1 from Regist where userId=?1 and eventId=c.id )  order by c.createdTime desc")
	List<SimpleEventRes> selectEventAbleReportCountByUserId(Long userId);

	@Query(value = "SELECT new com.jumore.zhxf.service.dto.SimpleEventRes( "  
			   + "c.id," 
		       + "c.title)" 
		   + "FROM Event c " 
		   + "WHERE c.status = 1 and c.endDate > now() and NOT EXISTS (select 1 from Regist where userId=?1 and eventId=c.id ) order by c.createdTime desc ")
	List<SimpleEventRes> selectEventAbleRegistByUserId(Long userId);

	@Query(value = "FROM Event c " 
		   + "WHERE EXISTS (select 1 from Regist where userId=?1 and eventId=c.id )  order by c.createdTime desc")
	List<Event> selectByUserId(Long userId);
	
	long countByTitleEquals(String title);
	
	long countByTitleEqualsAndIdIsNotIn(String title ,Long id);
}
