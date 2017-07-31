package com.rd.pcms.web.rest;

import com.Application;
import com.jumore.zhxf.web.rest.TestUtil;

import com.jumore.zhxf.web.rest.errors.ExceptionTranslator;
import com.rd.pcms.domain.Biz;
import com.rd.pcms.repository.BizRepository;
import com.rd.pcms.service.BizService;
import com.rd.pcms.service.dto.BizDTO;
import com.rd.pcms.service.mapper.BizMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the BizResource REST controller.
 *
 * @see BizResource
 */

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class BizResourceIntTest {

    private static final String DEFAULT_BIZ_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BIZ_NAME = "BBBBBBBBBB";

    @Autowired
    private BizRepository bizRepository;

    @Autowired
    private BizMapper bizMapper;

    @Autowired
    private BizService bizService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBizMockMvc;

    private Biz biz;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        BizResource bizResource = new BizResource(bizService);
        this.restBizMockMvc = MockMvcBuilders.standaloneSetup(bizResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Biz createEntity(EntityManager em) {
        Biz biz = new Biz()
            .bizName(DEFAULT_BIZ_NAME);
        return biz;
    }

    @Before
    public void initTest() {
        biz = createEntity(em);
    }

    @Test
    @Transactional
    public void createBiz() throws Exception {
        int databaseSizeBeforeCreate = bizRepository.findAll().size();

        // Create the Biz
        BizDTO bizDTO = bizMapper.toDto(biz);
        restBizMockMvc.perform(post("/api/bizs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizDTO)))
            .andExpect(status().isCreated());

        // Validate the Biz in the database
        List<Biz> bizList = bizRepository.findAll();
        assertThat(bizList).hasSize(databaseSizeBeforeCreate + 1);
        Biz testBiz = bizList.get(bizList.size() - 1);
        assertThat(testBiz.getBizName()).isEqualTo(DEFAULT_BIZ_NAME);
    }

    @Test
    @Transactional
    public void createBizWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bizRepository.findAll().size();

        // Create the Biz with an existing ID
        biz.setId(1L);
        BizDTO bizDTO = bizMapper.toDto(biz);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBizMockMvc.perform(post("/api/bizs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Biz> bizList = bizRepository.findAll();
        assertThat(bizList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkBizNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizRepository.findAll().size();
        // set the field null
        biz.setBizName(null);

        // Create the Biz, which fails.
        BizDTO bizDTO = bizMapper.toDto(biz);

        restBizMockMvc.perform(post("/api/bizs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizDTO)))
            .andExpect(status().isBadRequest());

        List<Biz> bizList = bizRepository.findAll();
        assertThat(bizList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBizs() throws Exception {
        // Initialize the database
        bizRepository.saveAndFlush(biz);

        // Get all the bizList
        restBizMockMvc.perform(get("/api/bizs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(biz.getId().intValue())))
            .andExpect(jsonPath("$.[*].bizName").value(hasItem(DEFAULT_BIZ_NAME.toString())));
    }

    @Test
    @Transactional
    public void getBiz() throws Exception {
        // Initialize the database
        bizRepository.saveAndFlush(biz);

        // Get the biz
        restBizMockMvc.perform(get("/api/bizs/{id}", biz.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(biz.getId().intValue()))
            .andExpect(jsonPath("$.bizName").value(DEFAULT_BIZ_NAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBiz() throws Exception {
        // Get the biz
        restBizMockMvc.perform(get("/api/bizs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBiz() throws Exception {
        // Initialize the database
        bizRepository.saveAndFlush(biz);
        int databaseSizeBeforeUpdate = bizRepository.findAll().size();

        // Update the biz
        Biz updatedBiz = bizRepository.findOne(biz.getId());
        updatedBiz
            .bizName(UPDATED_BIZ_NAME);
        BizDTO bizDTO = bizMapper.toDto(updatedBiz);

        restBizMockMvc.perform(put("/api/bizs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizDTO)))
            .andExpect(status().isOk());

        // Validate the Biz in the database
        List<Biz> bizList = bizRepository.findAll();
        assertThat(bizList).hasSize(databaseSizeBeforeUpdate);
        Biz testBiz = bizList.get(bizList.size() - 1);
        assertThat(testBiz.getBizName()).isEqualTo(UPDATED_BIZ_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingBiz() throws Exception {
        int databaseSizeBeforeUpdate = bizRepository.findAll().size();

        // Create the Biz
        BizDTO bizDTO = bizMapper.toDto(biz);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restBizMockMvc.perform(put("/api/bizs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizDTO)))
            .andExpect(status().isCreated());

        // Validate the Biz in the database
        List<Biz> bizList = bizRepository.findAll();
        assertThat(bizList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteBiz() throws Exception {
        // Initialize the database
        bizRepository.saveAndFlush(biz);
        int databaseSizeBeforeDelete = bizRepository.findAll().size();

        // Get the biz
        restBizMockMvc.perform(delete("/api/bizs/{id}", biz.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Biz> bizList = bizRepository.findAll();
        assertThat(bizList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Biz.class);
        Biz biz1 = new Biz();
        biz1.setId(1L);
        Biz biz2 = new Biz();
        biz2.setId(biz1.getId());
        assertThat(biz1).isEqualTo(biz2);
        biz2.setId(2L);
        assertThat(biz1).isNotEqualTo(biz2);
        biz1.setId(null);
        assertThat(biz1).isNotEqualTo(biz2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BizDTO.class);
        BizDTO bizDTO1 = new BizDTO();
        bizDTO1.setId(1L);
        BizDTO bizDTO2 = new BizDTO();
        assertThat(bizDTO1).isNotEqualTo(bizDTO2);
        bizDTO2.setId(bizDTO1.getId());
        assertThat(bizDTO1).isEqualTo(bizDTO2);
        bizDTO2.setId(2L);
        assertThat(bizDTO1).isNotEqualTo(bizDTO2);
        bizDTO1.setId(null);
        assertThat(bizDTO1).isNotEqualTo(bizDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(bizMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(bizMapper.fromId(null)).isNull();
    }
}
