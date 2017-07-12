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
import com.jumore.zhxf.domain.ReportCount;
import com.jumore.zhxf.repository.ReportCountRepository;
import com.jumore.zhxf.repository.search.ReportCountSearchRepository;
import com.jumore.zhxf.service.dto.ReportCountDTO;
import com.jumore.zhxf.service.mapper.ReportCountMapper;

/**
 * Test class for the ReportCountResource REST controller.
 *
 * @see ReportCountResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ReportCountResourceIntTest {

    private static final Long DEFAULT_USER_ID = 1L;
    private static final Long UPDATED_USER_ID = 2L;

    private static final String DEFAULT_PERSON_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_MOBILE = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_MOBILE = "BBBBBBBBBB";

    private static final Long DEFAULT_EVENT_ID = 1L;
    private static final Long UPDATED_EVENT_ID = 2L;

    private static final Long DEFAULT_COMPLETE_NUM = 1L;
    private static final Long UPDATED_COMPLETE_NUM = 2L;

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_MODIFY_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_MODIFY_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Inject
    private ReportCountRepository reportCountRepository;

    @Inject
    private ReportCountMapper reportCountMapper;

    @Inject
    private ReportCountSearchRepository reportCountSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    private EntityManager em;

    private MockMvc restReportCountMockMvc;

    private ReportCount reportCount;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReportCountResource reportCountResource = new ReportCountResource();
        ReflectionTestUtils.setField(reportCountResource, "reportCountSearchRepository", reportCountSearchRepository);
        ReflectionTestUtils.setField(reportCountResource, "reportCountRepository", reportCountRepository);
        ReflectionTestUtils.setField(reportCountResource, "reportCountMapper", reportCountMapper);
        this.restReportCountMockMvc = MockMvcBuilders.standaloneSetup(reportCountResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReportCount createEntity(EntityManager em) {
        ReportCount reportCount = new ReportCount()
                .userId(DEFAULT_USER_ID)
                .personName(DEFAULT_PERSON_NAME)
                .personMobile(DEFAULT_PERSON_MOBILE)
                .eventId(DEFAULT_EVENT_ID)
                .completedNum(DEFAULT_COMPLETE_NUM)
                .remark(DEFAULT_REMARK)
                .createdTime(DEFAULT_CREATE_TIME)
                .modifyTime(DEFAULT_MODIFY_TIME);
        return reportCount;
    }

    @Before
    public void initTest() {
        reportCountSearchRepository.deleteAll();
        reportCount = createEntity(em);
    }

    @Test
    @Transactional
    public void createReportCount() throws Exception {
        int databaseSizeBeforeCreate = reportCountRepository.findAll().size();

        // Create the ReportCount
        ReportCountDTO reportCountDTO = reportCountMapper.reportCountToReportCountDTO(reportCount);

        restReportCountMockMvc.perform(post("/api/report-counts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reportCountDTO)))
            .andExpect(status().isCreated());

        // Validate the ReportCount in the database
        List<ReportCount> reportCountList = reportCountRepository.findAll();
        assertThat(reportCountList).hasSize(databaseSizeBeforeCreate + 1);
        ReportCount testReportCount = reportCountList.get(reportCountList.size() - 1);
        assertThat(testReportCount.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testReportCount.getPersonName()).isEqualTo(DEFAULT_PERSON_NAME);
        assertThat(testReportCount.getPersonMobile()).isEqualTo(DEFAULT_PERSON_MOBILE);
        assertThat(testReportCount.getEventId()).isEqualTo(DEFAULT_EVENT_ID);
        assertThat(testReportCount.getCompletedNum()).isEqualTo(DEFAULT_COMPLETE_NUM);
        assertThat(testReportCount.getRemark()).isEqualTo(DEFAULT_REMARK);
        assertThat(testReportCount.getCreatedTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testReportCount.getModifyTime()).isEqualTo(DEFAULT_MODIFY_TIME);

        // Validate the ReportCount in ElasticSearch
        ReportCount reportCountEs = reportCountSearchRepository.findOne(testReportCount.getId());
        assertThat(reportCountEs).isEqualToComparingFieldByField(testReportCount);
    }

    @Test
    @Transactional
    public void createReportCountWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = reportCountRepository.findAll().size();

        // Create the ReportCount with an existing ID
        ReportCount existingReportCount = new ReportCount();
        existingReportCount.setId(1L);
        ReportCountDTO existingReportCountDTO = reportCountMapper.reportCountToReportCountDTO(existingReportCount);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReportCountMockMvc.perform(post("/api/report-counts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(existingReportCountDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<ReportCount> reportCountList = reportCountRepository.findAll();
        assertThat(reportCountList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllReportCounts() throws Exception {
        // Initialize the database
        reportCountRepository.saveAndFlush(reportCount);

        // Get all the reportCountList
        restReportCountMockMvc.perform(get("/api/report-counts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reportCount.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].personName").value(hasItem(DEFAULT_PERSON_NAME.toString())))
            .andExpect(jsonPath("$.[*].personMobile").value(hasItem(DEFAULT_PERSON_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].eventId").value(hasItem(DEFAULT_EVENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].completeNum").value(hasItem(DEFAULT_COMPLETE_NUM.intValue())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(sameInstant(DEFAULT_MODIFY_TIME))));
    }

    @Test
    @Transactional
    public void getReportCount() throws Exception {
        // Initialize the database
        reportCountRepository.saveAndFlush(reportCount);

        // Get the reportCount
        restReportCountMockMvc.perform(get("/api/report-counts/{id}", reportCount.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reportCount.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.intValue()))
            .andExpect(jsonPath("$.personName").value(DEFAULT_PERSON_NAME.toString()))
            .andExpect(jsonPath("$.personMobile").value(DEFAULT_PERSON_MOBILE.toString()))
            .andExpect(jsonPath("$.eventId").value(DEFAULT_EVENT_ID.intValue()))
            .andExpect(jsonPath("$.completeNum").value(DEFAULT_COMPLETE_NUM.intValue()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)))
            .andExpect(jsonPath("$.modifyTime").value(sameInstant(DEFAULT_MODIFY_TIME)));
    }

    @Test
    @Transactional
    public void getNonExistingReportCount() throws Exception {
        // Get the reportCount
        restReportCountMockMvc.perform(get("/api/report-counts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReportCount() throws Exception {
        // Initialize the database
        reportCountRepository.saveAndFlush(reportCount);
        reportCountSearchRepository.save(reportCount);
        int databaseSizeBeforeUpdate = reportCountRepository.findAll().size();

        // Update the reportCount
        ReportCount updatedReportCount = reportCountRepository.findOne(reportCount.getId());
        updatedReportCount
                .userId(UPDATED_USER_ID)
                .personName(UPDATED_PERSON_NAME)
                .personMobile(UPDATED_PERSON_MOBILE)
                .eventId(UPDATED_EVENT_ID)
                .completedNum(UPDATED_COMPLETE_NUM)
                .remark(UPDATED_REMARK)
                .createdTime(UPDATED_CREATE_TIME)
                .modifyTime(UPDATED_MODIFY_TIME);
        ReportCountDTO reportCountDTO = reportCountMapper.reportCountToReportCountDTO(updatedReportCount);

        restReportCountMockMvc.perform(put("/api/report-counts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reportCountDTO)))
            .andExpect(status().isOk());

        // Validate the ReportCount in the database
        List<ReportCount> reportCountList = reportCountRepository.findAll();
        assertThat(reportCountList).hasSize(databaseSizeBeforeUpdate);
        ReportCount testReportCount = reportCountList.get(reportCountList.size() - 1);
        assertThat(testReportCount.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testReportCount.getPersonName()).isEqualTo(UPDATED_PERSON_NAME);
        assertThat(testReportCount.getPersonMobile()).isEqualTo(UPDATED_PERSON_MOBILE);
        assertThat(testReportCount.getEventId()).isEqualTo(UPDATED_EVENT_ID);
        assertThat(testReportCount.getCompletedNum()).isEqualTo(UPDATED_COMPLETE_NUM);
        assertThat(testReportCount.getRemark()).isEqualTo(UPDATED_REMARK);
        assertThat(testReportCount.getCreatedTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testReportCount.getModifyTime()).isEqualTo(UPDATED_MODIFY_TIME);

        // Validate the ReportCount in ElasticSearch
        ReportCount reportCountEs = reportCountSearchRepository.findOne(testReportCount.getId());
        assertThat(reportCountEs).isEqualToComparingFieldByField(testReportCount);
    }

    @Test
    @Transactional
    public void updateNonExistingReportCount() throws Exception {
        int databaseSizeBeforeUpdate = reportCountRepository.findAll().size();

        // Create the ReportCount
        ReportCountDTO reportCountDTO = reportCountMapper.reportCountToReportCountDTO(reportCount);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restReportCountMockMvc.perform(put("/api/report-counts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reportCountDTO)))
            .andExpect(status().isCreated());

        // Validate the ReportCount in the database
        List<ReportCount> reportCountList = reportCountRepository.findAll();
        assertThat(reportCountList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteReportCount() throws Exception {
        // Initialize the database
        reportCountRepository.saveAndFlush(reportCount);
        reportCountSearchRepository.save(reportCount);
        int databaseSizeBeforeDelete = reportCountRepository.findAll().size();

        // Get the reportCount
        restReportCountMockMvc.perform(delete("/api/report-counts/{id}", reportCount.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate ElasticSearch is empty
        boolean reportCountExistsInEs = reportCountSearchRepository.exists(reportCount.getId());
        assertThat(reportCountExistsInEs).isFalse();

        // Validate the database is empty
        List<ReportCount> reportCountList = reportCountRepository.findAll();
        assertThat(reportCountList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchReportCount() throws Exception {
        // Initialize the database
        reportCountRepository.saveAndFlush(reportCount);
        reportCountSearchRepository.save(reportCount);

        // Search the reportCount
        restReportCountMockMvc.perform(get("/api/_search/report-counts?query=id:" + reportCount.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reportCount.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].personName").value(hasItem(DEFAULT_PERSON_NAME.toString())))
            .andExpect(jsonPath("$.[*].personMobile").value(hasItem(DEFAULT_PERSON_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].eventId").value(hasItem(DEFAULT_EVENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].completeNum").value(hasItem(DEFAULT_COMPLETE_NUM.intValue())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(sameInstant(DEFAULT_MODIFY_TIME))));
    }
}
