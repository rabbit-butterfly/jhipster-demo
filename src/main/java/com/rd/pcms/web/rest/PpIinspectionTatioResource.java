package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpIinspectionTatioService;
;

import com.rd.pcms.service.dto.PpIinspectionTatioDTO;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing PpIinspectionTatio.
 */
@RestController
@RequestMapping("/api")
public class PpIinspectionTatioResource {

    private final Logger log = LoggerFactory.getLogger(PpIinspectionTatioResource.class);

    private static final String ENTITY_NAME = "ppIinspectionTatio";

    private final PpIinspectionTatioService ppIinspectionTatioService;

    public PpIinspectionTatioResource(PpIinspectionTatioService ppIinspectionTatioService) {
        this.ppIinspectionTatioService = ppIinspectionTatioService;
    }

    /**
     * POST  /pp-iinspection-tatios : Create a new ppIinspectionTatio.
     *
     * @param ppIinspectionTatioDTO the ppIinspectionTatioDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppIinspectionTatioDTO, or with status 400 (Bad Request) if the ppIinspectionTatio has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-iinspection-tatios")
    @Timed
    public ResponseEntity<PpIinspectionTatioDTO> createPpIinspectionTatio(@Valid @RequestBody PpIinspectionTatioDTO ppIinspectionTatioDTO) throws URISyntaxException {
        log.debug("REST request to save PpIinspectionTatio : {}", ppIinspectionTatioDTO);
        if (ppIinspectionTatioDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppIinspectionTatio cannot already have an ID")).body(null);
        }
        PpIinspectionTatioDTO result = ppIinspectionTatioService.save(ppIinspectionTatioDTO);
        return ResponseEntity.created(new URI("/api/pp-iinspection-tatios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-iinspection-tatios : Updates an existing ppIinspectionTatio.
     *
     * @param ppIinspectionTatioDTO the ppIinspectionTatioDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppIinspectionTatioDTO,
     * or with status 400 (Bad Request) if the ppIinspectionTatioDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppIinspectionTatioDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-iinspection-tatios")
    @Timed
    public ResponseEntity<PpIinspectionTatioDTO> updatePpIinspectionTatio(@Valid @RequestBody PpIinspectionTatioDTO ppIinspectionTatioDTO) throws URISyntaxException {
        log.debug("REST request to update PpIinspectionTatio : {}", ppIinspectionTatioDTO);
        if (ppIinspectionTatioDTO.getId() == null) {
            return createPpIinspectionTatio(ppIinspectionTatioDTO);
        }
        PpIinspectionTatioDTO result = ppIinspectionTatioService.save(ppIinspectionTatioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppIinspectionTatioDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-iinspection-tatios : get all the ppIinspectionTatios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppIinspectionTatios in body
     */
    @GetMapping("/pp-iinspection-tatios")
    @Timed
    public ResponseEntity<List<PpIinspectionTatioDTO>> getAllPpIinspectionTatios(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpIinspectionTatios");
        Page<PpIinspectionTatioDTO> page = ppIinspectionTatioService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-iinspection-tatios");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-iinspection-tatios/:id : get the "id" ppIinspectionTatio.
     *
     * @param id the id of the ppIinspectionTatioDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppIinspectionTatioDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-iinspection-tatios/{id}")
    @Timed
    public ResponseEntity<PpIinspectionTatioDTO> getPpIinspectionTatio(@PathVariable Long id) {
        log.debug("REST request to get PpIinspectionTatio : {}", id);
        PpIinspectionTatioDTO ppIinspectionTatioDTO = ppIinspectionTatioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppIinspectionTatioDTO));
    }

    /**
     * DELETE  /pp-iinspection-tatios/:id : delete the "id" ppIinspectionTatio.
     *
     * @param id the id of the ppIinspectionTatioDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-iinspection-tatios/{id}")
    @Timed
    public ResponseEntity<Void> deletePpIinspectionTatio(@PathVariable Long id) {
        log.debug("REST request to delete PpIinspectionTatio : {}", id);
        ppIinspectionTatioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
