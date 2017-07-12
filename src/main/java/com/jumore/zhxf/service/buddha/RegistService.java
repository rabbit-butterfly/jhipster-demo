package com.jumore.zhxf.service.buddha;

import java.time.ZonedDateTime;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.Regist;
import com.jumore.zhxf.domain.oa.CheckConfig;
import com.jumore.zhxf.repository.RegistRepository;
import com.jumore.zhxf.service.dto.RegistDTO;
import com.jumore.zhxf.service.mapper.RegistMapper;

/**
 * 学佛报名业务处理
 * 
 * @author fwg created by 2017-02-16 15:33:06
 * 
 *
 */
@Service
@Transactional
public class RegistService {

	private final Logger log = LoggerFactory.getLogger(RegistService.class);

	public static final String CACHE_COUNT_REGIST_COUNT = "counting.regists.count";

	@Resource(name = "redisCountingTemplate")
	private HashOperations<String, String, Long> regCounter;

	@Resource
	private RegistRepository registRepository;

	@Resource
	private RegistMapper registMapper;

	@Resource
	private EventService eventService;

	public void save(CheckConfig checkConfig) {

	}

	public Page<Regist> findByEventId(Long eventId, Pageable pageable) {
		return registRepository.findByEventId(eventId, pageable);
	}

	/**
	 * 报名
	 * 
	 * @param dto
	 * @return
	 */
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public RegistDTO regist(RegistDTO dto) {
		/*
		 * Regist t = new Regist(); t.setUserId(dto.getUserId());
		 * t.setEventId(dto.getEventId());
		 */
		log.debug("userid:{}, enevtId:{}, stamptime:{}", dto.getUserId(), dto.getEventId(),
				System.currentTimeMillis());
		// 是否已报名
		if (registRepository.countByUserIdEqualsAndEventIdEquals(dto.getUserId(), dto.getEventId()) > 0) {
			log.error("exist regist of the event  {}", dto);
			throw new RuntimeException("exist regist of the event,{}");
		}
		log.debug("qeury complete,stamptime:{}",System.currentTimeMillis());

		Regist t = new Regist();
		t.setUserId(dto.getUserId());
		t.setEventId(dto.getEventId());
		t.setCreatedTime(ZonedDateTime.now());
		t.setModifyTime(ZonedDateTime.now());
		t.setPersonMobile(dto.getPersonMobile());
		t.setTargetNum(dto.getTargetNum());
		t.setPersonName(dto.getPersonName());
		t.setRemark(dto.getRemark());
		registRepository.save(t);

		// RegistDTO res = registMapper.registToRegistDTO(t);

		log.debug("@Async 处理redis报名记数 ");
		// 报名人数数加1
		incRegistsCount(t.getEventId(), 1);
		return dto;
	}

	/**
	 * 获取活报名人数
	 * 
	 * @param eventId
	 * @return
	 */
	public Long getRegistCount(Long eventId) {
		Long val = regCounter.get(CACHE_COUNT_REGIST_COUNT, eventId.toString());
		if (val == null) {
			val = registRepository.count(Example.of(new Regist(eventId)));
			regCounter.increment(CACHE_COUNT_REGIST_COUNT, eventId.toString(), val);
		}
		return val;
	}

	/**
	 * 计数大加，报名
	 * 
	 * @param userId
	 * @param num
	 */
	@Async
	public void incRegistsCount(Long eventId, int num) {

		long timestampStart = System.currentTimeMillis();
		log.debug("报名redis记数操作:{} ms");

		regCounter.increment(CACHE_COUNT_REGIST_COUNT, eventId.toString(), num);

		long timestampEnd = System.currentTimeMillis();
		log.debug("报名redis记数操作结束:{} ms", timestampEnd);
		log.debug("耗时:{} ms", timestampEnd - timestampStart);

	}

	/**
	 * 计数据减,取消报名
	 * 
	 * @param userId
	 */
	public void decRegistsCount(Long eventId) {
		regCounter.increment(CACHE_COUNT_REGIST_COUNT, eventId.toString(), -1);
	}

	/**
	 * 清除报名计数器，活动结束
	 * 
	 * @param userId
	 */
	public void cleanRegistsCount(Long userId) {
		regCounter.delete(CACHE_COUNT_REGIST_COUNT, userId);
	}

}
