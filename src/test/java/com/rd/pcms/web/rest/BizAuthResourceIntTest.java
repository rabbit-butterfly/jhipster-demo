package com.rd.pcms.web.rest;

import com.Application;
import com.jumore.zhxf.web.rest.TestUtil;

import com.jumore.zhxf.web.rest.errors.ExceptionTranslator;
import com.rd.pcms.domain.BizAuth;
import com.rd.pcms.domain.Biz;
import com.rd.pcms.repository.BizAuthRepository;
import com.rd.pcms.service.BizAuthService;
import com.rd.pcms.service.dto.BizAuthDTO;
import com.rd.pcms.service.mapper.BizAuthMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the BizAuthResource REST controller.
 *
 * @see BizAuthResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BizAuthResourceIntTest {

    private static final String DEFAULT_BIZ_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BIZ_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_CODE = "BBBBBBBBBB";

    private static final Long DEFAULT_MIN_AUTH_CODE = 0L;
    private static final Long UPDATED_MIN_AUTH_CODE = 1L;

    private static final Long DEFAULT_MAX_AUTH_CODE = 0L;
    private static final Long UPDATED_MAX_AUTH_CODE = 1L;

    private static final String DEFAULT_AUTH_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AUTH_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_AUTH_CATEGORY = 0;
    private static final Integer UPDATED_AUTH_CATEGORY = 1;

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_LAST_MODIFIED_BY = "AAAAAAAAAA";
    private static final String UPDATED_LAST_MODIFIED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_LAST_MODIFIED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_MODIFIED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private BizAuthRepository bizAuthRepository;

    @Autowired
    private BizAuthMapper bizAuthMapper;

    @Autowired
    private BizAuthService bizAuthService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBizAuthMockMvc;

    private BizAuth bizAuth;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        BizAuthResource bizAuthResource = new BizAuthResource(bizAuthService);
        this.restBizAuthMockMvc = MockMvcBuilders.standaloneSetup(bizAuthResource)
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
    public static BizAuth createEntity(EntityManager em) {
        BizAuth bizAuth = new BizAuth()
            .bizName(DEFAULT_BIZ_NAME)
            .roleCode(DEFAULT_ROLE_CODE)
            .minAuthCode(DEFAULT_MIN_AUTH_CODE)
            .maxAuthCode(DEFAULT_MAX_AUTH_CODE)
            .authCode(DEFAULT_AUTH_CODE)
            .authCategory(DEFAULT_AUTH_CATEGORY)
            .createdBy(DEFAULT_CREATED_BY)
            .createdDate(DEFAULT_CREATED_DATE)
            .lastModifiedBy(DEFAULT_LAST_MODIFIED_BY)
            .lastModifiedDate(DEFAULT_LAST_MODIFIED_DATE);
        // Add required entity
        Biz biz = BizResourceIntTest.createEntity(em);
        em.persist(biz);
        em.flush();
        bizAuth.setBiz(biz);
        return bizAuth;
    }

    @Before
    public void initTest() {
        bizAuth = createEntity(em);
    }

    @Test
    @Transactional
    public void createBizAuth() throws Exception {
        int databaseSizeBeforeCreate = bizAuthRepository.findAll().size();

        // Create the BizAuth
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);
        restBizAuthMockMvc.perform(post("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isCreated());

        // Validate the BizAuth in the database
        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeCreate + 1);
        BizAuth testBizAuth = bizAuthList.get(bizAuthList.size() - 1);
        assertThat(testBizAuth.getBizName()).isEqualTo(DEFAULT_BIZ_NAME);
        assertThat(testBizAuth.getRoleCode()).isEqualTo(DEFAULT_ROLE_CODE);
        assertThat(testBizAuth.getMinAuthCode()).isEqualTo(DEFAULT_MIN_AUTH_CODE);
        assertThat(testBizAuth.getMaxAuthCode()).isEqualTo(DEFAULT_MAX_AUTH_CODE);
        assertThat(testBizAuth.getAuthCode()).isEqualTo(DEFAULT_AUTH_CODE);
        assertThat(testBizAuth.getAuthCategory()).isEqualTo(DEFAULT_AUTH_CATEGORY);
        assertThat(testBizAuth.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testBizAuth.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testBizAuth.getLastModifiedBy()).isEqualTo(DEFAULT_LAST_MODIFIED_BY);
        assertThat(testBizAuth.getLastModifiedDate()).isEqualTo(DEFAULT_LAST_MODIFIED_DATE);
    }

    @Test
    @Transactional
    public void createBizAuthWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bizAuthRepository.findAll().size();

        // Create the BizAuth with an existing ID
        bizAuth.setId(1L);
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBizAuthMockMvc.perform(post("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkBizNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizAuthRepository.findAll().size();
        // set the field null
        bizAuth.setBizName(null);

        // Create the BizAuth, which fails.
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);

        restBizAuthMockMvc.perform(post("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isBadRequest());

        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRoleCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizAuthRepository.findAll().size();
        // set the field null
        bizAuth.setRoleCode(null);

        // Create the BizAuth, which fails.
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);

        restBizAuthMockMvc.perform(post("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isBadRequest());

        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkMinAuthCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizAuthRepository.findAll().size();
        // set the field null
        bizAuth.setMinAuthCode(null);

        // Create the BizAuth, which fails.
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);

        restBizAuthMockMvc.perform(post("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isBadRequest());

        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAuthCategoryIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizAuthRepository.findAll().size();
        // set the field null
        bizAuth.setAuthCategory(null);

        // Create the BizAuth, which fails.
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);

        restBizAuthMockMvc.perform(post("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isBadRequest());

        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreatedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizAuthRepository.findAll().size();
        // set the field null
        bizAuth.setCreatedDate(null);

        // Create the BizAuth, which fails.
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);

        restBizAuthMockMvc.perform(post("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isBadRequest());

        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBizAuths() throws Exception {
        // Initialize the database
        bizAuthRepository.saveAndFlush(bizAuth);

        // Get all the bizAuthList
        restBizAuthMockMvc.perform(get("/api/biz-auths?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bizAuth.getId().intValue())))
            .andExpect(jsonPath("$.[*].bizName").value(hasItem(DEFAULT_BIZ_NAME.toString())))
            .andExpect(jsonPath("$.[*].roleCode").value(hasItem(DEFAULT_ROLE_CODE.toString())))
            .andExpect(jsonPath("$.[*].minAuthCode").value(hasItem(DEFAULT_MIN_AUTH_CODE.intValue())))
            .andExpect(jsonPath("$.[*].maxAuthCode").value(hasItem(DEFAULT_MAX_AUTH_CODE.intValue())))
            .andExpect(jsonPath("$.[*].authCode").value(hasItem(DEFAULT_AUTH_CODE.toString())))
            .andExpect(jsonPath("$.[*].authCategory").value(hasItem(DEFAULT_AUTH_CATEGORY)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(DEFAULT_CREATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedBy").value(hasItem(DEFAULT_LAST_MODIFIED_BY.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedDate").value(hasItem(DEFAULT_LAST_MODIFIED_DATE.toString())));
    }

    @Test
    @Transactional
    public void getBizAuth() throws Exception {
        // Initialize the database
        bizAuthRepository.saveAndFlush(bizAuth);

        // Get the bizAuth
        restBizAuthMockMvc.perform(get("/api/biz-auths/{id}", bizAuth.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bizAuth.getId().intValue()))
            .andExpect(jsonPath("$.bizName").value(DEFAULT_BIZ_NAME.toString()))
            .andExpect(jsonPath("$.roleCode").value(DEFAULT_ROLE_CODE.toString()))
            .andExpect(jsonPath("$.minAuthCode").value(DEFAULT_MIN_AUTH_CODE.intValue()))
            .andExpect(jsonPath("$.maxAuthCode").value(DEFAULT_MAX_AUTH_CODE.intValue()))
            .andExpect(jsonPath("$.authCode").value(DEFAULT_AUTH_CODE.toString()))
            .andExpect(jsonPath("$.authCategory").value(DEFAULT_AUTH_CATEGORY))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdDate").value(DEFAULT_CREATED_DATE.toString()))
            .andExpect(jsonPath("$.lastModifiedBy").value(DEFAULT_LAST_MODIFIED_BY.toString()))
            .andExpect(jsonPath("$.lastModifiedDate").value(DEFAULT_LAST_MODIFIED_DATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBizAuth() throws Exception {
        // Get the bizAuth
        restBizAuthMockMvc.perform(get("/api/biz-auths/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBizAuth() throws Exception {
        // Initialize the database
        bizAuthRepository.saveAndFlush(bizAuth);
        int databaseSizeBeforeUpdate = bizAuthRepository.findAll().size();

        // Update the bizAuth
        BizAuth updatedBizAuth = bizAuthRepository.findOne(bizAuth.getId());
        updatedBizAuth
            .bizName(UPDATED_BIZ_NAME)
            .roleCode(UPDATED_ROLE_CODE)
            .minAuthCode(UPDATED_MIN_AUTH_CODE)
            .maxAuthCode(UPDATED_MAX_AUTH_CODE)
            .authCode(UPDATED_AUTH_CODE)
            .authCategory(UPDATED_AUTH_CATEGORY)
            .createdBy(UPDATED_CREATED_BY)
            .createdDate(UPDATED_CREATED_DATE)
            .lastModifiedBy(UPDATED_LAST_MODIFIED_BY)
            .lastModifiedDate(UPDATED_LAST_MODIFIED_DATE);
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(updatedBizAuth);

        restBizAuthMockMvc.perform(put("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isOk());

        // Validate the BizAuth in the database
        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeUpdate);
        BizAuth testBizAuth = bizAuthList.get(bizAuthList.size() - 1);
        assertThat(testBizAuth.getBizName()).isEqualTo(UPDATED_BIZ_NAME);
        assertThat(testBizAuth.getRoleCode()).isEqualTo(UPDATED_ROLE_CODE);
        assertThat(testBizAuth.getMinAuthCode()).isEqualTo(UPDATED_MIN_AUTH_CODE);
        assertThat(testBizAuth.getMaxAuthCode()).isEqualTo(UPDATED_MAX_AUTH_CODE);
        assertThat(testBizAuth.getAuthCode()).isEqualTo(UPDATED_AUTH_CODE);
        assertThat(testBizAuth.getAuthCategory()).isEqualTo(UPDATED_AUTH_CATEGORY);
        assertThat(testBizAuth.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testBizAuth.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testBizAuth.getLastModifiedBy()).isEqualTo(UPDATED_LAST_MODIFIED_BY);
        assertThat(testBizAuth.getLastModifiedDate()).isEqualTo(UPDATED_LAST_MODIFIED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingBizAuth() throws Exception {
        int databaseSizeBeforeUpdate = bizAuthRepository.findAll().size();

        // Create the BizAuth
        BizAuthDTO bizAuthDTO = bizAuthMapper.toDto(bizAuth);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restBizAuthMockMvc.perform(put("/api/biz-auths")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bizAuthDTO)))
            .andExpect(status().isCreated());

        // Validate the BizAuth in the database
        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteBizAuth() throws Exception {
        // Initialize the database
        bizAuthRepository.saveAndFlush(bizAuth);
        int databaseSizeBeforeDelete = bizAuthRepository.findAll().size();

        // Get the bizAuth
        restBizAuthMockMvc.perform(delete("/api/biz-auths/{id}", bizAuth.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BizAuth> bizAuthList = bizAuthRepository.findAll();
        assertThat(bizAuthList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BizAuth.class);
        BizAuth bizAuth1 = new BizAuth();
        bizAuth1.setId(1L);
        BizAuth bizAuth2 = new BizAuth();
        bizAuth2.setId(bizAuth1.getId());
        assertThat(bizAuth1).isEqualTo(bizAuth2);
        bizAuth2.setId(2L);
        assertThat(bizAuth1).isNotEqualTo(bizAuth2);
        bizAuth1.setId(null);
        assertThat(bizAuth1).isNotEqualTo(bizAuth2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BizAuthDTO.class);
        BizAuthDTO bizAuthDTO1 = new BizAuthDTO();
        bizAuthDTO1.setId(1L);
        BizAuthDTO bizAuthDTO2 = new BizAuthDTO();
        assertThat(bizAuthDTO1).isNotEqualTo(bizAuthDTO2);
        bizAuthDTO2.setId(bizAuthDTO1.getId());
        assertThat(bizAuthDTO1).isEqualTo(bizAuthDTO2);
        bizAuthDTO2.setId(2L);
        assertThat(bizAuthDTO1).isNotEqualTo(bizAuthDTO2);
        bizAuthDTO1.setId(null);
        assertThat(bizAuthDTO1).isNotEqualTo(bizAuthDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(bizAuthMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(bizAuthMapper.fromId(null)).isNull();
    }
}
