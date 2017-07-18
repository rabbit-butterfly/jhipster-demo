package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.rd.pcms.service.PpLineWeldService;
import com.rd.pcms.service.dto.PpLineWeldDTO;
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
 * REST controller for managing PpLineWeld.
 */
@RestController
@RequestMapping("/api")
public class PpLineWeldResource {

    private final Logger log = LoggerFactory.getLogger(PpLineWeldResource.class);

    private static final String ENTITY_NAME = "ppLineWeld";

    private final PpLineWeldService ppLineWeldService;

    public PpLineWeldResource(PpLineWeldService ppLineWeldService) {
        this.ppLineWeldService = ppLineWeldService;
    }

    /**
     * POST  /pp-line-welds : Create a new ppLineWeld.
     *
     * @param ppLineWeldDTO the ppLineWeldDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppLineWeldDTO, or with status 400 (Bad Request) if the ppLineWeld has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-line-welds")
    @Timed
    public ResponseEntity<PpLineWeldDTO> createPpLineWeld(@Valid @RequestBody PpLineWeldDTO ppLineWeldDTO) throws URISyntaxException {
        log.debug("REST request to save PpLineWeld : {}", ppLineWeldDTO);
        if (ppLineWeldDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppLineWeld cannot already have an ID")).body(null);
        }
        PpLineWeldDTO result = ppLineWeldService.save(ppLineWeldDTO);
        return ResponseEntity.created(new URI("/api/pp-line-welds/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-line-welds : Updates an existing ppLineWeld.
     *
     * @param ppLineWeldDTO the ppLineWeldDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppLineWeldDTO,
     * or with status 400 (Bad Request) if the ppLineWeldDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppLineWeldDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-line-welds")
    @Timed
    public ResponseEntity<PpLineWeldDTO> updatePpLineWeld(@Valid @RequestBody PpLineWeldDTO ppLineWeldDTO) throws URISyntaxException {
        log.debug("REST request to update PpLineWeld : {}", ppLineWeldDTO);
        if (ppLineWeldDTO.getId() == null) {
            return createPpLineWeld(ppLineWeldDTO);
        }
        PpLineWeldDTO result = ppLineWeldService.save(ppLineWeldDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppLineWeldDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-line-welds : get all the ppLineWelds.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppLineWelds in body
     */
    @GetMapping("/pp-line-welds")
    @Timed
    public ResponseEntity<List<PpLineWeldDTO>> getAllPpLineWelds(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpLineWelds");
        Page<PpLineWeldDTO> page = ppLineWeldService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-line-welds");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-line-welds/:id : get the "id" ppLineWeld.
     *
     * @param id the id of the ppLineWeldDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppLineWeldDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-line-welds/{id}")
    @Timed
    public ResponseEntity<PpLineWeldDTO> getPpLineWeld(@PathVariable Long id) {
        log.debug("REST request to get PpLineWeld : {}", id);
        PpLineWeldDTO ppLineWeldDTO = ppLineWeldService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppLineWeldDTO));
    }

    /**
     * DELETE  /pp-line-welds/:id : delete the "id" ppLineWeld.
     *
     * @param id the id of the ppLineWeldDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-line-welds/{id}")
    @Timed
    public ResponseEntity<Void> deletePpLineWeld(@PathVariable Long id) {
        log.debug("REST request to delete PpLineWeld : {}", id);
        ppLineWeldService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
