package com.jumore.zhxf.repository.example.cus;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jumore.zhxf.repository.example.BaseRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;




/**
 * @author Niu Li
 * @date 2017/1/7
 */
public class TCityRepositoryImpl extends BaseRepository implements TCityRepositoryCustom {

    @Override
    public List<Tuple> findCityAndHotel(Predicate predicate) {
		return null;
       /* JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<Tuple> jpaQuery = queryFactory.select(QTCity.tCity,QTHotel.tHotel)
                                        .from(QTCity.tCity)
                                        .leftJoin(QTHotel.tHotel)
                                               .on(QTHotel.tHotel.city.longValue().eq(QTCity.tCity.id.longValue()));
        jpaQuery.where(predicate);
        return jpaQuery.fetch();*/
    }

    @Override
    public QueryResults<Tuple> findCityAndHotelPage(Predicate predicate,Pageable pageable) {
		return null;
        /*JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<Tuple> jpaQuery = queryFactory.select(QTCity.tCity.id,QTHotel.tHotel)
                                               .from(QTCity.tCity)
                                               .leftJoin(QTHotel.tHotel)
                                               .on(QTHotel.tHotel.city.longValue().eq(QTCity.tCity.id.longValue()))
                                               .offset(pageable.getOffset())
                                               .limit(pageable.getPageSize());
        return jpaQuery.fetchResults();*/
    }

}