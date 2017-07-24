package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.ProjectUserService;
;

import com.rd.pcms.service.dto.ProjectUserDTO;
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
 * REST controller for managing ProjectUser.
 */
@RestController
@RequestMapping("/api")
public class ProjectUserResource {

    private final Logger log = LoggerFactory.getLogger(ProjectUserResource.class);

    private static final String ENTITY_NAME = "projectUser";

    private final ProjectUserService projectUserService;

    public ProjectUserResource(ProjectUserService projectUserService) {
        this.projectUserService = projectUserService;
    }

    /**
     * POST  /project-users : Create a new projectUser.
     *
     * @param projectUserDTO the projectUserDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new projectUserDTO, or with status 400 (Bad Request) if the projectUser has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/project-users")
    @Timed
    public ResponseEntity<ProjectUserDTO> createProjectUser(@Valid @RequestBody ProjectUserDTO projectUserDTO) throws URISyntaxException {
        log.debug("REST request to save ProjectUser : {}", projectUserDTO);
        if (projectUserDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new projectUser cannot already have an ID")).body(null);
        }
        ProjectUserDTO result = projectUserService.save(projectUserDTO);
        return ResponseEntity.created(new URI("/api/project-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /project-users : Updates an existing projectUser.
     *
     * @param projectUserDTO the projectUserDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated projectUserDTO,
     * or with status 400 (Bad Request) if the projectUserDTO is not valid,
     * or with status 500 (Internal Server Error) if the projectUserDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/project-users")
    @Timed
    public ResponseEntity<ProjectUserDTO> updateProjectUser(@Valid @RequestBody ProjectUserDTO projectUserDTO) throws URISyntaxException {
        log.debug("REST request to update ProjectUser : {}", projectUserDTO);
        if (projectUserDTO.getId() == null) {
            return createProjectUser(projectUserDTO);
        }
        ProjectUserDTO result = projectUserService.save(projectUserDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, projectUserDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /project-users : get all the projectUsers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of projectUsers in body
     */
    @GetMapping("/project-users")
    @Timed
    public ResponseEntity<List<ProjectUserDTO>> getAllProjectUsers(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of ProjectUsers");
        Page<ProjectUserDTO> page = projectUserService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/project-users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /project-users/:id : get the "id" projectUser.
     *
     * @param id the id of the projectUserDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the projectUserDTO, or with status 404 (Not Found)
     */
    @GetMapping("/project-users/{id}")
    @Timed
    public ResponseEntity<ProjectUserDTO> getProjectUser(@PathVariable Long id) {
        log.debug("REST request to get ProjectUser : {}", id);
        ProjectUserDTO projectUserDTO = projectUserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(projectUserDTO));
    }

    /**
     * DELETE  /project-users/:id : delete the "id" projectUser.
     *
     * @param id the id of the projectUserDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/project-users/{id}")
    @Timed
    public ResponseEntity<Void> deleteProjectUser(@PathVariable Long id) {
        log.debug("REST request to delete ProjectUser : {}", id);
        projectUserService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
