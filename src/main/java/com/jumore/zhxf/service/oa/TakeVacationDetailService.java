package com.jumore.zhxf.service.oa;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.oa.TakeVacationDetail;
import com.jumore.zhxf.repository.oa.TakeVacationDetailRepository;
import com.jumore.zhxf.security.SecurityUtils;
import com.jumore.zhxf.web.rest.dto.oa.EOAConstantHelper.EStatus;
import com.jumore.zhxf.web.rest.dto.oa.TakeVacationDetailDTO;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class TakeVacationDetailService {

	@Inject
	private TakeVacationDetailRepository takeVacationDetailRepository;

	@Inject
	private TakeVacationService takeVacationService;

	private final Logger log = LoggerFactory.getLogger(TakeVacationDetailService.class);

	public TakeVacationDetail create(TakeVacationDetailDTO takeVacationDetailDTO) {

		TakeVacationDetail takeVacationDetail = new TakeVacationDetail();
		takeVacationDetail.setAuditId("1");
		takeVacationDetail.setCreatedBy(SecurityUtils.getCurrentUser().getUsername());
		takeVacationDetail.setEndDate(takeVacationDetailDTO.getEndDate());
		takeVacationDetail.setStartDate(takeVacationDetailDTO.getStartDate());
		takeVacationDetail.setStatus(0);
		Long timesize = takeVacationDetailDTO.getEndDate().getTime() - takeVacationDetailDTO.getStartDate().getTime();
		Long hours = timesize / 1000 / 3600;
		takeVacationDetail.setTimeLength(hours.intValue());
		takeVacationDetail.setRemark(takeVacationDetailDTO.getRemark());

		takeVacationDetailRepository.save(takeVacationDetail);
		log.debug("Created Information for takeVacationDetail: {}", takeVacationDetail);
		return takeVacationDetail;
	}

	public TakeVacationDetail modify(TakeVacationDetailDTO takeVacationDetailDTO) {

		TakeVacationDetail takeVacationDetail = new TakeVacationDetail();
		takeVacationDetail.setCreatedBy(SecurityUtils.getCurrentUser().getUsername());
		takeVacationDetail.setEndDate(takeVacationDetailDTO.getEndDate());
		takeVacationDetail.setStartDate(takeVacationDetailDTO.getStartDate());
		takeVacationDetail.setStatus(takeVacationDetailDTO.getStatus().ordinal());
		takeVacationDetail.setTimeLength(takeVacationDetailDTO.getTimeLength());
		log.debug("Modify Information for takeVacationDetail: {}", takeVacationDetail);
		return takeVacationDetail;
	}

	public Page<TakeVacationDetail> page(TakeVacationDetail takeVacationDetail, Pageable page) {

		return takeVacationDetailRepository.findAll(new Specification<TakeVacationDetail>() {
			@Override
			public Predicate toPredicate(Root<TakeVacationDetail> root,
					javax.persistence.criteria.CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(takeVacationDetail.getCreatedBy())) {
                    final Predicate createdBy = cb.like(root.get("createdBy"), takeVacationDetail.getCreatedBy());
                    predicates.add(createdBy);
                }
                if (null!=takeVacationDetail.getStatus()) {
                    final Predicate status = cb.equal(root.get("status"), takeVacationDetail.getStatus());
                    predicates.add(status);
                }
                if (takeVacationDetail.getStartDate()!=null) {
                	final Predicate startDate = cb.greaterThan(root.get("startDate"), takeVacationDetail.getStartDate());
                    predicates.add(startDate);
                }
                if (takeVacationDetail.getEndDate()!=null) {
                	final Predicate endDate = cb.lessThan(root.get("endDate"), takeVacationDetail.getEndDate());
                    predicates.add(endDate);
                }

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}

		}, page);

	}

	public Page<TakeVacationDetail> findAll(Pageable pageable) {

		return takeVacationDetailRepository.findAll(pageable);
	}
		
	public Page<TakeVacationDetail> findByCreatedBy(String createdBy,Pageable pageable) {
		
		return takeVacationDetailRepository.findByCreatedBy(createdBy,pageable);
	}
	@Transactional(readOnly = true)
	public TakeVacationDetail findTakeVacationDetailById(Long id) {
		TakeVacationDetail takeVacationDetail = takeVacationDetailRepository.findOne(id);
		// workOvertime.getAuthorities().size(); // eagerly load the association
		return takeVacationDetail;
	}

	@Transactional(readOnly = true)
	public TakeVacationDetail updateTakeVacationDetailById(TakeVacationDetailDTO takeVacationDetailDTO) {

		/*if (takeVacationService.checkUsableTimeByUserNmae(
				SecurityUtils.getCurrentUser().getUsername()) < takeVacationDetailDTO.getTimeLength()) {
			throw new RuntimeException(" no Usable time ..");
		}*/
		
		TakeVacationDetail takeVacationDetail = takeVacationDetailRepository.findOne(takeVacationDetailDTO.getId());
		takeVacationDetail.setStartDate(takeVacationDetailDTO.getStartDate());
		takeVacationDetail.setEndDate(takeVacationDetailDTO.getEndDate());
		takeVacationDetail.setRemark(takeVacationDetailDTO.getRemark());
		Long temp = takeVacationDetailDTO.getEndDate().getTime() - takeVacationDetailDTO.getStartDate().getTime(); // 相差毫秒数
		Long hours = temp / 1000 / 3600; // 相差小时数
		takeVacationDetail.setTimeLength(hours.intValue());
		takeVacationDetail.setStatus(EStatus.APPLY.ordinal());
		takeVacationDetailRepository.save(takeVacationDetail);
		return takeVacationDetail;
	}

	public void deleteTakeVacationDetail(Long id) {
		takeVacationDetailRepository.findOneById(id).ifPresent(u -> {
			takeVacationDetailRepository.delete(u);
			log.debug("Deleted User: {}", u);
		});
	}

	/**
	 * 审核对象
	 * 
	 * @param id
	 */
	@Transactional
	public void verify(Long id, TakeVacationDetailDTO takeVacationDetailDTO) {
		//
		TakeVacationDetail t = takeVacationDetailRepository.findOne(id);
		if (t.getStatus() != EStatus.APPLY.ordinal()) {
			return;
		}
		if (takeVacationService.checkUsableTimeByUserNmae(
				t.getCreatedBy()) < t.getTimeLength()) {
			throw new RuntimeException(" no Usable time ..");
		}
		
		int row = takeVacationDetailRepository.updateStatusByKey(takeVacationDetailDTO.getStatus().ordinal(),
				takeVacationDetailDTO.getRemark() == null ? (t.getRemark()==null?"":t.getRemark()) : takeVacationDetailDTO.getRemark(), id);
		// 如果审核通过，更新汇总表
		if (row == 1 && takeVacationDetailDTO.getStatus() == EStatus.PASS) {
			//加班是换分钟统计的，
			int minute=hour2Min(t.getTimeLength());
			takeVacationService.updateById4TakeVacation(t.getCreatedBy(), minute);
		}

	}

	private int hour2Min(Integer hour) {
		return  hour*60;
	}

}
