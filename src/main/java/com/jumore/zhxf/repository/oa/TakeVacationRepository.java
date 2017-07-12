package com.jumore.zhxf.repository.oa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jumore.zhxf.domain.oa.TakeVacation;
import com.jumore.zhxf.web.rest.dto.oa.TakeVacationDTO;

/**
 * Spring Data JPA repository for the Tak8eVacationDetail entity.
 */
public interface TakeVacationRepository extends JpaRepository<TakeVacation, Long> {

	//@SQLUpdate(sql="")
	//void update(TakeVacation takeVacation);
	
	/**
	 *  调休汇总表
	 * @param userable  可调休时间OSS	
	 * @param totalHour 加班总时间
	 * @param used      已调休时间
	 * @param userId    用户ID
	 * @return
	 */
	@Modifying(clearAutomatically = true) 
	@Query("update TakeVacation takeVacation "
			+ " set takeVacation.usable = usable +  :usable,"
			+ " 	takeVacation.totalHour =totalHour +  :totalHour,"
			+ "     takeVacation.used =used + :used "
			+ " where takeVacation.userId = :userId")  
	int update(@Param("usable") Integer usable, @Param("totalHour") Integer totalHour,@Param("used") Integer used, @Param("userId") Long userId);
	
	Page<TakeVacation> findAll(Specification<TakeVacationDTO> spec, Pageable pageable); // 分页按条件查询
    
	TakeVacation findOneByUserId(Long userId);
    
	Page<TakeVacation> findByCreatedBy(String createdBy, Pageable pageable);
	
	@Query(value="select 0 as user_id, null as created_by,sum(total_hour) as total_hour,sum(usable) as usable,sum(used) as used,null as last_midfy_date from oa_take_vacation", nativeQuery = true)  

	TakeVacation findAllOne();
	 
}
