package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpInspectionRuleService;
;

import com.rd.pcms.service.dto.PpInspectionRuleDTO;
import io.swagger.annotations.ApiParam;
;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing PpInspectionRule.
 */
@RestController
@RequestMapping("/api")
public class PpInspectionRuleResource {

    private final Logger log = LoggerFactory.getLogger(PpInspectionRuleResource.class);

    private static final String ENTITY_NAME = "ppInspectionRule";

    private final PpInspectionRuleService ppInspectionRuleService;

    public PpInspectionRuleResource(PpInspectionRuleService ppInspectionRuleService) {
        this.ppInspectionRuleService = ppInspectionRuleService;
    }

    /**
     * POST  /pp-inspection-rules : Create a new ppInspectionRule.
     *
     * @param ppInspectionRuleDTO the ppInspectionRuleDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppInspectionRuleDTO, or with status 400 (Bad Request) if the ppInspectionRule has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-inspection-rules")
    @Timed
    public ResponseEntity<PpInspectionRuleDTO> createPpInspectionRule(@Valid @RequestBody PpInspectionRuleDTO ppInspectionRuleDTO) throws URISyntaxException {
        log.debug("REST request to save PpInspectionRule : {}", ppInspectionRuleDTO);
        if (ppInspectionRuleDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppInspectionRule cannot already have an ID")).body(null);
        }
        PpInspectionRuleDTO result = ppInspectionRuleService.save(ppInspectionRuleDTO);
        return ResponseEntity.created(new URI("/api/pp-inspection-rules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-inspection-rules : Updates an existing ppInspectionRule.
     *
     * @param ppInspectionRuleDTO the ppInspectionRuleDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppInspectionRuleDTO,
     * or with status 400 (Bad Request) if the ppInspectionRuleDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppInspectionRuleDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-inspection-rules")
    @Timed
    public ResponseEntity<PpInspectionRuleDTO> updatePpInspectionRule(@Valid @RequestBody PpInspectionRuleDTO ppInspectionRuleDTO) throws URISyntaxException {
        log.debug("REST request to update PpInspectionRule : {}", ppInspectionRuleDTO);
        if (ppInspectionRuleDTO.getId() == null) {
            return createPpInspectionRule(ppInspectionRuleDTO);
        }
        PpInspectionRuleDTO result = ppInspectionRuleService.save(ppInspectionRuleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppInspectionRuleDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-inspection-rules : get all the ppInspectionRules.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppInspectionRules in body
     */
    @GetMapping("/pp-inspection-rules")
    @Timed
    public ResponseEntity<List<PpInspectionRuleDTO>> getAllPpInspectionRules(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpInspectionRules");
        Page<PpInspectionRuleDTO> page = ppInspectionRuleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-inspection-rules");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-inspection-rules/:id : get the "id" ppInspectionRule.
     *
     * @param id the id of the ppInspectionRuleDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppInspectionRuleDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-inspection-rules/{id}")
    @Timed
    public ResponseEntity<PpInspectionRuleDTO> getPpInspectionRule(@PathVariable Long id) {
        log.debug("REST request to get PpInspectionRule : {}", id);
        PpInspectionRuleDTO ppInspectionRuleDTO = ppInspectionRuleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppInspectionRuleDTO));
    }

    /**
     * DELETE  /pp-inspection-rules/:id : delete the "id" ppInspectionRule.
     *
     * @param id the id of the ppInspectionRuleDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-inspection-rules/{id}")
    @Timed
    public ResponseEntity<Void> deletePpInspectionRule(@PathVariable Long id) {
        log.debug("REST request to delete PpInspectionRule : {}", id);
        ppInspectionRuleService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
