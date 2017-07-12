package com.jumore.zhxf.service.buddha;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.Event;
import com.jumore.zhxf.repository.EventRepository;
import com.jumore.zhxf.service.dto.EventDTO;
import com.jumore.zhxf.service.dto.SimpleEventRes;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class EventService {

	public final static String EVENT_CACHA_KEY_UNDONE = "EVENT_CACHA_KEY_UNDONE";

	@PersistenceContext EntityManager em;
	
	@Inject
	private EventRepository eventRepository;

	@Inject
	private ReportCountService reportCountService;

	@Inject
	private RegistService registService;



	/**
	 * 查询所有的未结束的活动
	 * 
	 * @param pageable
	 * @return
	 */
	public List<EventDTO> findOnGoing() {

		List<Event> list = eventRepository.findByEndDateAfterAndStatusEqualsOrderByCreatedTimeDesc(new Date(),1);
		List<EventDTO> res = new ArrayList<>();
		list.forEach(event -> {
			EventDTO dto = new EventDTO();
			dto.setTitle(event.getTitle());
			// 报名总人数
			dto.setPersonCount(registService.getRegistCount(event.getId()));
			// 完成总数
			dto.setCompletedCount(reportCountService.sumCompletedNumByEvnetId(event.getId()));
			res.add(dto);
		});
		return res;

	}

	public void verify(EventDTO eventDTO) {
		Event event = eventRepository.findOne(eventDTO.getId());
		event.setStatus(eventDTO.getStatus());
		eventRepository.save(event);
	}

	/**
	 * 查询可名的活动列表
	 * @param userId
	 * @return
	 */
	public List<SimpleEventRes> selectEventAbleRegistByUserId(Long userId) {
		return eventRepository.selectEventAbleRegistByUserId(userId);
	}

	/**
	 * 查询可报数据活动列表
	 * @param userId
	 * @return
	 */
	public List<SimpleEventRes> selectEventAbleReportCountByUserId(Long userId) {
		return eventRepository.selectEventAbleReportCountByUserId(userId);
	}

	/**
	 * 查询我的功能列表
	 * @return
	 */
	public List<EventDTO> selectByUserId(Long userId) {
		List<EventDTO> res=new ArrayList<EventDTO>();
		List<Event> list=eventRepository.selectByUserId(userId);
		list.forEach(event->{
			EventDTO dto = new EventDTO();
			dto.setTitle(event.getTitle());
			dto.setId(event.getId());
			
			// 完成总数
			dto.setCompletedCount(reportCountService.sumCompletedNumByEvnetId(event.getId(),userId));
			
			dto.setCreatedTime(reportCountService.selectLastCreateTime(event.getId(), userId));
			res.add(dto);
			
		});
		
		
		return res;
	}

}
