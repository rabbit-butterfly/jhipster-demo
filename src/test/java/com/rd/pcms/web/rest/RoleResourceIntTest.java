package com.rd.pcms.web.rest;

import com.Application;
import com.jumore.zhxf.web.rest.TestUtil;

import com.jumore.zhxf.web.rest.errors.ExceptionTranslator;
import com.rd.pcms.domain.Role;
import com.rd.pcms.repository.RoleRepository;
import com.rd.pcms.service.RoleService;
import com.rd.pcms.service.dto.RoleDTO;
import com.rd.pcms.service.mapper.RoleMapper;

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
 * Test class for the RoleResource REST controller.
 *
 * @see RoleResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RoleResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LEVEL = 0;
    private static final Integer UPDATED_LEVEL = 1;

    private static final Long DEFAULT_PARENT_ID = 0L;
    private static final Long UPDATED_PARENT_ID = 1L;

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_LAST_MODIFIED_BY = "AAAAAAAAAA";
    private static final String UPDATED_LAST_MODIFIED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_LAST_MODIFIED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_MODIFIED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRoleMockMvc;

    private Role role;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RoleResource roleResource = new RoleResource(roleService);
        this.restRoleMockMvc = MockMvcBuilders.standaloneSetup(roleResource)
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
    public static Role createEntity(EntityManager em) {
        Role role = new Role()
            .name(DEFAULT_NAME)
            .code(DEFAULT_CODE)
            .level(DEFAULT_LEVEL)
            .parentId(DEFAULT_PARENT_ID)
            .createdBy(DEFAULT_CREATED_BY)
            .createdDate(DEFAULT_CREATED_DATE)
            .lastModifiedBy(DEFAULT_LAST_MODIFIED_BY)
            .lastModifiedDate(DEFAULT_LAST_MODIFIED_DATE);
        // Add required entity
        Role children = RoleResourceIntTest.createEntity(em);
        em.persist(children);
        em.flush();
        role.getChildren().add(children);
        return role;
    }

    @Before
    public void initTest() {
        role = createEntity(em);
    }

    @Test
    @Transactional
    public void createRole() throws Exception {
        int databaseSizeBeforeCreate = roleRepository.findAll().size();

        // Create the Role
        RoleDTO roleDTO = roleMapper.toDto(role);
        restRoleMockMvc.perform(post("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isCreated());

        // Validate the Role in the database
        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeCreate + 1);
        Role testRole = roleList.get(roleList.size() - 1);
        assertThat(testRole.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testRole.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testRole.getLevel()).isEqualTo(DEFAULT_LEVEL);
        assertThat(testRole.getParentId()).isEqualTo(DEFAULT_PARENT_ID);
        assertThat(testRole.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testRole.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testRole.getLastModifiedBy()).isEqualTo(DEFAULT_LAST_MODIFIED_BY);
        assertThat(testRole.getLastModifiedDate()).isEqualTo(DEFAULT_LAST_MODIFIED_DATE);
    }

    @Test
    @Transactional
    public void createRoleWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = roleRepository.findAll().size();

        // Create the Role with an existing ID
        role.setId(1L);
        RoleDTO roleDTO = roleMapper.toDto(role);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRoleMockMvc.perform(post("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = roleRepository.findAll().size();
        // set the field null
        role.setName(null);

        // Create the Role, which fails.
        RoleDTO roleDTO = roleMapper.toDto(role);

        restRoleMockMvc.perform(post("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isBadRequest());

        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = roleRepository.findAll().size();
        // set the field null
        role.setCode(null);

        // Create the Role, which fails.
        RoleDTO roleDTO = roleMapper.toDto(role);

        restRoleMockMvc.perform(post("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isBadRequest());

        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLevelIsRequired() throws Exception {
        int databaseSizeBeforeTest = roleRepository.findAll().size();
        // set the field null
        role.setLevel(null);

        // Create the Role, which fails.
        RoleDTO roleDTO = roleMapper.toDto(role);

        restRoleMockMvc.perform(post("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isBadRequest());

        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkParentIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = roleRepository.findAll().size();
        // set the field null
        role.setParentId(null);

        // Create the Role, which fails.
        RoleDTO roleDTO = roleMapper.toDto(role);

        restRoleMockMvc.perform(post("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isBadRequest());

        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreatedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = roleRepository.findAll().size();
        // set the field null
        role.setCreatedDate(null);

        // Create the Role, which fails.
        RoleDTO roleDTO = roleMapper.toDto(role);

        restRoleMockMvc.perform(post("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isBadRequest());

        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllRoles() throws Exception {
        // Initialize the database
        roleRepository.saveAndFlush(role);

        // Get all the roleList
        restRoleMockMvc.perform(get("/api/roles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(role.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
            .andExpect(jsonPath("$.[*].level").value(hasItem(DEFAULT_LEVEL)))
            .andExpect(jsonPath("$.[*].parentId").value(hasItem(DEFAULT_PARENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(DEFAULT_CREATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedBy").value(hasItem(DEFAULT_LAST_MODIFIED_BY.toString())))
            .andExpect(jsonPath("$.[*].lastModifiedDate").value(hasItem(DEFAULT_LAST_MODIFIED_DATE.toString())));
    }

    @Test
    @Transactional
    public void getRole() throws Exception {
        // Initialize the database
        roleRepository.saveAndFlush(role);

        // Get the role
        restRoleMockMvc.perform(get("/api/roles/{id}", role.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(role.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.level").value(DEFAULT_LEVEL))
            .andExpect(jsonPath("$.parentId").value(DEFAULT_PARENT_ID.intValue()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdDate").value(DEFAULT_CREATED_DATE.toString()))
            .andExpect(jsonPath("$.lastModifiedBy").value(DEFAULT_LAST_MODIFIED_BY.toString()))
            .andExpect(jsonPath("$.lastModifiedDate").value(DEFAULT_LAST_MODIFIED_DATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRole() throws Exception {
        // Get the role
        restRoleMockMvc.perform(get("/api/roles/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRole() throws Exception {
        // Initialize the database
        roleRepository.saveAndFlush(role);
        int databaseSizeBeforeUpdate = roleRepository.findAll().size();

        // Update the role
        Role updatedRole = roleRepository.findOne(role.getId());
        updatedRole
            .name(UPDATED_NAME)
            .code(UPDATED_CODE)
            .level(UPDATED_LEVEL)
            .parentId(UPDATED_PARENT_ID)
            .createdBy(UPDATED_CREATED_BY)
            .createdDate(UPDATED_CREATED_DATE)
            .lastModifiedBy(UPDATED_LAST_MODIFIED_BY)
            .lastModifiedDate(UPDATED_LAST_MODIFIED_DATE);
        RoleDTO roleDTO = roleMapper.toDto(updatedRole);

        restRoleMockMvc.perform(put("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isOk());

        // Validate the Role in the database
        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeUpdate);
        Role testRole = roleList.get(roleList.size() - 1);
        assertThat(testRole.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testRole.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testRole.getLevel()).isEqualTo(UPDATED_LEVEL);
        assertThat(testRole.getParentId()).isEqualTo(UPDATED_PARENT_ID);
        assertThat(testRole.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testRole.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testRole.getLastModifiedBy()).isEqualTo(UPDATED_LAST_MODIFIED_BY);
        assertThat(testRole.getLastModifiedDate()).isEqualTo(UPDATED_LAST_MODIFIED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingRole() throws Exception {
        int databaseSizeBeforeUpdate = roleRepository.findAll().size();

        // Create the Role
        RoleDTO roleDTO = roleMapper.toDto(role);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRoleMockMvc.perform(put("/api/roles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(roleDTO)))
            .andExpect(status().isCreated());

        // Validate the Role in the database
        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRole() throws Exception {
        // Initialize the database
        roleRepository.saveAndFlush(role);
        int databaseSizeBeforeDelete = roleRepository.findAll().size();

        // Get the role
        restRoleMockMvc.perform(delete("/api/roles/{id}", role.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Role.class);
        Role role1 = new Role();
        role1.setId(1L);
        Role role2 = new Role();
        role2.setId(role1.getId());
        assertThat(role1).isEqualTo(role2);
        role2.setId(2L);
        assertThat(role1).isNotEqualTo(role2);
        role1.setId(null);
        assertThat(role1).isNotEqualTo(role2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RoleDTO.class);
        RoleDTO roleDTO1 = new RoleDTO();
        roleDTO1.setId(1L);
        RoleDTO roleDTO2 = new RoleDTO();
        assertThat(roleDTO1).isNotEqualTo(roleDTO2);
        roleDTO2.setId(roleDTO1.getId());
        assertThat(roleDTO1).isEqualTo(roleDTO2);
        roleDTO2.setId(2L);
        assertThat(roleDTO1).isNotEqualTo(roleDTO2);
        roleDTO1.setId(null);
        assertThat(roleDTO1).isNotEqualTo(roleDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(roleMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(roleMapper.fromId(null)).isNull();
    }
}
