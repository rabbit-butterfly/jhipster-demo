package com.rd.pcms.repository;

import com.rd.pcms.domain.PpGradeMaterail;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpGradeMaterail entity.
 */
@SuppressWarnings("unused")
public interface PpGradeMaterailRepository extends JpaRepository<PpGradeMaterail,Long> {

}
