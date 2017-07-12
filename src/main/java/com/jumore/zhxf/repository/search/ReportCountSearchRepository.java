package com.jumore.zhxf.repository.search;

import com.jumore.zhxf.domain.ReportCount;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the ReportCount entity.
 */
public interface ReportCountSearchRepository extends ElasticsearchRepository<ReportCount, Long> {
}
