package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.rd.pcms.service.ProjectWelderService;
import com.rd.pcms.service.dto.ProjectWelderDTO;
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
 * REST controller for managing ProjectWelder.
 */
@RestController
@RequestMapping("/api")
public class ProjectWelderResource {

    private final Logger log = LoggerFactory.getLogger(ProjectWelderResource.class);

    private static final String ENTITY_NAME = "projectWelder";

    private final ProjectWelderService projectWelderService;

    public ProjectWelderResource(ProjectWelderService projectWelderService) {
        this.projectWelderService = projectWelderService;
    }

    /**
     * POST  /project-welders : Create a new projectWelder.
     *
     * @param projectWelderDTO the projectWelderDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new projectWelderDTO, or with status 400 (Bad Request) if the projectWelder has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/project-welders")
    @Timed
    public ResponseEntity<ProjectWelderDTO> createProjectWelder(@Valid @RequestBody ProjectWelderDTO projectWelderDTO) throws URISyntaxException {
        log.debug("REST request to save ProjectWelder : {}", projectWelderDTO);
        if (projectWelderDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new projectWelder cannot already have an ID")).body(null);
        }
        ProjectWelderDTO result = projectWelderService.save(projectWelderDTO);
        return ResponseEntity.created(new URI("/api/project-welders/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /project-welders : Updates an existing projectWelder.
     *
     * @param projectWelderDTO the projectWelderDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated projectWelderDTO,
     * or with status 400 (Bad Request) if the projectWelderDTO is not valid,
     * or with status 500 (Internal Server Error) if the projectWelderDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/project-welders")
    @Timed
    public ResponseEntity<ProjectWelderDTO> updateProjectWelder(@Valid @RequestBody ProjectWelderDTO projectWelderDTO) throws URISyntaxException {
        log.debug("REST request to update ProjectWelder : {}", projectWelderDTO);
        if (projectWelderDTO.getId() == null) {
            return createProjectWelder(projectWelderDTO);
        }
        ProjectWelderDTO result = projectWelderService.save(projectWelderDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, projectWelderDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /project-welders : get all the projectWelders.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of projectWelders in body
     */
    @GetMapping("/project-welders")
    @Timed
    public ResponseEntity<List<ProjectWelderDTO>> getAllProjectWelders(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of ProjectWelders");
        Page<ProjectWelderDTO> page = projectWelderService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/project-welders");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /project-welders/:id : get the "id" projectWelder.
     *
     * @param id the id of the projectWelderDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the projectWelderDTO, or with status 404 (Not Found)
     */
    @GetMapping("/project-welders/{id}")
    @Timed
    public ResponseEntity<ProjectWelderDTO> getProjectWelder(@PathVariable Long id) {
        log.debug("REST request to get ProjectWelder : {}", id);
        ProjectWelderDTO projectWelderDTO = projectWelderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(projectWelderDTO));
    }

    /**
     * DELETE  /project-welders/:id : delete the "id" projectWelder.
     *
     * @param id the id of the projectWelderDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/project-welders/{id}")
    @Timed
    public ResponseEntity<Void> deleteProjectWelder(@PathVariable Long id) {
        log.debug("REST request to delete ProjectWelder : {}", id);
        projectWelderService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
