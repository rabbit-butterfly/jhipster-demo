package com.rd.pcms.repository;

import com.rd.pcms.domain.UserArea;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the UserArea entity.
 */
@SuppressWarnings("unused")
public interface UserAreaRepository extends JpaRepository<UserArea,Long> {

}
