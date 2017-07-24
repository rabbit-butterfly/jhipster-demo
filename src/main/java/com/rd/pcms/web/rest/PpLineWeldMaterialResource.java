package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.PpLineWeldMaterialService;
;

import com.rd.pcms.service.dto.PpLineWeldMaterialDTO;
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
 * REST controller for managing PpLineWeldMaterial.
 */
@RestController
@RequestMapping("/api")
public class PpLineWeldMaterialResource {

    private final Logger log = LoggerFactory.getLogger(PpLineWeldMaterialResource.class);

    private static final String ENTITY_NAME = "ppLineWeldMaterial";

    private final PpLineWeldMaterialService ppLineWeldMaterialService;

    public PpLineWeldMaterialResource(PpLineWeldMaterialService ppLineWeldMaterialService) {
        this.ppLineWeldMaterialService = ppLineWeldMaterialService;
    }

    /**
     * POST  /pp-line-weld-materials : Create a new ppLineWeldMaterial.
     *
     * @param ppLineWeldMaterialDTO the ppLineWeldMaterialDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ppLineWeldMaterialDTO, or with status 400 (Bad Request) if the ppLineWeldMaterial has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pp-line-weld-materials")
    @Timed
    public ResponseEntity<PpLineWeldMaterialDTO> createPpLineWeldMaterial(@Valid @RequestBody PpLineWeldMaterialDTO ppLineWeldMaterialDTO) throws URISyntaxException {
        log.debug("REST request to save PpLineWeldMaterial : {}", ppLineWeldMaterialDTO);
        if (ppLineWeldMaterialDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ppLineWeldMaterial cannot already have an ID")).body(null);
        }
        PpLineWeldMaterialDTO result = ppLineWeldMaterialService.save(ppLineWeldMaterialDTO);
        return ResponseEntity.created(new URI("/api/pp-line-weld-materials/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pp-line-weld-materials : Updates an existing ppLineWeldMaterial.
     *
     * @param ppLineWeldMaterialDTO the ppLineWeldMaterialDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ppLineWeldMaterialDTO,
     * or with status 400 (Bad Request) if the ppLineWeldMaterialDTO is not valid,
     * or with status 500 (Internal Server Error) if the ppLineWeldMaterialDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pp-line-weld-materials")
    @Timed
    public ResponseEntity<PpLineWeldMaterialDTO> updatePpLineWeldMaterial(@Valid @RequestBody PpLineWeldMaterialDTO ppLineWeldMaterialDTO) throws URISyntaxException {
        log.debug("REST request to update PpLineWeldMaterial : {}", ppLineWeldMaterialDTO);
        if (ppLineWeldMaterialDTO.getId() == null) {
            return createPpLineWeldMaterial(ppLineWeldMaterialDTO);
        }
        PpLineWeldMaterialDTO result = ppLineWeldMaterialService.save(ppLineWeldMaterialDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ppLineWeldMaterialDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pp-line-weld-materials : get all the ppLineWeldMaterials.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ppLineWeldMaterials in body
     */
    @GetMapping("/pp-line-weld-materials")
    @Timed
    public ResponseEntity<List<PpLineWeldMaterialDTO>> getAllPpLineWeldMaterials(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of PpLineWeldMaterials");
        Page<PpLineWeldMaterialDTO> page = ppLineWeldMaterialService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pp-line-weld-materials");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pp-line-weld-materials/:id : get the "id" ppLineWeldMaterial.
     *
     * @param id the id of the ppLineWeldMaterialDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ppLineWeldMaterialDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pp-line-weld-materials/{id}")
    @Timed
    public ResponseEntity<PpLineWeldMaterialDTO> getPpLineWeldMaterial(@PathVariable Long id) {
        log.debug("REST request to get PpLineWeldMaterial : {}", id);
        PpLineWeldMaterialDTO ppLineWeldMaterialDTO = ppLineWeldMaterialService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ppLineWeldMaterialDTO));
    }

    /**
     * DELETE  /pp-line-weld-materials/:id : delete the "id" ppLineWeldMaterial.
     *
     * @param id the id of the ppLineWeldMaterialDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pp-line-weld-materials/{id}")
    @Timed
    public ResponseEntity<Void> deletePpLineWeldMaterial(@PathVariable Long id) {
        log.debug("REST request to delete PpLineWeldMaterial : {}", id);
        ppLineWeldMaterialService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
