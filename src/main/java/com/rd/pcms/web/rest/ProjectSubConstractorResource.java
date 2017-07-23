package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.ProjectSubConstractorService;
;

import com.rd.pcms.service.dto.ProjectSubConstractorDTO;
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
 * REST controller for managing ProjectSubConstractor.
 */
@RestController
@RequestMapping("/api")
public class ProjectSubConstractorResource {

    private final Logger log = LoggerFactory.getLogger(ProjectSubConstractorResource.class);

    private static final String ENTITY_NAME = "projectSubConstractor";

    private final ProjectSubConstractorService projectSubConstractorService;

    public ProjectSubConstractorResource(ProjectSubConstractorService projectSubConstractorService) {
        this.projectSubConstractorService = projectSubConstractorService;
    }

    /**
     * POST  /project-sub-constractors : Create a new projectSubConstractor.
     *
     * @param projectSubConstractorDTO the projectSubConstractorDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new projectSubConstractorDTO, or with status 400 (Bad Request) if the projectSubConstractor has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/project-sub-constractors")
    @Timed
    public ResponseEntity<ProjectSubConstractorDTO> createProjectSubConstractor(@Valid @RequestBody ProjectSubConstractorDTO projectSubConstractorDTO) throws URISyntaxException {
        log.debug("REST request to save ProjectSubConstractor : {}", projectSubConstractorDTO);
        if (projectSubConstractorDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new projectSubConstractor cannot already have an ID")).body(null);
        }
        ProjectSubConstractorDTO result = projectSubConstractorService.save(projectSubConstractorDTO);
        return ResponseEntity.created(new URI("/api/project-sub-constractors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /project-sub-constractors : Updates an existing projectSubConstractor.
     *
     * @param projectSubConstractorDTO the projectSubConstractorDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated projectSubConstractorDTO,
     * or with status 400 (Bad Request) if the projectSubConstractorDTO is not valid,
     * or with status 500 (Internal Server Error) if the projectSubConstractorDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/project-sub-constractors")
    @Timed
    public ResponseEntity<ProjectSubConstractorDTO> updateProjectSubConstractor(@Valid @RequestBody ProjectSubConstractorDTO projectSubConstractorDTO) throws URISyntaxException {
        log.debug("REST request to update ProjectSubConstractor : {}", projectSubConstractorDTO);
        if (projectSubConstractorDTO.getId() == null) {
            return createProjectSubConstractor(projectSubConstractorDTO);
        }
        ProjectSubConstractorDTO result = projectSubConstractorService.save(projectSubConstractorDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, projectSubConstractorDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /project-sub-constractors : get all the projectSubConstractors.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of projectSubConstractors in body
     */
    @GetMapping("/project-sub-constractors")
    @Timed
    public ResponseEntity<List<ProjectSubConstractorDTO>> getAllProjectSubConstractors(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of ProjectSubConstractors");
        Page<ProjectSubConstractorDTO> page = projectSubConstractorService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/project-sub-constractors");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /project-sub-constractors/:id : get the "id" projectSubConstractor.
     *
     * @param id the id of the projectSubConstractorDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the projectSubConstractorDTO, or with status 404 (Not Found)
     */
    @GetMapping("/project-sub-constractors/{id}")
    @Timed
    public ResponseEntity<ProjectSubConstractorDTO> getProjectSubConstractor(@PathVariable Long id) {
        log.debug("REST request to get ProjectSubConstractor : {}", id);
        ProjectSubConstractorDTO projectSubConstractorDTO = projectSubConstractorService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(projectSubConstractorDTO));
    }

    /**
     * DELETE  /project-sub-constractors/:id : delete the "id" projectSubConstractor.
     *
     * @param id the id of the projectSubConstractorDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/project-sub-constractors/{id}")
    @Timed
    public ResponseEntity<Void> deleteProjectSubConstractor(@PathVariable Long id) {
        log.debug("REST request to delete ProjectSubConstractor : {}", id);
        projectSubConstractorService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
