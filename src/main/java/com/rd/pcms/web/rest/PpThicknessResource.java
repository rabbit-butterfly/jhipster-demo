package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpThicknessService;
;

import com.rd.pcms.service.dto.PpThicknessDTO;
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
 * REST controller for managing PpThickness.
 */
@RestController
@RequestMapping("/api")
public class PpThicknessResource {

    private final Logger log = LoggerFactory.getLogger(PpThicknessResource.class);

    private static final String ENTITY_NAME = "ppThickness";

    private final PpThicknessService ppThicknessService;

    public PpThicknessResource(PpThicknessService ppThicknessService) {
        this.ppThicknessService = ppThicknessService;
    }

    /**
     * POST  /pp-thicknesses : Create a new ppThickness.
     *
     * @param ppThicknessDTO the ppThicknessDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppThicknessDTO, or with status 400 (Bad Request) if the ppThickness has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-thicknesses")
    @Timed
    public ResponseEntity<PpThicknessDTO> createPpThickness(@Valid @RequestBody PpThicknessDTO ppThicknessDTO) throws URISyntaxException {
        log.debug("REST request to save PpThickness : {}", ppThicknessDTO);
        if (ppThicknessDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppThickness cannot already have an ID")).body(null);
        }
        PpThicknessDTO result = ppThicknessService.save(ppThicknessDTO);
        return ResponseEntity.created(new URI("/api/pp-thicknesses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-thicknesses : Updates an existing ppThickness.
     *
     * @param ppThicknessDTO the ppThicknessDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppThicknessDTO,
     * or with status 400 (Bad Request) if the ppThicknessDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppThicknessDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-thicknesses")
    @Timed
    public ResponseEntity<PpThicknessDTO> updatePpThickness(@Valid @RequestBody PpThicknessDTO ppThicknessDTO) throws URISyntaxException {
        log.debug("REST request to update PpThickness : {}", ppThicknessDTO);
        if (ppThicknessDTO.getId() == null) {
            return createPpThickness(ppThicknessDTO);
        }
        PpThicknessDTO result = ppThicknessService.save(ppThicknessDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppThicknessDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-thicknesses : get all the ppThicknesses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppThicknesses in body
     */
    @GetMapping("/pp-thicknesses")
    @Timed
    public ResponseEntity<List<PpThicknessDTO>> getAllPpThicknesses(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpThicknesses");
        Page<PpThicknessDTO> page = ppThicknessService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-thicknesses");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-thicknesses/:id : get the "id" ppThickness.
     *
     * @param id the id of the ppThicknessDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppThicknessDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-thicknesses/{id}")
    @Timed
    public ResponseEntity<PpThicknessDTO> getPpThickness(@PathVariable Long id) {
        log.debug("REST request to get PpThickness : {}", id);
        PpThicknessDTO ppThicknessDTO = ppThicknessService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppThicknessDTO));
    }

    /**
     * DELETE  /pp-thicknesses/:id : delete the "id" ppThickness.
     *
     * @param id the id of the ppThicknessDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-thicknesses/{id}")
    @Timed
    public ResponseEntity<Void> deletePpThickness(@PathVariable Long id) {
        log.debug("REST request to delete PpThickness : {}", id);
        ppThicknessService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
