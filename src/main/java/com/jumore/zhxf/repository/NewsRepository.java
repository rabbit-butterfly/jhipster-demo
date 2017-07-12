package com.jumore.zhxf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jumore.zhxf.domain.News;

/**
 * Spring Data JPA repository for the News entity.
 */
public interface NewsRepository extends JpaRepository<News, Long> {
	Page<News> findAllByStatus(Integer status,Pageable pageable);

	Page<News> findByCategoryIdAndStatus(Long categoryId, Integer status, Pageable pageable);

}
