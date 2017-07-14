package local.tux.app.web.rest;

import local.tux.app.TuxAdminApp;

import local.tux.app.domain.Project;
import local.tux.app.repository.ProjectRepository;
import local.tux.app.repository.search.ProjectSearchRepository;
import local.tux.app.web.rest.errors.ExceptionTranslator;

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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ProjectResource REST controller.
 *
 * @see ProjectResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TuxAdminApp.class)
public class ProjectResourceIntTest {

    private static final String DEFAULT_PROJECT_COMP_ID = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_COMP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PROJECT_COMP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_COMP_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PROJECT_BAME = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_BAME = "BBBBBBBBBB";

    private static final String DEFAULT_PROJECT_DESC = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_DESC = "BBBBBBBBBB";

    private static final Integer DEFAULT_PROJECT_STATUS = 1;
    private static final Integer UPDATED_PROJECT_STATUS = 2;

    private static final Long DEFAULT_SUPERVISOR_COMP_ID = 1L;
    private static final Long UPDATED_SUPERVISOR_COMP_ID = 2L;

    private static final String DEFAULT_SUPERVISOR_COMP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SUPERVISOR_COMP_NAME = "BBBBBBBBBB";

    private static final Long DEFAULT_CONTRACTOR_COMP_ID = 1L;
    private static final Long UPDATED_CONTRACTOR_COMP_ID = 2L;

    private static final String DEFAULT_CONTRACTOR_COMP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACTOR_COMP_NAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_START_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_START_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_END_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_END_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_CREATED_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_MODIFY_BY = 1L;
    private static final Long UPDATED_MODIFY_BY = 2L;

    private static final Instant DEFAULT_MODIFY_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_MODIFY_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_DEL_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_DEL_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectSearchRepository projectSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restProjectMockMvc;

    private Project project;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ProjectResource projectResource = new ProjectResource(projectRepository, projectSearchRepository);
        this.restProjectMockMvc = MockMvcBuilders.standaloneSetup(projectResource)
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
    public static Project createEntity(EntityManager em) {
        Project project = new Project()
            .projectCompId(DEFAULT_PROJECT_COMP_ID)
            .projectCompName(DEFAULT_PROJECT_COMP_NAME)
            .projectBame(DEFAULT_PROJECT_BAME)
            .projectDesc(DEFAULT_PROJECT_DESC)
            .projectStatus(DEFAULT_PROJECT_STATUS)
            .supervisorCompId(DEFAULT_SUPERVISOR_COMP_ID)
            .supervisorCompName(DEFAULT_SUPERVISOR_COMP_NAME)
            .contractorCompId(DEFAULT_CONTRACTOR_COMP_ID)
            .contractorCompName(DEFAULT_CONTRACTOR_COMP_NAME)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .createdBy(DEFAULT_CREATED_BY)
            .createdTime(DEFAULT_CREATED_TIME)
            .modifyBy(DEFAULT_MODIFY_BY)
            .modifyTime(DEFAULT_MODIFY_TIME)
            .delFlag(DEFAULT_DEL_FLAG)
            .remark(DEFAULT_REMARK);
        return project;
    }

    @Before
    public void initTest() {
        projectSearchRepository.deleteAll();
        project = createEntity(em);
    }

    @Test
    @Transactional
    public void createProject() throws Exception {
        int databaseSizeBeforeCreate = projectRepository.findAll().size();

        // Create the Project
        restProjectMockMvc.perform(post("/api/projects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(project)))
            .andExpect(status().isCreated());

        // Validate the Project in the database
        List<Project> projectList = projectRepository.findAll();
        assertThat(projectList).hasSize(databaseSizeBeforeCreate + 1);
        Project testProject = projectList.get(projectList.size() - 1);
        assertThat(testProject.getProjectCompId()).isEqualTo(DEFAULT_PROJECT_COMP_ID);
        assertThat(testProject.getProjectCompName()).isEqualTo(DEFAULT_PROJECT_COMP_NAME);
        assertThat(testProject.getProjectBame()).isEqualTo(DEFAULT_PROJECT_BAME);
        assertThat(testProject.getProjectDesc()).isEqualTo(DEFAULT_PROJECT_DESC);
        assertThat(testProject.getProjectStatus()).isEqualTo(DEFAULT_PROJECT_STATUS);
        assertThat(testProject.getSupervisorCompId()).isEqualTo(DEFAULT_SUPERVISOR_COMP_ID);
        assertThat(testProject.getSupervisorCompName()).isEqualTo(DEFAULT_SUPERVISOR_COMP_NAME);
        assertThat(testProject.getContractorCompId()).isEqualTo(DEFAULT_CONTRACTOR_COMP_ID);
        assertThat(testProject.getContractorCompName()).isEqualTo(DEFAULT_CONTRACTOR_COMP_NAME);
        assertThat(testProject.getStartDate()).isEqualTo(DEFAULT_START_DATE);
        assertThat(testProject.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testProject.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testProject.getCreatedTime()).isEqualTo(DEFAULT_CREATED_TIME);
        assertThat(testProject.getModifyBy()).isEqualTo(DEFAULT_MODIFY_BY);
        assertThat(testProject.getModifyTime()).isEqualTo(DEFAULT_MODIFY_TIME);
        assertThat(testProject.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testProject.getRemark()).isEqualTo(DEFAULT_REMARK);

        // Validate the Project in Elasticsearch
        Project projectEs = projectSearchRepository.findOne(testProject.getId());
        assertThat(projectEs).isEqualToComparingFieldByField(testProject);
    }

    @Test
    @Transactional
    public void createProjectWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = projectRepository.findAll().size();

        // Create the Project with an existing ID
        project.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProjectMockMvc.perform(post("/api/projects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(project)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Project> projectList = projectRepository.findAll();
        assertThat(projectList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllProjects() throws Exception {
        // Initialize the database
        projectRepository.saveAndFlush(project);

        // Get all the projectList
        restProjectMockMvc.perform(get("/api/projects?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(project.getId().intValue())))
            .andExpect(jsonPath("$.[*].projectCompId").value(hasItem(DEFAULT_PROJECT_COMP_ID.toString())))
            .andExpect(jsonPath("$.[*].projectCompName").value(hasItem(DEFAULT_PROJECT_COMP_NAME.toString())))
            .andExpect(jsonPath("$.[*].projectBame").value(hasItem(DEFAULT_PROJECT_BAME.toString())))
            .andExpect(jsonPath("$.[*].projectDesc").value(hasItem(DEFAULT_PROJECT_DESC.toString())))
            .andExpect(jsonPath("$.[*].projectStatus").value(hasItem(DEFAULT_PROJECT_STATUS)))
            .andExpect(jsonPath("$.[*].supervisorCompId").value(hasItem(DEFAULT_SUPERVISOR_COMP_ID.intValue())))
            .andExpect(jsonPath("$.[*].supervisorCompName").value(hasItem(DEFAULT_SUPERVISOR_COMP_NAME.toString())))
            .andExpect(jsonPath("$.[*].contractorCompId").value(hasItem(DEFAULT_CONTRACTOR_COMP_ID.intValue())))
            .andExpect(jsonPath("$.[*].contractorCompName").value(hasItem(DEFAULT_CONTRACTOR_COMP_NAME.toString())))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].createdTime").value(hasItem(DEFAULT_CREATED_TIME.toString())))
            .andExpect(jsonPath("$.[*].modifyBy").value(hasItem(DEFAULT_MODIFY_BY.intValue())))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(DEFAULT_MODIFY_TIME.toString())))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }

    @Test
    @Transactional
    public void getProject() throws Exception {
        // Initialize the database
        projectRepository.saveAndFlush(project);

        // Get the project
        restProjectMockMvc.perform(get("/api/projects/{id}", project.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(project.getId().intValue()))
            .andExpect(jsonPath("$.projectCompId").value(DEFAULT_PROJECT_COMP_ID.toString()))
            .andExpect(jsonPath("$.projectCompName").value(DEFAULT_PROJECT_COMP_NAME.toString()))
            .andExpect(jsonPath("$.projectBame").value(DEFAULT_PROJECT_BAME.toString()))
            .andExpect(jsonPath("$.projectDesc").value(DEFAULT_PROJECT_DESC.toString()))
            .andExpect(jsonPath("$.projectStatus").value(DEFAULT_PROJECT_STATUS))
            .andExpect(jsonPath("$.supervisorCompId").value(DEFAULT_SUPERVISOR_COMP_ID.intValue()))
            .andExpect(jsonPath("$.supervisorCompName").value(DEFAULT_SUPERVISOR_COMP_NAME.toString()))
            .andExpect(jsonPath("$.contractorCompId").value(DEFAULT_CONTRACTOR_COMP_ID.intValue()))
            .andExpect(jsonPath("$.contractorCompName").value(DEFAULT_CONTRACTOR_COMP_NAME.toString()))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.createdTime").value(DEFAULT_CREATED_TIME.toString()))
            .andExpect(jsonPath("$.modifyBy").value(DEFAULT_MODIFY_BY.intValue()))
            .andExpect(jsonPath("$.modifyTime").value(DEFAULT_MODIFY_TIME.toString()))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProject() throws Exception {
        // Get the project
        restProjectMockMvc.perform(get("/api/projects/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProject() throws Exception {
        // Initialize the database
        projectRepository.saveAndFlush(project);
        projectSearchRepository.save(project);
        int databaseSizeBeforeUpdate = projectRepository.findAll().size();

        // Update the project
        Project updatedProject = projectRepository.findOne(project.getId());
        updatedProject
            .projectCompId(UPDATED_PROJECT_COMP_ID)
            .projectCompName(UPDATED_PROJECT_COMP_NAME)
            .projectBame(UPDATED_PROJECT_BAME)
            .projectDesc(UPDATED_PROJECT_DESC)
            .projectStatus(UPDATED_PROJECT_STATUS)
            .supervisorCompId(UPDATED_SUPERVISOR_COMP_ID)
            .supervisorCompName(UPDATED_SUPERVISOR_COMP_NAME)
            .contractorCompId(UPDATED_CONTRACTOR_COMP_ID)
            .contractorCompName(UPDATED_CONTRACTOR_COMP_NAME)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .createdBy(UPDATED_CREATED_BY)
            .createdTime(UPDATED_CREATED_TIME)
            .modifyBy(UPDATED_MODIFY_BY)
            .modifyTime(UPDATED_MODIFY_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restProjectMockMvc.perform(put("/api/projects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedProject)))
            .andExpect(status().isOk());

        // Validate the Project in the database
        List<Project> projectList = projectRepository.findAll();
        assertThat(projectList).hasSize(databaseSizeBeforeUpdate);
        Project testProject = projectList.get(projectList.size() - 1);
        assertThat(testProject.getProjectCompId()).isEqualTo(UPDATED_PROJECT_COMP_ID);
        assertThat(testProject.getProjectCompName()).isEqualTo(UPDATED_PROJECT_COMP_NAME);
        assertThat(testProject.getProjectBame()).isEqualTo(UPDATED_PROJECT_BAME);
        assertThat(testProject.getProjectDesc()).isEqualTo(UPDATED_PROJECT_DESC);
        assertThat(testProject.getProjectStatus()).isEqualTo(UPDATED_PROJECT_STATUS);
        assertThat(testProject.getSupervisorCompId()).isEqualTo(UPDATED_SUPERVISOR_COMP_ID);
        assertThat(testProject.getSupervisorCompName()).isEqualTo(UPDATED_SUPERVISOR_COMP_NAME);
        assertThat(testProject.getContractorCompId()).isEqualTo(UPDATED_CONTRACTOR_COMP_ID);
        assertThat(testProject.getContractorCompName()).isEqualTo(UPDATED_CONTRACTOR_COMP_NAME);
        assertThat(testProject.getStartDate()).isEqualTo(UPDATED_START_DATE);
        assertThat(testProject.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testProject.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testProject.getCreatedTime()).isEqualTo(UPDATED_CREATED_TIME);
        assertThat(testProject.getModifyBy()).isEqualTo(UPDATED_MODIFY_BY);
        assertThat(testProject.getModifyTime()).isEqualTo(UPDATED_MODIFY_TIME);
        assertThat(testProject.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testProject.getRemark()).isEqualTo(UPDATED_REMARK);

        // Validate the Project in Elasticsearch
        Project projectEs = projectSearchRepository.findOne(testProject.getId());
        assertThat(projectEs).isEqualToComparingFieldByField(testProject);
    }

    @Test
    @Transactional
    public void updateNonExistingProject() throws Exception {
        int databaseSizeBeforeUpdate = projectRepository.findAll().size();

        // Create the Project

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restProjectMockMvc.perform(put("/api/projects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(project)))
            .andExpect(status().isCreated());

        // Validate the Project in the database
        List<Project> projectList = projectRepository.findAll();
        assertThat(projectList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteProject() throws Exception {
        // Initialize the database
        projectRepository.saveAndFlush(project);
        projectSearchRepository.save(project);
        int databaseSizeBeforeDelete = projectRepository.findAll().size();

        // Get the project
        restProjectMockMvc.perform(delete("/api/projects/{id}", project.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean projectExistsInEs = projectSearchRepository.exists(project.getId());
        assertThat(projectExistsInEs).isFalse();

        // Validate the database is empty
        List<Project> projectList = projectRepository.findAll();
        assertThat(projectList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchProject() throws Exception {
        // Initialize the database
        projectRepository.saveAndFlush(project);
        projectSearchRepository.save(project);

        // Search the project
        restProjectMockMvc.perform(get("/api/_search/projects?query=id:" + project.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(project.getId().intValue())))
            .andExpect(jsonPath("$.[*].projectCompId").value(hasItem(DEFAULT_PROJECT_COMP_ID.toString())))
            .andExpect(jsonPath("$.[*].projectCompName").value(hasItem(DEFAULT_PROJECT_COMP_NAME.toString())))
            .andExpect(jsonPath("$.[*].projectBame").value(hasItem(DEFAULT_PROJECT_BAME.toString())))
            .andExpect(jsonPath("$.[*].projectDesc").value(hasItem(DEFAULT_PROJECT_DESC.toString())))
            .andExpect(jsonPath("$.[*].projectStatus").value(hasItem(DEFAULT_PROJECT_STATUS)))
            .andExpect(jsonPath("$.[*].supervisorCompId").value(hasItem(DEFAULT_SUPERVISOR_COMP_ID.intValue())))
            .andExpect(jsonPath("$.[*].supervisorCompName").value(hasItem(DEFAULT_SUPERVISOR_COMP_NAME.toString())))
            .andExpect(jsonPath("$.[*].contractorCompId").value(hasItem(DEFAULT_CONTRACTOR_COMP_ID.intValue())))
            .andExpect(jsonPath("$.[*].contractorCompName").value(hasItem(DEFAULT_CONTRACTOR_COMP_NAME.toString())))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].createdTime").value(hasItem(DEFAULT_CREATED_TIME.toString())))
            .andExpect(jsonPath("$.[*].modifyBy").value(hasItem(DEFAULT_MODIFY_BY.intValue())))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(DEFAULT_MODIFY_TIME.toString())))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Project.class);
        Project project1 = new Project();
        project1.setId(1L);
        Project project2 = new Project();
        project2.setId(project1.getId());
        assertThat(project1).isEqualTo(project2);
        project2.setId(2L);
        assertThat(project1).isNotEqualTo(project2);
        project1.setId(null);
        assertThat(project1).isNotEqualTo(project2);
    }
}
