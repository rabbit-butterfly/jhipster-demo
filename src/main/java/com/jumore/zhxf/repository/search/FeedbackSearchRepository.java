package com.jumore.zhxf.repository.search;

import com.jumore.zhxf.domain.Feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the Feedback entity.
 */
public interface FeedbackSearchRepository extends ElasticsearchRepository<Feedback, Long> {

	Page<Feedback> findByUserId(long parseLong, Pageable pageable);
}
