package com.rd.pcms.repository;

import com.rd.pcms.domain.UserPower;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the UserPower entity.
 */
@SuppressWarnings("unused")
public interface UserPowerRepository extends JpaRepository<UserPower,Long> {

}
