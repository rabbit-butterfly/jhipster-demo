package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.rd.pcms.service.ProjectMaterialService;
import com.rd.pcms.service.dto.ProjectMaterialDTO;
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
 * REST controller for managing ProjectMaterial.
 */
@RestController
@RequestMapping("/api")
public class ProjectMaterialResource {

    private final Logger log = LoggerFactory.getLogger(ProjectMaterialResource.class);

    private static final String ENTITY_NAME = "projectMaterial";

    private final ProjectMaterialService projectMaterialService;

    public ProjectMaterialResource(ProjectMaterialService projectMaterialService) {
        this.projectMaterialService = projectMaterialService;
    }

    /**
     * POST  /project-materials : Create a new projectMaterial.
     *
     * @param projectMaterialDTO the projectMaterialDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new projectMaterialDTO, or with status 400 (Bad Request) if the projectMaterial has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/project-materials")
    @Timed
    public ResponseEntity<ProjectMaterialDTO> createProjectMaterial(@Valid @RequestBody ProjectMaterialDTO projectMaterialDTO) throws URISyntaxException {
        log.debug("REST request to save ProjectMaterial : {}", projectMaterialDTO);
        if (projectMaterialDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new projectMaterial cannot already have an ID")).body(null);
        }
        ProjectMaterialDTO result = projectMaterialService.save(projectMaterialDTO);
        return ResponseEntity.created(new URI("/api/project-materials/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /project-materials : Updates an existing projectMaterial.
     *
     * @param projectMaterialDTO the projectMaterialDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated projectMaterialDTO,
     * or with status 400 (Bad Request) if the projectMaterialDTO is not valid,
     * or with status 500 (Internal Server Error) if the projectMaterialDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/project-materials")
    @Timed
    public ResponseEntity<ProjectMaterialDTO> updateProjectMaterial(@Valid @RequestBody ProjectMaterialDTO projectMaterialDTO) throws URISyntaxException {
        log.debug("REST request to update ProjectMaterial : {}", projectMaterialDTO);
        if (projectMaterialDTO.getId() == null) {
            return createProjectMaterial(projectMaterialDTO);
        }
        ProjectMaterialDTO result = projectMaterialService.save(projectMaterialDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, projectMaterialDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /project-materials : get all the projectMaterials.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of projectMaterials in body
     */
    @GetMapping("/project-materials")
    @Timed
    public ResponseEntity<List<ProjectMaterialDTO>> getAllProjectMaterials(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of ProjectMaterials");
        Page<ProjectMaterialDTO> page = projectMaterialService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/project-materials");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /project-materials/:id : get the "id" projectMaterial.
     *
     * @param id the id of the projectMaterialDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the projectMaterialDTO, or with status 404 (Not Found)
     */
    @GetMapping("/project-materials/{id}")
    @Timed
    public ResponseEntity<ProjectMaterialDTO> getProjectMaterial(@PathVariable Long id) {
        log.debug("REST request to get ProjectMaterial : {}", id);
        ProjectMaterialDTO projectMaterialDTO = projectMaterialService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(projectMaterialDTO));
    }

    /**
     * DELETE  /project-materials/:id : delete the "id" projectMaterial.
     *
     * @param id the id of the projectMaterialDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/project-materials/{id}")
    @Timed
    public ResponseEntity<Void> deleteProjectMaterial(@PathVariable Long id) {
        log.debug("REST request to delete ProjectMaterial : {}", id);
        projectMaterialService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
