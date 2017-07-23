package com.rd.pcms.repository;

import com.rd.pcms.domain.WelderSkill;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the WelderSkill entity.
 */
@SuppressWarnings("unused")
public interface WelderSkillRepository extends JpaRepository<WelderSkill,Long> {

}
