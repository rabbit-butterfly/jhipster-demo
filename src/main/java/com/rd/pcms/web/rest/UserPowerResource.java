package com.rd.pcms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;
import com.rd.pcms.service.UserPowerService;
import com.rd.pcms.service.dto.UserPowerDTO;
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
 * REST controller for managing UserPower.
 */
@RestController
@RequestMapping("/api")
public class UserPowerResource {

    private final Logger log = LoggerFactory.getLogger(UserPowerResource.class);

    private static final String ENTITY_NAME = "userPower";

    private final UserPowerService userPowerService;

    public UserPowerResource(UserPowerService userPowerService) {
        this.userPowerService = userPowerService;
    }

    /**
     * POST  /user-powers : Create a new userPower.
     *
     * @param userPowerDTO the userPowerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userPowerDTO, or with status 400 (Bad Request) if the userPower has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user-powers")
    @Timed
    public ResponseEntity<UserPowerDTO> createUserPower(@Valid @RequestBody UserPowerDTO userPowerDTO) throws URISyntaxException {
        log.debug("REST request to save UserPower : {}", userPowerDTO);
        if (userPowerDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new userPower cannot already have an ID")).body(null);
        }
        UserPowerDTO result = userPowerService.save(userPowerDTO);
        return ResponseEntity.created(new URI("/api/user-powers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /user-powers : Updates an existing userPower.
     *
     * @param userPowerDTO the userPowerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userPowerDTO,
     * or with status 400 (Bad Request) if the userPowerDTO is not valid,
     * or with status 500 (Internal Server Error) if the userPowerDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user-powers")
    @Timed
    public ResponseEntity<UserPowerDTO> updateUserPower(@Valid @RequestBody UserPowerDTO userPowerDTO) throws URISyntaxException {
        log.debug("REST request to update UserPower : {}", userPowerDTO);
        if (userPowerDTO.getId() == null) {
            return createUserPower(userPowerDTO);
        }
        UserPowerDTO result = userPowerService.save(userPowerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userPowerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /user-powers : get all the userPowers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of userPowers in body
     */
    @GetMapping("/user-powers")
    @Timed
    public ResponseEntity<List<UserPowerDTO>> getAllUserPowers(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of UserPowers");
        Page<UserPowerDTO> page = userPowerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/user-powers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /user-powers/:id : get the "id" userPower.
     *
     * @param id the id of the userPowerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userPowerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/user-powers/{id}")
    @Timed
    public ResponseEntity<UserPowerDTO> getUserPower(@PathVariable Long id) {
        log.debug("REST request to get UserPower : {}", id);
        UserPowerDTO userPowerDTO = userPowerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(userPowerDTO));
    }

    /**
     * DELETE  /user-powers/:id : delete the "id" userPower.
     *
     * @param id the id of the userPowerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/user-powers/{id}")
    @Timed
    public ResponseEntity<Void> deleteUserPower(@PathVariable Long id) {
        log.debug("REST request to delete UserPower : {}", id);
        userPowerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
