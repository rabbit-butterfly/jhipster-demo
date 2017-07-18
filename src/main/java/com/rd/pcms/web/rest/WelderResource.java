package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.rd.pcms.service.WelderService;
import com.rd.pcms.service.dto.WelderDTO;
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
 * REST controller for managing Welder.
 */
@RestController
@RequestMapping("/api")
public class WelderResource {

    private final Logger log = LoggerFactory.getLogger(WelderResource.class);

    private static final String ENTITY_NAME = "welder";

    private final WelderService welderService;

    public WelderResource(WelderService welderService) {
        this.welderService = welderService;
    }

    /**
     * POST  /welders : Create a new welder.
     *
     * @param welderDTO the welderDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new welderDTO, or with status 400 (Bad Request) if the welder has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/welders")
    @Timed
    public ResponseEntity<WelderDTO> createWelder(@Valid @RequestBody WelderDTO welderDTO) throws URISyntaxException {
        log.debug("REST request to save Welder : {}", welderDTO);
        if (welderDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new welder cannot already have an ID")).body(null);
        }
        WelderDTO result = welderService.save(welderDTO);
        return ResponseEntity.created(new URI("/api/welders/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /welders : Updates an existing welder.
     *
     * @param welderDTO the welderDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated welderDTO,
     * or with status 400 (Bad Request) if the welderDTO is not valid,
     * or with status 500 (Internal Server Error) if the welderDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/welders")
    @Timed
    public ResponseEntity<WelderDTO> updateWelder(@Valid @RequestBody WelderDTO welderDTO) throws URISyntaxException {
        log.debug("REST request to update Welder : {}", welderDTO);
        if (welderDTO.getId() == null) {
            return createWelder(welderDTO);
        }
        WelderDTO result = welderService.save(welderDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, welderDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /welders : get all the welders.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of welders in body
     */
    @GetMapping("/welders")
    @Timed
    public ResponseEntity<List<WelderDTO>> getAllWelders(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of Welders");
        Page<WelderDTO> page = welderService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/welders");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /welders/:id : get the "id" welder.
     *
     * @param id the id of the welderDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the welderDTO, or with status 404 (Not Found)
     */
    @GetMapping("/welders/{id}")
    @Timed
    public ResponseEntity<WelderDTO> getWelder(@PathVariable Long id) {
        log.debug("REST request to get Welder : {}", id);
        WelderDTO welderDTO = welderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(welderDTO));
    }

    /**
     * DELETE  /welders/:id : delete the "id" welder.
     *
     * @param id the id of the welderDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/welders/{id}")
    @Timed
    public ResponseEntity<Void> deleteWelder(@PathVariable Long id) {
        log.debug("REST request to delete Welder : {}", id);
        welderService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
