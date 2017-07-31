package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.jumore.zhxf.web.rest.util.ResponseUtil;
import com.rd.pcms.service.BizAuthService;
import com.rd.pcms.service.dto.BizAuthDTO;
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
import java.util.stream.StreamSupport;

/**
 * REST controller for managing BizAuth.
 */
@RestController
@RequestMapping("/api")
public class BizAuthResource {

    private final Logger log = LoggerFactory.getLogger(BizAuthResource.class);

    private static final String ENTITY_NAME = "bizAuth";

    private final BizAuthService bizAuthService;

    public BizAuthResource(BizAuthService bizAuthService) {
        this.bizAuthService = bizAuthService;
    }

    /**
     * POST  /biz-auths : Create a new bizAuth.
     *
     * @param bizAuthDTO the bizAuthDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bizAuthDTO, or with status 400 (Bad Request) if the bizAuth has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/biz-auths")
    @Timed
    public ResponseEntity<BizAuthDTO> createBizAuth(@Valid @RequestBody BizAuthDTO bizAuthDTO) throws URISyntaxException {
        log.debug("REST request to save BizAuth : {}", bizAuthDTO);
        if (bizAuthDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new bizAuth cannot already have an ID")).body(null);
        }
        BizAuthDTO result = bizAuthService.save(bizAuthDTO);
        return ResponseEntity.created(new URI("/api/biz-auths/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /biz-auths : Updates an existing bizAuth.
     *
     * @param bizAuthDTO the bizAuthDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bizAuthDTO,
     * or with status 400 (Bad Request) if the bizAuthDTO is not valid,
     * or with status 500 (Internal Server Error) if the bizAuthDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/biz-auths")
    @Timed
    public ResponseEntity<BizAuthDTO> updateBizAuth(@Valid @RequestBody BizAuthDTO bizAuthDTO) throws URISyntaxException {
        log.debug("REST request to update BizAuth : {}", bizAuthDTO);
        if (bizAuthDTO.getId() == null) {
            return createBizAuth(bizAuthDTO);
        }
        BizAuthDTO result = bizAuthService.save(bizAuthDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bizAuthDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /biz-auths : get all the bizAuths.
     *
     * @param pageable the pagination information
     * @param filter the filter of the request
     * @return the ResponseEntity with status 200 (OK) and the list of bizAuths in body
     */
    @GetMapping("/biz-auths")
    @Timed
    public ResponseEntity<List<BizAuthDTO>> getAllBizAuths(@ApiParam Pageable pageable, @RequestParam(required = false) String filter) throws URISyntaxException {
        if ("role-is-null".equals(filter)) {
            log.debug("REST request to get all BizAuths where role is null");
            return new ResponseEntity<>(bizAuthService.findAllWhereRoleIsNull(),
                    HttpStatus.OK);
        }
        log.debug("REST request to get a page of BizAuths");
        Page<BizAuthDTO> page = bizAuthService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/biz-auths");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /biz-auths/:id : get the "id" bizAuth.
     *
     * @param id the id of the bizAuthDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bizAuthDTO, or with status 404 (Not Found)
     */
    @GetMapping("/biz-auths/{id}")
    @Timed
    public ResponseEntity<BizAuthDTO> getBizAuth(@PathVariable Long id) {
        log.debug("REST request to get BizAuth : {}", id);
        BizAuthDTO bizAuthDTO = bizAuthService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(bizAuthDTO));
    }

    /**
     * DELETE  /biz-auths/:id : delete the "id" bizAuth.
     *
     * @param id the id of the bizAuthDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/biz-auths/{id}")
    @Timed
    public ResponseEntity<Void> deleteBizAuth(@PathVariable Long id) {
        log.debug("REST request to delete BizAuth : {}", id);
        bizAuthService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
