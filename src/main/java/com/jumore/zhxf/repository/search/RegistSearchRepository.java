package com.jumore.zhxf.repository.search;

import com.jumore.zhxf.domain.Regist;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the Regist entity.
 */
public interface RegistSearchRepository extends ElasticsearchRepository<Regist, Long> {
}
