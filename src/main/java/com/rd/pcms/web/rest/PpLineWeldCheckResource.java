package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpLineWeldCheckService;
;

import com.rd.pcms.service.dto.PpLineWeldCheckDTO;
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
 * REST controller for managing PpLineWeldCheck.
 */
@RestController
@RequestMapping("/api")
public class PpLineWeldCheckResource {

    private final Logger log = LoggerFactory.getLogger(PpLineWeldCheckResource.class);

    private static final String ENTITY_NAME = "ppLineWeldCheck";

    private final PpLineWeldCheckService ppLineWeldCheckService;

    public PpLineWeldCheckResource(PpLineWeldCheckService ppLineWeldCheckService) {
        this.ppLineWeldCheckService = ppLineWeldCheckService;
    }

    /**
     * POST  /pp-line-weld-checks : Create a new ppLineWeldCheck.
     *
     * @param ppLineWeldCheckDTO the ppLineWeldCheckDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppLineWeldCheckDTO, or with status 400 (Bad Request) if the ppLineWeldCheck has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-line-weld-checks")
    @Timed
    public ResponseEntity<PpLineWeldCheckDTO> createPpLineWeldCheck(@Valid @RequestBody PpLineWeldCheckDTO ppLineWeldCheckDTO) throws URISyntaxException {
        log.debug("REST request to save PpLineWeldCheck : {}", ppLineWeldCheckDTO);
        if (ppLineWeldCheckDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppLineWeldCheck cannot already have an ID")).body(null);
        }
        PpLineWeldCheckDTO result = ppLineWeldCheckService.save(ppLineWeldCheckDTO);
        return ResponseEntity.created(new URI("/api/pp-line-weld-checks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-line-weld-checks : Updates an existing ppLineWeldCheck.
     *
     * @param ppLineWeldCheckDTO the ppLineWeldCheckDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppLineWeldCheckDTO,
     * or with status 400 (Bad Request) if the ppLineWeldCheckDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppLineWeldCheckDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-line-weld-checks")
    @Timed
    public ResponseEntity<PpLineWeldCheckDTO> updatePpLineWeldCheck(@Valid @RequestBody PpLineWeldCheckDTO ppLineWeldCheckDTO) throws URISyntaxException {
        log.debug("REST request to update PpLineWeldCheck : {}", ppLineWeldCheckDTO);
        if (ppLineWeldCheckDTO.getId() == null) {
            return createPpLineWeldCheck(ppLineWeldCheckDTO);
        }
        PpLineWeldCheckDTO result = ppLineWeldCheckService.save(ppLineWeldCheckDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppLineWeldCheckDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-line-weld-checks : get all the ppLineWeldChecks.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppLineWeldChecks in body
     */
    @GetMapping("/pp-line-weld-checks")
    @Timed
    public ResponseEntity<List<PpLineWeldCheckDTO>> getAllPpLineWeldChecks(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpLineWeldChecks");
        Page<PpLineWeldCheckDTO> page = ppLineWeldCheckService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-line-weld-checks");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-line-weld-checks/:id : get the "id" ppLineWeldCheck.
     *
     * @param id the id of the ppLineWeldCheckDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppLineWeldCheckDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-line-weld-checks/{id}")
    @Timed
    public ResponseEntity<PpLineWeldCheckDTO> getPpLineWeldCheck(@PathVariable Long id) {
        log.debug("REST request to get PpLineWeldCheck : {}", id);
        PpLineWeldCheckDTO ppLineWeldCheckDTO = ppLineWeldCheckService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppLineWeldCheckDTO));
    }

    /**
     * DELETE  /pp-line-weld-checks/:id : delete the "id" ppLineWeldCheck.
     *
     * @param id the id of the ppLineWeldCheckDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-line-weld-checks/{id}")
    @Timed
    public ResponseEntity<Void> deletePpLineWeldCheck(@PathVariable Long id) {
        log.debug("REST request to delete PpLineWeldCheck : {}", id);
        ppLineWeldCheckService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
