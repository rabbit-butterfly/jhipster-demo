package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.rd.pcms.service.WelderSkillService;
import com.rd.pcms.service.dto.WelderSkillDTO;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
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
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing WelderSkill.
 */
@RestController
@RequestMapping("/api")
public class WelderSkillResource {

    private final Logger log = LoggerFactory.getLogger(WelderSkillResource.class);

    private static final String ENTITY_NAME = "welderSkill";

    private final WelderSkillService welderSkillService;

    public WelderSkillResource(WelderSkillService welderSkillService) {
        this.welderSkillService = welderSkillService;
    }

    /**
     * POST  /welder-skills : Create a new welderSkill.
     *
     * @param welderSkillDTO the welderSkillDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new welderSkillDTO, or with status 400 (Bad Request) if the welderSkill has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/welder-skills")
    @Timed
    public ResponseEntity<WelderSkillDTO> createWelderSkill(@Valid @RequestBody WelderSkillDTO welderSkillDTO) throws URISyntaxException {
        log.debug("REST request to save WelderSkill : {}", welderSkillDTO);
        if (welderSkillDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new welderSkill cannot already have an ID")).body(null);
        }
        WelderSkillDTO result = welderSkillService.save(welderSkillDTO);
        return ResponseEntity.created(new URI("/api/welder-skills/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /welder-skills : Updates an existing welderSkill.
     *
     * @param welderSkillDTO the welderSkillDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated welderSkillDTO,
     * or with status 400 (Bad Request) if the welderSkillDTO is not valid,
     * or with status 500 (Internal Server Error) if the welderSkillDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/welder-skills")
    @Timed
    public ResponseEntity<WelderSkillDTO> updateWelderSkill(@Valid @RequestBody WelderSkillDTO welderSkillDTO) throws URISyntaxException {
        log.debug("REST request to update WelderSkill : {}", welderSkillDTO);
        if (welderSkillDTO.getId() == null) {
            return createWelderSkill(welderSkillDTO);
        }
        WelderSkillDTO result = welderSkillService.save(welderSkillDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, welderSkillDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /welder-skills : get all the welderSkills.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of welderSkills in body
     */
    @GetMapping("/welder-skills")
    @Timed
    public ResponseEntity<List<WelderSkillDTO>> getAllWelderSkills(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of WelderSkills");
        Page<WelderSkillDTO> page = welderSkillService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/welder-skills");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /welder-skills/:id : get the "id" welderSkill.
     *
     * @param id the id of the welderSkillDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the welderSkillDTO, or with status 404 (Not Found)
     */
    @GetMapping("/welder-skills/{id}")
    @Timed
    public ResponseEntity<WelderSkillDTO> getWelderSkill(@PathVariable Long id) {
        log.debug("REST request to get WelderSkill : {}", id);
        WelderSkillDTO welderSkillDTO = welderSkillService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(welderSkillDTO));
    }

    /**
     * DELETE  /welder-skills/:id : delete the "id" welderSkill.
     *
     * @param id the id of the welderSkillDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/welder-skills/{id}")
    @Timed
    public ResponseEntity<Void> deleteWelderSkill(@PathVariable Long id) {
        log.debug("REST request to delete WelderSkill : {}", id);
        welderSkillService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
