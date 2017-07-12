package com.jumore.zhxf.repository.example.cus;


import java.util.List;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.QueryResults;

import com.querydsl.core.Tuple;

/**
 * @author Niu Li
 * @date 2017/1/7
 */
public interface TCityRepositoryCustom {
    /**
     * 关联查询示例,查询出城市和对应的旅店
     * @param predicate 查询条件
     * @return 查询实体
     */
    public List<Tuple> findCityAndHotel(Predicate predicate);

    /**
     * 关联查询示例,查询出城市和对应的旅店
     * @param predicate 查询条件
     * @return 查询实体
     */
    public QueryResults<Tuple> findCityAndHotelPage(Predicate predicate,Pageable pageable);
}