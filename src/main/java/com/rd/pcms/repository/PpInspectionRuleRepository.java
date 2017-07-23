package com.rd.pcms.repository;

import com.rd.pcms.domain.PpInspectionRule;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PpInspectionRule entity.
 */
@SuppressWarnings("unused")
public interface PpInspectionRuleRepository extends JpaRepository<PpInspectionRule,Long> {

}
