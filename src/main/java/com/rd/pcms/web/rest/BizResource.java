package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.BizService;
import com.rd.pcms.service.dto.BizDTO;
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
 * REST controller for managing Biz.
 */
@RestController
@RequestMapping("/api")
public class BizResource {

    private final Logger log = LoggerFactory.getLogger(BizResource.class);

    private static final String ENTITY_NAME = "biz";

    private final BizService bizService;

    public BizResource(BizService bizService) {
        this.bizService = bizService;
    }

    /**
     * POST  /bizs : Create a new biz.
     *
     * @param bizDTO the bizDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bizDTO, or with status 400 (Bad Request) if the biz has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bizs")
    @Timed
    public ResponseEntity<BizDTO> createBiz(@Valid @RequestBody BizDTO bizDTO) throws URISyntaxException {
        log.debug("REST request to save Biz : {}", bizDTO);
        if (bizDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new biz cannot already have an ID")).body(null);
        }
        BizDTO result = bizService.save(bizDTO);
        return ResponseEntity.created(new URI("/api/bizs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bizs : Updates an existing biz.
     *
     * @param bizDTO the bizDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bizDTO,
     * or with status 400 (Bad Request) if the bizDTO is not valid,
     * or with status 500 (Internal Server Error) if the bizDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bizs")
    @Timed
    public ResponseEntity<BizDTO> updateBiz(@Valid @RequestBody BizDTO bizDTO) throws URISyntaxException {
        log.debug("REST request to update Biz : {}", bizDTO);
        if (bizDTO.getId() == null) {
            return createBiz(bizDTO);
        }
        BizDTO result = bizService.save(bizDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bizDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bizs : get all the bizs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of bizs in body
     */
    @GetMapping("/bizs")
    @Timed
    public ResponseEntity<List<BizDTO>> getAllBizs(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of Bizs");
        Page<BizDTO> page = bizService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/bizs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /bizs/:id : get the "id" biz.
     *
     * @param id the id of the bizDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bizDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bizs/{id}")
    @Timed
    public ResponseEntity<BizDTO> getBiz(@PathVariable Long id) {
        log.debug("REST request to get Biz : {}", id);
        BizDTO bizDTO = bizService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(bizDTO));
    }

    /**
     * DELETE  /bizs/:id : delete the "id" biz.
     *
     * @param id the id of the bizDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bizs/{id}")
    @Timed
    public ResponseEntity<Void> deleteBiz(@PathVariable Long id) {
        log.debug("REST request to delete Biz : {}", id);
        bizService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
