package com.rd.pcms.service;

import com.rd.pcms.service.dto.PpInspectionRuleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing PpInspectionRule.
 */
public interface PpInspectionRuleService {

    /**
     * Save a ppInspectionRule.
     *
     * @param ppInspectionRuleDTO the entity to save
     * @return the persisted entity
     */
    PpInspectionRuleDTO save(PpInspectionRuleDTO ppInspectionRuleDTO);

    /**
     *  Get all the ppInspectionRules.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PpInspectionRuleDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" ppInspectionRule.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PpInspectionRuleDTO findOne(Long id);

    /**
     *  Delete the "id" ppInspectionRule.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
