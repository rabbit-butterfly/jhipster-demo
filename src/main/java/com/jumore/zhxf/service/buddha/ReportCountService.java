package com.jumore.zhxf.service.buddha;

import java.time.ZonedDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.ReportCount;
import com.jumore.zhxf.repository.ReportCountRepository;
import com.jumore.zhxf.service.dto.ReportCountDTO;
import com.jumore.zhxf.service.dto.SimpleReportCountRes;
import com.jumore.zhxf.service.mapper.ReportCountMapper;

/**
 * 报数业务处理
 * 
 * @author fwg created by 2017-02-16 15:34:07
 *
 */
@Service
@Transactional
public class ReportCountService {

	// 计数据key
	public static final String CACHE_COUNT_REOPRT_COUNT = "counting.reportcount.completenum";

	// 计数据key
	public static final String CACHE_COUNT_REOPRT_COUNT_MINE = "counting.reportcount.completenum.mine";
		
	@Resource
	private ReportCountRepository reportCountRepository;

	@Resource
	private ReportCountMapper reportCountMapper;

	/**
	 * 
	 * */
	public Page<ReportCount> findByEventIdAndUserId(Long eventId, Long userId, PageRequest pageRequest) {
		return reportCountRepository.findByEventIdAndUserId(eventId, userId, pageRequest);
	}

	// redis计数大句柄
	@Resource(name = "redisCountingTemplate")
	HashOperations<String, String, Long> repCounter;

	public Page<ReportCount> findByEventId(Long eventId, Pageable pageable) {
		return reportCountRepository.findByEventId(eventId, pageable);
	}

	/**
	 * 报数
	 * 
	 * @param dto
	 * @return
	 */
	public ReportCountDTO save(ReportCountDTO dto) {

		ReportCount t = new ReportCount();
		t.setUserId(dto.getUserId());
		t.setEventId(dto.getEventId());
		t.setCreatedTime(dto.getCreatedTime());
		t.setModifyTime(ZonedDateTime.now());
		t.setPersonMobile("");
		t.setCompleteNum(dto.getCompletedNum());
		t.setPersonName(dto.getPersonName());
		t.setRemark(dto.getRemark());
		reportCountRepository.save(t);
		ReportCountDTO res = dto;
		res.setId(t.getId());
		
		// 报完名更新活动报名总数据
		incReportCountCompletedNum(t.getEventId(), t.getCompletedNum());
		
		// 报完名更新活动报名总数据
		incReportCountCompletedNum(t.getEventId(),t.getUserId(),t.getCompletedNum());
		return res;
	}

	/**
	 * 获取活动总报数情况
	 * 
	 * @param eventId
	 * @return
	 */
	public Long sumCompletedNumByEvnetId(Long eventId) {
		Long val = repCounter.get(CACHE_COUNT_REOPRT_COUNT, eventId.toString());
		if (val == null) {
			val = reportCountRepository.selectSumCompletedNumByEvnetId(eventId);
			repCounter.increment(CACHE_COUNT_REOPRT_COUNT, eventId.toString(), val);
		}
		return val;
	}

	/**
	 * 报数计数大加＋
	 * 
	 * @param userId
	 * @param num
	 */
	public void incReportCountCompletedNum(Long eventId, Long num) {
		repCounter.increment(CACHE_COUNT_REOPRT_COUNT, eventId.toString(), num);
	}
	
	/**
	 * 报数计数大加＋
	 * 
	 * @param userId
	 * @param num
	 */
	public void incReportCountCompletedNum(Long eventId,Long userId,Long num) {
		repCounter.increment(CACHE_COUNT_REOPRT_COUNT_MINE, eventId+"_"+userId, num);
	}

	/**
	 * 报数计数大减－
	 * 
	 * @param userId
	 */
	public void decReportCountCompletedNum(Long eventId, Long num) {
		repCounter.increment(CACHE_COUNT_REOPRT_COUNT, eventId.toString(), num);
	}

	/**
	 * 报数计数大减－
	 * 
	 * @param userId
	 */
	public void cleanReportCountCompletedNum(Long eventId, int num) {
		repCounter.delete(CACHE_COUNT_REOPRT_COUNT, eventId.toString());
	}

	public List<SimpleReportCountRes> getDanMu(Pageable pageable) {
		PageRequest pageRequest = new PageRequest(0, 300);
		return reportCountRepository.getDanMu(pageRequest);
	}

	/**
	 * 获取最后的报数时间
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public ZonedDateTime selectLastCreateTime(Long eventId, Long userId) {
		return reportCountRepository.selectLastCreatedTime(eventId, userId);

	}

	
	/**
	 * 获取活动 我的报数数情况
	 * 
	 * @param eventId
	 * @return
	 */
	public Long sumCompletedNumByEvnetId(Long eventId,Long userId) {
		String key=eventId+"_"+userId;
		Long val = repCounter.get(CACHE_COUNT_REOPRT_COUNT_MINE, key);
		if (val == null) {
			val = reportCountRepository.selectSumCompletedNumByEvnetIdAndUserId(eventId,userId);
			repCounter.increment(CACHE_COUNT_REOPRT_COUNT_MINE, key, val);
		}
		return val;
	}
	
	
	
}
