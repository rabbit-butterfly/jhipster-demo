package com.jumore.zhxf.repository.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.querydsl.core.types.Predicate;

import com.jumore.zhxf.domain.example.TCity;
import com.jumore.zhxf.repository.example.cus.TCityRepositoryCustom;

/*public interface TCityRepository
		extends JpaRepository<com.jumore.zhxf.domain.example.TCity, Long>, TCityRepositoryCustom {

}*/

/**
 * @author Niu Li
 * @date 2017/1/7
 */
public interface TCityRepository extends JpaRepository<com.jumore.zhxf.domain.example.TCity, Long>,
 //org.springframework.data.querydsl.QueryDslPredicateExecutor<com.jumore.zhxf.domain.example.TCity>,
 TCityRepositoryCustom {

	//Page<TCity> findAll(Predicate predicate, PageRequest pageRequest);

}