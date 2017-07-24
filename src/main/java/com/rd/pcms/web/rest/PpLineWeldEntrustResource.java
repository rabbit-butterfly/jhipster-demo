package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpLineWeldEntrustService;
;

import com.rd.pcms.service.dto.PpLineWeldEntrustDTO;
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
 * REST controller for managing PpLineWeldEntrust.
 */
@RestController
@RequestMapping("/api")
public class PpLineWeldEntrustResource {

    private final Logger log = LoggerFactory.getLogger(PpLineWeldEntrustResource.class);

    private static final String ENTITY_NAME = "ppLineWeldEntrust";

    private final PpLineWeldEntrustService ppLineWeldEntrustService;

    public PpLineWeldEntrustResource(PpLineWeldEntrustService ppLineWeldEntrustService) {
        this.ppLineWeldEntrustService = ppLineWeldEntrustService;
    }

    /**
     * POST  /pp-line-weld-entrusts : Create a new ppLineWeldEntrust.
     *
     * @param ppLineWeldEntrustDTO the ppLineWeldEntrustDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppLineWeldEntrustDTO, or with status 400 (Bad Request) if the ppLineWeldEntrust has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-line-weld-entrusts")
    @Timed
    public ResponseEntity<PpLineWeldEntrustDTO> createPpLineWeldEntrust(@Valid @RequestBody PpLineWeldEntrustDTO ppLineWeldEntrustDTO) throws URISyntaxException {
        log.debug("REST request to save PpLineWeldEntrust : {}", ppLineWeldEntrustDTO);
        if (ppLineWeldEntrustDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppLineWeldEntrust cannot already have an ID")).body(null);
        }
        PpLineWeldEntrustDTO result = ppLineWeldEntrustService.save(ppLineWeldEntrustDTO);
        return ResponseEntity.created(new URI("/api/pp-line-weld-entrusts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-line-weld-entrusts : Updates an existing ppLineWeldEntrust.
     *
     * @param ppLineWeldEntrustDTO the ppLineWeldEntrustDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppLineWeldEntrustDTO,
     * or with status 400 (Bad Request) if the ppLineWeldEntrustDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppLineWeldEntrustDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-line-weld-entrusts")
    @Timed
    public ResponseEntity<PpLineWeldEntrustDTO> updatePpLineWeldEntrust(@Valid @RequestBody PpLineWeldEntrustDTO ppLineWeldEntrustDTO) throws URISyntaxException {
        log.debug("REST request to update PpLineWeldEntrust : {}", ppLineWeldEntrustDTO);
        if (ppLineWeldEntrustDTO.getId() == null) {
            return createPpLineWeldEntrust(ppLineWeldEntrustDTO);
        }
        PpLineWeldEntrustDTO result = ppLineWeldEntrustService.save(ppLineWeldEntrustDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppLineWeldEntrustDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-line-weld-entrusts : get all the ppLineWeldEntrusts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppLineWeldEntrusts in body
     */
    @GetMapping("/pp-line-weld-entrusts")
    @Timed
    public ResponseEntity<List<PpLineWeldEntrustDTO>> getAllPpLineWeldEntrusts(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpLineWeldEntrusts");
        Page<PpLineWeldEntrustDTO> page = ppLineWeldEntrustService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-line-weld-entrusts");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-line-weld-entrusts/:id : get the "id" ppLineWeldEntrust.
     *
     * @param id the id of the ppLineWeldEntrustDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppLineWeldEntrustDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-line-weld-entrusts/{id}")
    @Timed
    public ResponseEntity<PpLineWeldEntrustDTO> getPpLineWeldEntrust(@PathVariable Long id) {
        log.debug("REST request to get PpLineWeldEntrust : {}", id);
        PpLineWeldEntrustDTO ppLineWeldEntrustDTO = ppLineWeldEntrustService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppLineWeldEntrustDTO));
    }

    /**
     * DELETE  /pp-line-weld-entrusts/:id : delete the "id" ppLineWeldEntrust.
     *
     * @param id the id of the ppLineWeldEntrustDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-line-weld-entrusts/{id}")
    @Timed
    public ResponseEntity<Void> deletePpLineWeldEntrust(@PathVariable Long id) {
        log.debug("REST request to delete PpLineWeldEntrust : {}", id);
        ppLineWeldEntrustService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
