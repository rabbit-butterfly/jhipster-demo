package com.jumore.zhxf.repository.oa;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jumore.zhxf.domain.oa.WorkOvertime;

/**
 * Spring Data JPA repository for the WorkOvertime entity.
 */
public interface WorkOvertimeRepository extends JpaRepository<WorkOvertime, Long> {

	//void findAll(Specification<WorkOvertime> specification, Pageable page);

	Page<WorkOvertime> findAll(Specification<WorkOvertime> spec, Pageable pageable); // 分页按条件查询
	
	Optional<WorkOvertime> findOneById(Long userId);

	@Modifying(clearAutomatically = true)
	@Query("update WorkOvertime set status = :status ,remark = :remark  where id = :id")
	int updateStatusByKey(@Param("status") Integer status,@Param("remark") String remark,  @Param("id") Long id);

	Page<WorkOvertime> findByCreatedBy(String createdBy, Pageable pageable);


}
