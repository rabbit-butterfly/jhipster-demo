package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpLineService;
;

import com.rd.pcms.service.dto.PpLineDTO;
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
 * REST controller for managing PpLine.
 */
@RestController
@RequestMapping("/api")
public class PpLineResource {

    private final Logger log = LoggerFactory.getLogger(PpLineResource.class);

    private static final String ENTITY_NAME = "ppLine";

    private final PpLineService ppLineService;

    public PpLineResource(PpLineService ppLineService) {
        this.ppLineService = ppLineService;
    }

    /**
     * POST  /pp-lines : Create a new ppLine.
     *
     * @param ppLineDTO the ppLineDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppLineDTO, or with status 400 (Bad Request) if the ppLine has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-lines")
    @Timed
    public ResponseEntity<PpLineDTO> createPpLine(@Valid @RequestBody PpLineDTO ppLineDTO) throws URISyntaxException {
        log.debug("REST request to save PpLine : {}", ppLineDTO);
        if (ppLineDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppLine cannot already have an ID")).body(null);
        }
        PpLineDTO result = ppLineService.save(ppLineDTO);
        return ResponseEntity.created(new URI("/api/pp-lines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-lines : Updates an existing ppLine.
     *
     * @param ppLineDTO the ppLineDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppLineDTO,
     * or with status 400 (Bad Request) if the ppLineDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppLineDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-lines")
    @Timed
    public ResponseEntity<PpLineDTO> updatePpLine(@Valid @RequestBody PpLineDTO ppLineDTO) throws URISyntaxException {
        log.debug("REST request to update PpLine : {}", ppLineDTO);
        if (ppLineDTO.getId() == null) {
            return createPpLine(ppLineDTO);
        }
        PpLineDTO result = ppLineService.save(ppLineDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppLineDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-lines : get all the ppLines.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppLines in body
     */
    @GetMapping("/pp-lines")
    @Timed
    public ResponseEntity<List<PpLineDTO>> getAllPpLines(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpLines");
        Page<PpLineDTO> page = ppLineService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-lines");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-lines/:id : get the "id" ppLine.
     *
     * @param id the id of the ppLineDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppLineDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-lines/{id}")
    @Timed
    public ResponseEntity<PpLineDTO> getPpLine(@PathVariable Long id) {
        log.debug("REST request to get PpLine : {}", id);
        PpLineDTO ppLineDTO = ppLineService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppLineDTO));
    }

    /**
     * DELETE  /pp-lines/:id : delete the "id" ppLine.
     *
     * @param id the id of the ppLineDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-lines/{id}")
    @Timed
    public ResponseEntity<Void> deletePpLine(@PathVariable Long id) {
        log.debug("REST request to delete PpLine : {}", id);
        ppLineService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
