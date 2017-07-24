package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpGradeMaterailService;
;

import com.rd.pcms.service.dto.PpGradeMaterailDTO;
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
 * REST controller for managing PpGradeMaterail.
 */
@RestController
@RequestMapping("/api")
public class PpGradeMaterailResource {

    private final Logger log = LoggerFactory.getLogger(PpGradeMaterailResource.class);

    private static final String ENTITY_NAME = "ppGradeMaterail";

    private final PpGradeMaterailService ppGradeMaterailService;

    public PpGradeMaterailResource(PpGradeMaterailService ppGradeMaterailService) {
        this.ppGradeMaterailService = ppGradeMaterailService;
    }

    /**
     * POST  /pp-grade-materails : Create a new ppGradeMaterail.
     *
     * @param ppGradeMaterailDTO the ppGradeMaterailDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppGradeMaterailDTO, or with status 400 (Bad Request) if the ppGradeMaterail has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-grade-materails")
    @Timed
    public ResponseEntity<PpGradeMaterailDTO> createPpGradeMaterail(@Valid @RequestBody PpGradeMaterailDTO ppGradeMaterailDTO) throws URISyntaxException {
        log.debug("REST request to save PpGradeMaterail : {}", ppGradeMaterailDTO);
        if (ppGradeMaterailDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppGradeMaterail cannot already have an ID")).body(null);
        }
        PpGradeMaterailDTO result = ppGradeMaterailService.save(ppGradeMaterailDTO);
        return ResponseEntity.created(new URI("/api/pp-grade-materails/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-grade-materails : Updates an existing ppGradeMaterail.
     *
     * @param ppGradeMaterailDTO the ppGradeMaterailDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppGradeMaterailDTO,
     * or with status 400 (Bad Request) if the ppGradeMaterailDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppGradeMaterailDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-grade-materails")
    @Timed
    public ResponseEntity<PpGradeMaterailDTO> updatePpGradeMaterail(@Valid @RequestBody PpGradeMaterailDTO ppGradeMaterailDTO) throws URISyntaxException {
        log.debug("REST request to update PpGradeMaterail : {}", ppGradeMaterailDTO);
        if (ppGradeMaterailDTO.getId() == null) {
            return createPpGradeMaterail(ppGradeMaterailDTO);
        }
        PpGradeMaterailDTO result = ppGradeMaterailService.save(ppGradeMaterailDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppGradeMaterailDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-grade-materails : get all the ppGradeMaterails.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppGradeMaterails in body
     */
    @GetMapping("/pp-grade-materails")
    @Timed
    public ResponseEntity<List<PpGradeMaterailDTO>> getAllPpGradeMaterails(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpGradeMaterails");
        Page<PpGradeMaterailDTO> page = ppGradeMaterailService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-grade-materails");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-grade-materails/:id : get the "id" ppGradeMaterail.
     *
     * @param id the id of the ppGradeMaterailDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppGradeMaterailDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-grade-materails/{id}")
    @Timed
    public ResponseEntity<PpGradeMaterailDTO> getPpGradeMaterail(@PathVariable Long id) {
        log.debug("REST request to get PpGradeMaterail : {}", id);
        PpGradeMaterailDTO ppGradeMaterailDTO = ppGradeMaterailService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppGradeMaterailDTO));
    }

    /**
     * DELETE  /pp-grade-materails/:id : delete the "id" ppGradeMaterail.
     *
     * @param id the id of the ppGradeMaterailDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-grade-materails/{id}")
    @Timed
    public ResponseEntity<Void> deletePpGradeMaterail(@PathVariable Long id) {
        log.debug("REST request to delete PpGradeMaterail : {}", id);
        ppGradeMaterailService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
