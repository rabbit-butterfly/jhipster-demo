package com.rd.pcms.web.rest;

import com.Application;
import com.jumore.zhxf.domain.User;
import com.jumore.zhxf.web.rest.TestUtil;
import com.jumore.zhxf.web.rest.UserResourceIntTest;

import com.jumore.zhxf.web.rest.errors.ExceptionTranslator;
import com.rd.pcms.domain.UserInfo;
import com.rd.pcms.domain.Company;
import com.rd.pcms.repository.UserInfoRepository;
import com.rd.pcms.service.UserInfoService;
import com.rd.pcms.service.dto.UserInfoDTO;
import com.rd.pcms.service.mapper.UserInfoMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
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
 * Test class for the UserInfoResource REST controller.
 *
 * @see UserInfoResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserInfoResourceIntTest {

    private static final Long DEFAULT_COMP_ID = 0L;
    private static final Long UPDATED_COMP_ID = 1L;

    private static final Long DEFAULT_CODE = 0L;
    private static final Long UPDATED_CODE = 1L;

    private static final String DEFAULT_MOBILE = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAA";
    private static final String UPDATED_STATUS = "BBBBB";

    private static final String DEFAULT_JOB_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_JOB_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_MAJOR = "AAAAAAAAAA";
    private static final String UPDATED_MAJOR = "BBBBBBBBBB";

    private static final Long DEFAULT_JH_USER_ID = 0L;
    private static final Long UPDATED_JH_USER_ID = 1L;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restUserInfoMockMvc;

    private UserInfo userInfo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        UserInfoResource userInfoResource = new UserInfoResource(userInfoService);
        this.restUserInfoMockMvc = MockMvcBuilders.standaloneSetup(userInfoResource)
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
    public static UserInfo createEntity(EntityManager em) {
        UserInfo userInfo = new UserInfo()
            .compId(DEFAULT_COMP_ID)
            .code(DEFAULT_CODE)
            .mobile(DEFAULT_MOBILE)
            .status(DEFAULT_STATUS)
            .jobTitle(DEFAULT_JOB_TITLE)
            .major(DEFAULT_MAJOR)
            .jhUserId(DEFAULT_JH_USER_ID);
        // Add required entity
        User user = null ;//UserResourceIntTest.createEntity(em);
        em.persist(user);
        em.flush();
        userInfo.setUser(user);
        // Add required entity
        Company company = null; //CompanyResourceIntTest.createEntity(em);
        em.persist(company);
        em.flush();
        userInfo.setCompany(company);
        return userInfo;
    }

    @Before
    public void initTest() {
        userInfo = createEntity(em);
    }

    @Test
    @Transactional
    public void createUserInfo() throws Exception {
        int databaseSizeBeforeCreate = userInfoRepository.findAll().size();

        // Create the UserInfo
        UserInfoDTO userInfoDTO = userInfoMapper.toDto(userInfo);
        restUserInfoMockMvc.perform(post("/api/user-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userInfoDTO)))
            .andExpect(status().isCreated());

        // Validate the UserInfo in the database
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        assertThat(userInfoList).hasSize(databaseSizeBeforeCreate + 1);
        UserInfo testUserInfo = userInfoList.get(userInfoList.size() - 1);
        assertThat(testUserInfo.getCompId()).isEqualTo(DEFAULT_COMP_ID);
        assertThat(testUserInfo.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testUserInfo.getMobile()).isEqualTo(DEFAULT_MOBILE);
        assertThat(testUserInfo.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testUserInfo.getJobTitle()).isEqualTo(DEFAULT_JOB_TITLE);
        assertThat(testUserInfo.getMajor()).isEqualTo(DEFAULT_MAJOR);
        assertThat(testUserInfo.getJhUserId()).isEqualTo(DEFAULT_JH_USER_ID);
    }

    @Test
    @Transactional
    public void createUserInfoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = userInfoRepository.findAll().size();

        // Create the UserInfo with an existing ID
        userInfo.setId(1L);
        UserInfoDTO userInfoDTO = userInfoMapper.toDto(userInfo);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUserInfoMockMvc.perform(post("/api/user-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userInfoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        assertThat(userInfoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkCompIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = userInfoRepository.findAll().size();
        // set the field null
        userInfo.setCompId(null);

        // Create the UserInfo, which fails.
        UserInfoDTO userInfoDTO = userInfoMapper.toDto(userInfo);

        restUserInfoMockMvc.perform(post("/api/user-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userInfoDTO)))
            .andExpect(status().isBadRequest());

        List<UserInfo> userInfoList = userInfoRepository.findAll();
        assertThat(userInfoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkJhUserIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = userInfoRepository.findAll().size();
        // set the field null
        userInfo.setJhUserId(null);

        // Create the UserInfo, which fails.
        UserInfoDTO userInfoDTO = userInfoMapper.toDto(userInfo);

        restUserInfoMockMvc.perform(post("/api/user-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userInfoDTO)))
            .andExpect(status().isBadRequest());

        List<UserInfo> userInfoList = userInfoRepository.findAll();
        assertThat(userInfoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUserInfos() throws Exception {
        // Initialize the database
        userInfoRepository.saveAndFlush(userInfo);

        // Get all the userInfoList
        restUserInfoMockMvc.perform(get("/api/user-infos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(userInfo.getId().intValue())))
            .andExpect(jsonPath("$.[*].compId").value(hasItem(DEFAULT_COMP_ID.intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.intValue())))
            .andExpect(jsonPath("$.[*].mobile").value(hasItem(DEFAULT_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].jobTitle").value(hasItem(DEFAULT_JOB_TITLE.toString())))
            .andExpect(jsonPath("$.[*].major").value(hasItem(DEFAULT_MAJOR.toString())))
            .andExpect(jsonPath("$.[*].jhUserId").value(hasItem(DEFAULT_JH_USER_ID.intValue())));
    }

    @Test
    @Transactional
    public void getUserInfo() throws Exception {
        // Initialize the database
        userInfoRepository.saveAndFlush(userInfo);

        // Get the userInfo
        restUserInfoMockMvc.perform(get("/api/user-infos/{id}", userInfo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(userInfo.getId().intValue()))
            .andExpect(jsonPath("$.compId").value(DEFAULT_COMP_ID.intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.intValue()))
            .andExpect(jsonPath("$.mobile").value(DEFAULT_MOBILE.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.jobTitle").value(DEFAULT_JOB_TITLE.toString()))
            .andExpect(jsonPath("$.major").value(DEFAULT_MAJOR.toString()))
            .andExpect(jsonPath("$.jhUserId").value(DEFAULT_JH_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingUserInfo() throws Exception {
        // Get the userInfo
        restUserInfoMockMvc.perform(get("/api/user-infos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUserInfo() throws Exception {
        // Initialize the database
        userInfoRepository.saveAndFlush(userInfo);
        int databaseSizeBeforeUpdate = userInfoRepository.findAll().size();

        // Update the userInfo
        UserInfo updatedUserInfo = userInfoRepository.findOne(userInfo.getId());
        updatedUserInfo
            .compId(UPDATED_COMP_ID)
            .code(UPDATED_CODE)
            .mobile(UPDATED_MOBILE)
            .status(UPDATED_STATUS)
            .jobTitle(UPDATED_JOB_TITLE)
            .major(UPDATED_MAJOR)
            .jhUserId(UPDATED_JH_USER_ID);
        UserInfoDTO userInfoDTO = userInfoMapper.toDto(updatedUserInfo);

        restUserInfoMockMvc.perform(put("/api/user-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userInfoDTO)))
            .andExpect(status().isOk());

        // Validate the UserInfo in the database
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        assertThat(userInfoList).hasSize(databaseSizeBeforeUpdate);
        UserInfo testUserInfo = userInfoList.get(userInfoList.size() - 1);
        assertThat(testUserInfo.getCompId()).isEqualTo(UPDATED_COMP_ID);
        assertThat(testUserInfo.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testUserInfo.getMobile()).isEqualTo(UPDATED_MOBILE);
        assertThat(testUserInfo.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testUserInfo.getJobTitle()).isEqualTo(UPDATED_JOB_TITLE);
        assertThat(testUserInfo.getMajor()).isEqualTo(UPDATED_MAJOR);
        assertThat(testUserInfo.getJhUserId()).isEqualTo(UPDATED_JH_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingUserInfo() throws Exception {
        int databaseSizeBeforeUpdate = userInfoRepository.findAll().size();

        // Create the UserInfo
        UserInfoDTO userInfoDTO = userInfoMapper.toDto(userInfo);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restUserInfoMockMvc.perform(put("/api/user-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userInfoDTO)))
            .andExpect(status().isCreated());

        // Validate the UserInfo in the database
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        assertThat(userInfoList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteUserInfo() throws Exception {
        // Initialize the database
        userInfoRepository.saveAndFlush(userInfo);
        int databaseSizeBeforeDelete = userInfoRepository.findAll().size();

        // Get the userInfo
        restUserInfoMockMvc.perform(delete("/api/user-infos/{id}", userInfo.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        assertThat(userInfoList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserInfo.class);
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1L);
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(userInfo1.getId());
        assertThat(userInfo1).isEqualTo(userInfo2);
        userInfo2.setId(2L);
        assertThat(userInfo1).isNotEqualTo(userInfo2);
        userInfo1.setId(null);
        assertThat(userInfo1).isNotEqualTo(userInfo2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserInfoDTO.class);
        UserInfoDTO userInfoDTO1 = new UserInfoDTO();
        userInfoDTO1.setId(1L);
        UserInfoDTO userInfoDTO2 = new UserInfoDTO();
        assertThat(userInfoDTO1).isNotEqualTo(userInfoDTO2);
        userInfoDTO2.setId(userInfoDTO1.getId());
        assertThat(userInfoDTO1).isEqualTo(userInfoDTO2);
        userInfoDTO2.setId(2L);
        assertThat(userInfoDTO1).isNotEqualTo(userInfoDTO2);
        userInfoDTO1.setId(null);
        assertThat(userInfoDTO1).isNotEqualTo(userInfoDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(userInfoMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(userInfoMapper.fromId(null)).isNull();
    }
}
