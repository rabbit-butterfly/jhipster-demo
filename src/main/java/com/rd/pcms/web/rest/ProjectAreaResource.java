package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.ProjectAreaService;
;

import com.rd.pcms.service.dto.ProjectAreaDTO;
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
 * REST controller for managing ProjectArea.
 */
@RestController
@RequestMapping("/api")
public class ProjectAreaResource {

    private final Logger log = LoggerFactory.getLogger(ProjectAreaResource.class);

    private static final String ENTITY_NAME = "projectArea";

    private final ProjectAreaService projectAreaService;

    public ProjectAreaResource(ProjectAreaService projectAreaService) {
        this.projectAreaService = projectAreaService;
    }

    /**
     * POST  /project-areas : Create a new projectArea.
     *
     * @param projectAreaDTO the projectAreaDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new projectAreaDTO, or with status 400 (Bad Request) if the projectArea has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/project-areas")
    @Timed
    public ResponseEntity<ProjectAreaDTO> createProjectArea(@Valid @RequestBody ProjectAreaDTO projectAreaDTO) throws URISyntaxException {
        log.debug("REST request to save ProjectArea : {}", projectAreaDTO);
        if (projectAreaDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new projectArea cannot already have an ID")).body(null);
        }
        ProjectAreaDTO result = projectAreaService.save(projectAreaDTO);
        return ResponseEntity.created(new URI("/api/project-areas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /project-areas : Updates an existing projectArea.
     *
     * @param projectAreaDTO the projectAreaDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated projectAreaDTO,
     * or with status 400 (Bad Request) if the projectAreaDTO is not valid,
     * or with status 500 (Internal Server Error) if the projectAreaDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/project-areas")
    @Timed
    public ResponseEntity<ProjectAreaDTO> updateProjectArea(@Valid @RequestBody ProjectAreaDTO projectAreaDTO) throws URISyntaxException {
        log.debug("REST request to update ProjectArea : {}", projectAreaDTO);
        if (projectAreaDTO.getId() == null) {
            return createProjectArea(projectAreaDTO);
        }
        ProjectAreaDTO result = projectAreaService.save(projectAreaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, projectAreaDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /project-areas : get all the projectAreas.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of projectAreas in body
     */
    @GetMapping("/project-areas")
    @Timed
    public ResponseEntity<List<ProjectAreaDTO>> getAllProjectAreas(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of ProjectAreas");
        Page<ProjectAreaDTO> page = projectAreaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/project-areas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /project-areas/:id : get the "id" projectArea.
     *
     * @param id the id of the projectAreaDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the projectAreaDTO, or with status 404 (Not Found)
     */
    @GetMapping("/project-areas/{id}")
    @Timed
    public ResponseEntity<ProjectAreaDTO> getProjectArea(@PathVariable Long id) {
        log.debug("REST request to get ProjectArea : {}", id);
        ProjectAreaDTO projectAreaDTO = projectAreaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(projectAreaDTO));
    }

    /**
     * DELETE  /project-areas/:id : delete the "id" projectArea.
     *
     * @param id the id of the projectAreaDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/project-areas/{id}")
    @Timed
    public ResponseEntity<Void> deleteProjectArea(@PathVariable Long id) {
        log.debug("REST request to delete ProjectArea : {}", id);
        projectAreaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
