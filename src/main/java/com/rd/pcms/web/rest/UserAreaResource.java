package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.rd.pcms.service.UserAreaService;
import com.rd.pcms.service.dto.UserAreaDTO;
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
 * REST controller for managing UserArea.
 */
@RestController
@RequestMapping("/api")
public class UserAreaResource {

    private final Logger log = LoggerFactory.getLogger(UserAreaResource.class);

    private static final String ENTITY_NAME = "userArea";

    private final UserAreaService userAreaService;

    public UserAreaResource(UserAreaService userAreaService) {
        this.userAreaService = userAreaService;
    }

    /**
     * POST  /user-areas : Create a new userArea.
     *
     * @param userAreaDTO the userAreaDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userAreaDTO, or with status 400 (Bad Request) if the userArea has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user-areas")
    @Timed
    public ResponseEntity<UserAreaDTO> createUserArea(@Valid @RequestBody UserAreaDTO userAreaDTO) throws URISyntaxException {
        log.debug("REST request to save UserArea : {}", userAreaDTO);
        if (userAreaDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new userArea cannot already have an ID")).body(null);
        }
        UserAreaDTO result = userAreaService.save(userAreaDTO);
        return ResponseEntity.created(new URI("/api/user-areas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /user-areas : Updates an existing userArea.
     *
     * @param userAreaDTO the userAreaDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userAreaDTO,
     * or with status 400 (Bad Request) if the userAreaDTO is not valid,
     * or with status 500 (Internal Server Error) if the userAreaDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user-areas")
    @Timed
    public ResponseEntity<UserAreaDTO> updateUserArea(@Valid @RequestBody UserAreaDTO userAreaDTO) throws URISyntaxException {
        log.debug("REST request to update UserArea : {}", userAreaDTO);
        if (userAreaDTO.getId() == null) {
            return createUserArea(userAreaDTO);
        }
        UserAreaDTO result = userAreaService.save(userAreaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userAreaDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /user-areas : get all the userAreas.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of userAreas in body
     */
    @GetMapping("/user-areas")
    @Timed
    public ResponseEntity<List<UserAreaDTO>> getAllUserAreas(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of UserAreas");
        Page<UserAreaDTO> page = userAreaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/user-areas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /user-areas/:id : get the "id" userArea.
     *
     * @param id the id of the userAreaDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userAreaDTO, or with status 404 (Not Found)
     */
    @GetMapping("/user-areas/{id}")
    @Timed
    public ResponseEntity<UserAreaDTO> getUserArea(@PathVariable Long id) {
        log.debug("REST request to get UserArea : {}", id);
        UserAreaDTO userAreaDTO = userAreaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(userAreaDTO));
    }

    /**
     * DELETE  /user-areas/:id : delete the "id" userArea.
     *
     * @param id the id of the userAreaDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/user-areas/{id}")
    @Timed
    public ResponseEntity<Void> deleteUserArea(@PathVariable Long id) {
        log.debug("REST request to delete UserArea : {}", id);
        userAreaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
