package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpLineDrawingService;
;

import com.rd.pcms.service.dto.PpLineDrawingDTO;
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
 * REST controller for managing PpLineDrawing.
 */
@RestController
@RequestMapping("/api")
public class PpLineDrawingResource {

    private final Logger log = LoggerFactory.getLogger(PpLineDrawingResource.class);

    private static final String ENTITY_NAME = "ppLineDrawing";

    private final PpLineDrawingService ppLineDrawingService;

    public PpLineDrawingResource(PpLineDrawingService ppLineDrawingService) {
        this.ppLineDrawingService = ppLineDrawingService;
    }

    /**
     * POST  /pp-line-drawings : Create a new ppLineDrawing.
     *
     * @param ppLineDrawingDTO the ppLineDrawingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppLineDrawingDTO, or with status 400 (Bad Request) if the ppLineDrawing has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-line-drawings")
    @Timed
    public ResponseEntity<PpLineDrawingDTO> createPpLineDrawing(@Valid @RequestBody PpLineDrawingDTO ppLineDrawingDTO) throws URISyntaxException {
        log.debug("REST request to save PpLineDrawing : {}", ppLineDrawingDTO);
        if (ppLineDrawingDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppLineDrawing cannot already have an ID")).body(null);
        }
        PpLineDrawingDTO result = ppLineDrawingService.save(ppLineDrawingDTO);
        return ResponseEntity.created(new URI("/api/pp-line-drawings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-line-drawings : Updates an existing ppLineDrawing.
     *
     * @param ppLineDrawingDTO the ppLineDrawingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppLineDrawingDTO,
     * or with status 400 (Bad Request) if the ppLineDrawingDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppLineDrawingDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-line-drawings")
    @Timed
    public ResponseEntity<PpLineDrawingDTO> updatePpLineDrawing(@Valid @RequestBody PpLineDrawingDTO ppLineDrawingDTO) throws URISyntaxException {
        log.debug("REST request to update PpLineDrawing : {}", ppLineDrawingDTO);
        if (ppLineDrawingDTO.getId() == null) {
            return createPpLineDrawing(ppLineDrawingDTO);
        }
        PpLineDrawingDTO result = ppLineDrawingService.save(ppLineDrawingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppLineDrawingDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-line-drawings : get all the ppLineDrawings.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppLineDrawings in body
     */
    @GetMapping("/pp-line-drawings")
    @Timed
    public ResponseEntity<List<PpLineDrawingDTO>> getAllPpLineDrawings(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpLineDrawings");
        Page<PpLineDrawingDTO> page = ppLineDrawingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-line-drawings");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-line-drawings/:id : get the "id" ppLineDrawing.
     *
     * @param id the id of the ppLineDrawingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppLineDrawingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-line-drawings/{id}")
    @Timed
    public ResponseEntity<PpLineDrawingDTO> getPpLineDrawing(@PathVariable Long id) {
        log.debug("REST request to get PpLineDrawing : {}", id);
        PpLineDrawingDTO ppLineDrawingDTO = ppLineDrawingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppLineDrawingDTO));
    }

    /**
     * DELETE  /pp-line-drawings/:id : delete the "id" ppLineDrawing.
     *
     * @param id the id of the ppLineDrawingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-line-drawings/{id}")
    @Timed
    public ResponseEntity<Void> deletePpLineDrawing(@PathVariable Long id) {
        log.debug("REST request to delete PpLineDrawing : {}", id);
        ppLineDrawingService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
