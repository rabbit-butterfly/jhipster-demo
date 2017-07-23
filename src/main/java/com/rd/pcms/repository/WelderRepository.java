package com.rd.pcms.repository;

import com.rd.pcms.domain.Welder;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Welder entity.
 */
@SuppressWarnings("unused")
public interface WelderRepository extends JpaRepository<Welder,Long> {

}
