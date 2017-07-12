package com.jumore.zhxf.repository.search;

import com.jumore.zhxf.domain.Member;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the Member entity.
 */
public interface MemberSearchRepository extends ElasticsearchRepository<Member, Long> {
}
