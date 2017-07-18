package com.rd.pcms.service;

import com.rd.pcms.service.dto.WelderSkillDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing WelderSkill.
 */
public interface WelderSkillService {

    /**
     * Save a welderSkill.
     *
     * @param welderSkillDTO the entity to save
     * @return the persisted entity
     */
    WelderSkillDTO save(WelderSkillDTO welderSkillDTO);

    /**
     *  Get all the welderSkills.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<WelderSkillDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" welderSkill.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    WelderSkillDTO findOne(Long id);

    /**
     *  Delete the "id" welderSkill.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
