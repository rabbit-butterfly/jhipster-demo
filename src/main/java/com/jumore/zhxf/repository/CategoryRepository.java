package com.jumore.zhxf.repository;

import com.jumore.zhxf.domain.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Category entity.
 */
@SuppressWarnings("unused")
public interface CategoryRepository extends JpaRepository<Category,Long> {

	Page<Category> findAllByParentIdAndStatus(Long parentId,Integer status,Pageable pageable);

	Page<Category> findAllByParentId(Long parentId,Pageable pageable);
}
