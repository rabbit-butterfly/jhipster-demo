package com.jumore.zhxf.repository.oa;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jumore.zhxf.domain.oa.TakeVacationDetail;

/**
 * Spring Data JPA repository for the TakeVacationDetail entity.
 */
public interface TakeVacationDetailRepository extends JpaRepository<TakeVacationDetail, Long> {

	// void findAll(Specification<WorkOvertime> specification, Pageable page);

	Page<TakeVacationDetail> findAll(Specification<TakeVacationDetail> spec, Pageable pageable); // 分页按条件查询
	
	Optional<TakeVacationDetail> findOneById(Long userId);

	@Modifying(clearAutomatically = true)
	@Query("update TakeVacationDetail set status = :status,remark= :remark  where id = :id")
	int updateStatusByKey(@Param("status") Integer status,@Param("remark") String remark,  @Param("id") Long id);
	
	Page<TakeVacationDetail> findByCreatedBy(String createdBy, Pageable pageable);

}
