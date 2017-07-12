package com.jumore.zhxf.service.oa;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

import com.jumore.zhxf.domain.oa.WorkOvertime;
import com.jumore.zhxf.repository.oa.WorkOvertimeRepository;
import com.jumore.zhxf.security.SecurityUtils;
import com.jumore.zhxf.web.rest.dto.oa.EOAConstantHelper.EStatus;
import com.jumore.zhxf.web.rest.dto.oa.WorkOvertimeDTO;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class WorkOvertimeService {

	@Inject
	private WorkOvertimeRepository workOvertimeRepository;

	@Inject
	private TakeVacationService takeVacationService;

	private final Logger log = LoggerFactory.getLogger(WorkOvertimeService.class);

	public WorkOvertime create(WorkOvertimeDTO workOvertimeDTO) {

		WorkOvertime workOvertime = new WorkOvertime();

		workOvertime.setCreatedBy(workOvertimeDTO.getCreatedBy());
		workOvertime.setEndDate(workOvertimeDTO.getEndDate());
		workOvertime.setStartDate(workOvertimeDTO.getStartDate());
		workOvertime.setStatus(0);
		Long temp = workOvertimeDTO.getEndDate().getTime() - workOvertimeDTO.getStartDate().getTime(); // 相差毫秒数
		Long min = temp / 1000 / 60;
		//存分钟
		workOvertime.setTimeLength(min.intValue());
		workOvertime.setRemark(workOvertimeDTO.getRemark());

		workOvertimeRepository.save(workOvertime);
		log.debug("Created Information for workOvertime: {}", workOvertime);
		return workOvertime;
	}

	public WorkOvertime modify(WorkOvertimeDTO workOvertimeDTO) {

		WorkOvertime workOvertime = new WorkOvertime();
		workOvertime.setCreatedBy(SecurityUtils.getCurrentUser().getUsername());
		workOvertime.setEndDate(workOvertimeDTO.getEndDate());
		workOvertime.setStartDate(workOvertimeDTO.getStartDate());
		workOvertime.setTimeLength(workOvertimeDTO.getTimeLength());

		log.debug("Modify Information for workOvertime: {}", workOvertime);
		workOvertimeRepository.save(workOvertime);
		workOvertimeRepository.flush();
		return workOvertime;
	}

	public Page<WorkOvertime> page(WorkOvertimeDTO workOvertimeDTO, Pageable page) {
		Specification<WorkOvertime> spec=findByExample(workOvertimeDTO);
		return workOvertimeRepository.findAll(spec, page);
	}
	
	
	
	
	private static Specification<WorkOvertime> findByExample(WorkOvertimeDTO workOvertimeDTO) {
		
        return new Specification<WorkOvertime>() {
			@Override
			public Predicate toPredicate(Root<WorkOvertime> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(workOvertimeDTO.getCreatedBy())) {
                    final Predicate createdBy = cb.like(root.get("createdBy"), workOvertimeDTO.getCreatedBy());
                    predicates.add(createdBy);
                }
                if (null!=workOvertimeDTO.getStatus()) {
                    final Predicate status = cb.equal(root.get("status"), workOvertimeDTO.getStatus().ordinal());
                    predicates.add(status);
                }
                if (workOvertimeDTO.getStartDate()!=null) {
                	final Predicate startDate = cb.greaterThan(root.get("startDate"), workOvertimeDTO.getStartDate());
                    predicates.add(startDate);
                }
                if (workOvertimeDTO.getEndDate()!=null) {
                	final Predicate endDate = cb.lessThan(root.get("endDate"), workOvertimeDTO.getEndDate());
                    predicates.add(endDate);
                }
                
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
        };
    }

	public Page<WorkOvertime> findAll(Pageable pageable) {
		return workOvertimeRepository.findAll(pageable);
	}
	public Page<WorkOvertime> findByCreatedBy(String createdBy,Pageable pageable) {
		
		return workOvertimeRepository.findByCreatedBy(createdBy,pageable);
	}

	

    
    
	public WorkOvertime findWorkOvertimeById(Long id) {
		WorkOvertime workOvertime = workOvertimeRepository.findOne(id);
		return workOvertime;
	}

	public WorkOvertime updateWorkOvertimeById(WorkOvertimeDTO workOvertimeDTO) {
		WorkOvertime workOvertime = workOvertimeRepository.findOne(workOvertimeDTO.getId());
		workOvertime.setStartDate(workOvertimeDTO.getStartDate());
		workOvertime.setEndDate(workOvertimeDTO.getEndDate());
		Long temp = workOvertimeDTO.getEndDate().getTime() - workOvertimeDTO.getStartDate().getTime(); // 相差毫秒数
		Long hours = temp / 1000 / 3600; // 相差小时数
		workOvertime.setTimeLength(hours.intValue());
		workOvertime.setStatus(EStatus.APPLY.ordinal());
		workOvertime.setRemark(workOvertimeDTO.getRemark());

		workOvertimeRepository.save(workOvertime);
		// workOvertimeRepository.saveAndFlush(workOvertime);
		return workOvertime;
	}

	@Transactional
	public void deleteWorkOvertimeInformation(Long id) {
		workOvertimeRepository.findOneById(id).ifPresent(u -> {
			workOvertimeRepository.delete(u);
			log.debug("Deleted WorkOvertime: {}", u);
		});
	}

	public void verify(WorkOvertimeDTO workOvertimeDTO) {

		WorkOvertime t = workOvertimeRepository.findOne(workOvertimeDTO.getId());
		if (t.getStatus() != EStatus.APPLY.ordinal()) {
			return;
		}
		int row = workOvertimeRepository.updateStatusByKey(
				workOvertimeDTO.getStatus().ordinal(), workOvertimeDTO.getRemark() == null
						? (t.getRemark() == null ? "" : t.getRemark()) : workOvertimeDTO.getRemark(),
				workOvertimeDTO.getId());
		// 如果审核通过，更新汇总表
		if (row == 1 && workOvertimeDTO.getStatus() == EStatus.PASS) {

			takeVacationService.updateById4WorkOvertime(t.getCreatedBy(), t.getTimeLength());
		}

	}

}
