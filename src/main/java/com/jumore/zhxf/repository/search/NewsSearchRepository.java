package com.jumore.zhxf.repository.search;

import com.jumore.zhxf.domain.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the News entity.
 */
public interface NewsSearchRepository extends ElasticsearchRepository<News, Long> {
}
