package com.jumore.zhxf.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Regist;
import com.jumore.zhxf.repository.RegistRepository;
import com.jumore.zhxf.repository.search.RegistSearchRepository;
import com.jumore.zhxf.service.buddha.RegistService;
import com.jumore.zhxf.service.dto.RegistDTO;
import com.jumore.zhxf.service.mapper.RegistMapper;
import com.jumore.zhxf.web.rest.util.HeaderUtil;
import com.jumore.zhxf.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiParam;

/**
 * REST controller for managing Regist.
 */
@RestController
@RequestMapping("/api")
public class RegistResource {

    private final Logger log = LoggerFactory.getLogger(RegistResource.class);
        
    @Inject
    private RegistRepository registRepository;

    @Inject
    private RegistMapper registMapper;
    
    @Inject
    private RegistService registService;
    @Inject
    private RegistSearchRepository registSearchRepository;

    /**
     * POST  /regists : Create a new regist.
     *
     * @param registDTO the registDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new registDTO, or with status 400 (Bad Request) if the regist has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/regists")
    @Timed
    public ResponseEntity<RegistDTO> createRegist(@RequestBody RegistDTO registDTO) throws URISyntaxException {
        log.debug("REST request to save Regist : {}", registDTO);
        if (registDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("regist", "idexists", "A new regist cannot already have an ID")).body(null);
        }
        Regist regist = registMapper.registDTOToRegist(registDTO);
        regist = registRepository.save(regist);
        RegistDTO result = registMapper.registToRegistDTO(regist);
        registSearchRepository.save(regist);
        return ResponseEntity.created(new URI("/api/regists/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("regist", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /regists : Updates an existing regist.
     *
     * @param registDTO the registDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated registDTO,
     * or with status 400 (Bad Request) if the registDTO is not valid,
     * or with status 500 (Internal Server Error) if the registDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/regists")
    @Timed
    public ResponseEntity<RegistDTO> updateRegist(@RequestBody RegistDTO registDTO) throws URISyntaxException {
        log.debug("REST request to update Regist : {}", registDTO);
        if (registDTO.getId() == null) {
            return createRegist(registDTO);
        }
        Regist regist = registMapper.registDTOToRegist(registDTO);
        regist = registRepository.save(regist);
        RegistDTO result = registMapper.registToRegistDTO(regist);
        registSearchRepository.save(regist);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("regist", registDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /regists : get all the regists.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of regists in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/regists")
    @Timed
    public ResponseEntity<List<RegistDTO>> getAllRegists(@ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Regists");
        Order[] orders = new Order[] { new Order(Direction.DESC, "createdTime") };
		
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize()
				,new Sort(orders));
        Page<Regist> page = registRepository.findAll(pageRequest);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/regists");
        return new ResponseEntity<>(registMapper.registsToRegistDTOs(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /regists/:id : get the "id" regist.
     *
     * @param id the id of the registDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the registDTO, or with status 404 (Not Found)
     */
    @GetMapping("/regists/{id}")
    @Timed
    public ResponseEntity<RegistDTO> getRegist(@PathVariable Long id) {
        log.debug("REST request to get Regist : {}", id);
        Regist regist = registRepository.findOne(id);
        RegistDTO registDTO = registMapper.registToRegistDTO(regist);
        return Optional.ofNullable(registDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /regists/:id : delete the "id" regist.
     *
     * @param id the id of the registDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/regists/{id}")
    @Timed
    public ResponseEntity<Void> deleteRegist(@PathVariable Long id) {
        log.debug("REST request to delete Regist : {}", id);
        registRepository.delete(id);
        registSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("regist", id.toString())).build();
    }

    /**
     * SEARCH  /_search/regists?query=:query : search for the regist corresponding
     * to the query.
     *
     * @param query the query of the regist search 
     * @param pageable the pagination information
     * @return the result of the search
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/_search/regists")
    @Timed
    public ResponseEntity<List<RegistDTO>> searchRegists(@RequestParam String query, @ApiParam Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to search for a page of Regists for query {}", query);
//        Page<Regist> page = registSearchRepository.search(queryStringQuery(query), pageable);
        Page<Regist> page=registService.findByEventId(Long.parseLong(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/regists");
        return new ResponseEntity<>(registMapper.registsToRegistDTOs(page.getContent()), headers, HttpStatus.OK);
    }


}
