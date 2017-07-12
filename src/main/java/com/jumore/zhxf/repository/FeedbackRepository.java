package com.jumore.zhxf.repository;

import com.jumore.zhxf.domain.Feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Feedback entity.
 */
@SuppressWarnings("unused")
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

	Page<Feedback> findByUserId(long parseLong, Pageable pageable);

}
