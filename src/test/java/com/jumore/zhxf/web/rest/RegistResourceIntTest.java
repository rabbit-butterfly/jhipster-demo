package com.jumore.zhxf.web.rest;

import static com.jumore.zhxf.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.Application;
import com.jumore.zhxf.domain.Regist;
import com.jumore.zhxf.repository.RegistRepository;
import com.jumore.zhxf.repository.search.RegistSearchRepository;
import com.jumore.zhxf.service.dto.RegistDTO;
import com.jumore.zhxf.service.mapper.RegistMapper;

/**
 * Test class for the RegistResource REST controller.
 *
 * @see RegistResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RegistResourceIntTest {

    private static final Long DEFAULT_USER_ID = 1L;
    private static final Long UPDATED_USER_ID = 2L;

    private static final String DEFAULT_PERSION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PERSION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_MOBILE = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_MOBILE = "BBBBBBBBBB";

    private static final Long DEFAULT_EVENT_ID = 1L;
    private static final Long UPDATED_EVENT_ID = 2L;

    private static final Long DEFAULT_TARGET_NUM = 1L;
    private static final Long UPDATED_TARGET_NUM = 2L;

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_MODIFY_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_MODIFY_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Inject
    private RegistRepository registRepository;

    @Inject
    private RegistMapper registMapper;

    @Inject
    private RegistSearchRepository registSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    private EntityManager em;

    private MockMvc restRegistMockMvc;

    private Regist regist;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RegistResource registResource = new RegistResource();
        ReflectionTestUtils.setField(registResource, "registSearchRepository", registSearchRepository);
        ReflectionTestUtils.setField(registResource, "registRepository", registRepository);
        ReflectionTestUtils.setField(registResource, "registMapper", registMapper);
        this.restRegistMockMvc = MockMvcBuilders.standaloneSetup(registResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Regist createEntity(EntityManager em) {
        Regist regist = new Regist()
                .userId(DEFAULT_USER_ID)
                .personName(DEFAULT_PERSION_NAME)
                .personMobile(DEFAULT_PERSON_MOBILE)
                .eventId(DEFAULT_EVENT_ID)
                .targetNum(DEFAULT_TARGET_NUM)
                .remark(DEFAULT_REMARK)
                .createdTime(DEFAULT_CREATE_TIME)
                .modifyTime(DEFAULT_MODIFY_TIME);
        return regist;
    }

    @Before
    public void initTest() {
        registSearchRepository.deleteAll();
        regist = createEntity(em);
    }

    @Test
    @Transactional
    public void createRegist() throws Exception {
        int databaseSizeBeforeCreate = registRepository.findAll().size();

        // Create the Regist
        RegistDTO registDTO = registMapper.registToRegistDTO(regist);

        restRegistMockMvc.perform(post("/api/regists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registDTO)))
            .andExpect(status().isCreated());

        // Validate the Regist in the database
        List<Regist> registList = registRepository.findAll();
        assertThat(registList).hasSize(databaseSizeBeforeCreate + 1);
        Regist testRegist = registList.get(registList.size() - 1);
        assertThat(testRegist.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testRegist.getPersonName()).isEqualTo(DEFAULT_PERSION_NAME);
        assertThat(testRegist.getPersonMobile()).isEqualTo(DEFAULT_PERSON_MOBILE);
        assertThat(testRegist.getEventId()).isEqualTo(DEFAULT_EVENT_ID);
        assertThat(testRegist.getTargetNum()).isEqualTo(DEFAULT_TARGET_NUM);
        assertThat(testRegist.getRemark()).isEqualTo(DEFAULT_REMARK);
        assertThat(testRegist.getCreatedTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testRegist.getModifyTime()).isEqualTo(DEFAULT_MODIFY_TIME);

        // Validate the Regist in ElasticSearch
        Regist registEs = registSearchRepository.findOne(testRegist.getId());
        assertThat(registEs).isEqualToComparingFieldByField(testRegist);
    }

    @Test
    @Transactional
    public void createRegistWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = registRepository.findAll().size();

        // Create the Regist with an existing ID
        Regist existingRegist = new Regist();
        existingRegist.setId(1L);
        RegistDTO existingRegistDTO = registMapper.registToRegistDTO(existingRegist);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRegistMockMvc.perform(post("/api/regists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(existingRegistDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Regist> registList = registRepository.findAll();
        assertThat(registList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRegists() throws Exception {
        // Initialize the database
        registRepository.saveAndFlush(regist);

        // Get all the registList
        restRegistMockMvc.perform(get("/api/regists?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(regist.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].persionName").value(hasItem(DEFAULT_PERSION_NAME.toString())))
            .andExpect(jsonPath("$.[*].personMobile").value(hasItem(DEFAULT_PERSON_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].eventId").value(hasItem(DEFAULT_EVENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].targetNum").value(hasItem(DEFAULT_TARGET_NUM.intValue())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(sameInstant(DEFAULT_MODIFY_TIME))));
    }

    @Test
    @Transactional
    public void getRegist() throws Exception {
        // Initialize the database
        registRepository.saveAndFlush(regist);

        // Get the regist
        restRegistMockMvc.perform(get("/api/regists/{id}", regist.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(regist.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.intValue()))
            .andExpect(jsonPath("$.persionName").value(DEFAULT_PERSION_NAME.toString()))
            .andExpect(jsonPath("$.personMobile").value(DEFAULT_PERSON_MOBILE.toString()))
            .andExpect(jsonPath("$.eventId").value(DEFAULT_EVENT_ID.intValue()))
            .andExpect(jsonPath("$.targetNum").value(DEFAULT_TARGET_NUM.intValue()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)))
            .andExpect(jsonPath("$.modifyTime").value(sameInstant(DEFAULT_MODIFY_TIME)));
    }

    @Test
    @Transactional
    public void getNonExistingRegist() throws Exception {
        // Get the regist
        restRegistMockMvc.perform(get("/api/regists/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRegist() throws Exception {
        // Initialize the database
        registRepository.saveAndFlush(regist);
        registSearchRepository.save(regist);
        int databaseSizeBeforeUpdate = registRepository.findAll().size();

        // Update the regist
        Regist updatedRegist = registRepository.findOne(regist.getId());
        updatedRegist
                .userId(UPDATED_USER_ID)
                .personName(UPDATED_PERSION_NAME)
                .personMobile(UPDATED_PERSON_MOBILE)
                .eventId(UPDATED_EVENT_ID)
                .targetNum(UPDATED_TARGET_NUM)
                .remark(UPDATED_REMARK)
                .createdTime(UPDATED_CREATE_TIME)
                .modifyTime(UPDATED_MODIFY_TIME);
        RegistDTO registDTO = registMapper.registToRegistDTO(updatedRegist);

        restRegistMockMvc.perform(put("/api/regists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registDTO)))
            .andExpect(status().isOk());

        // Validate the Regist in the database
        List<Regist> registList = registRepository.findAll();
        assertThat(registList).hasSize(databaseSizeBeforeUpdate);
        Regist testRegist = registList.get(registList.size() - 1);
        assertThat(testRegist.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testRegist.getPersonName()).isEqualTo(UPDATED_PERSION_NAME);
        assertThat(testRegist.getPersonMobile()).isEqualTo(UPDATED_PERSON_MOBILE);
        assertThat(testRegist.getEventId()).isEqualTo(UPDATED_EVENT_ID);
        assertThat(testRegist.getTargetNum()).isEqualTo(UPDATED_TARGET_NUM);
        assertThat(testRegist.getRemark()).isEqualTo(UPDATED_REMARK);
        assertThat(testRegist.getCreatedTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testRegist.getModifyTime()).isEqualTo(UPDATED_MODIFY_TIME);

        // Validate the Regist in ElasticSearch
        Regist registEs = registSearchRepository.findOne(testRegist.getId());
        assertThat(registEs).isEqualToComparingFieldByField(testRegist);
    }

    @Test
    @Transactional
    public void updateNonExistingRegist() throws Exception {
        int databaseSizeBeforeUpdate = registRepository.findAll().size();

        // Create the Regist
        RegistDTO registDTO = registMapper.registToRegistDTO(regist);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRegistMockMvc.perform(put("/api/regists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registDTO)))
            .andExpect(status().isCreated());

        // Validate the Regist in the database
        List<Regist> registList = registRepository.findAll();
        assertThat(registList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRegist() throws Exception {
        // Initialize the database
        registRepository.saveAndFlush(regist);
        registSearchRepository.save(regist);
        int databaseSizeBeforeDelete = registRepository.findAll().size();

        // Get the regist
        restRegistMockMvc.perform(delete("/api/regists/{id}", regist.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate ElasticSearch is empty
        boolean registExistsInEs = registSearchRepository.exists(regist.getId());
        assertThat(registExistsInEs).isFalse();

        // Validate the database is empty
        List<Regist> registList = registRepository.findAll();
        assertThat(registList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchRegist() throws Exception {
        // Initialize the database
        registRepository.saveAndFlush(regist);
        registSearchRepository.save(regist);

        // Search the regist
        restRegistMockMvc.perform(get("/api/_search/regists?query=id:" + regist.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(regist.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].persionName").value(hasItem(DEFAULT_PERSION_NAME.toString())))
            .andExpect(jsonPath("$.[*].personMobile").value(hasItem(DEFAULT_PERSON_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].eventId").value(hasItem(DEFAULT_EVENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].targetNum").value(hasItem(DEFAULT_TARGET_NUM.intValue())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(sameInstant(DEFAULT_MODIFY_TIME))));
    }
}
