package com.jumore.zhxf.web.rest;

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
import com.jumore.zhxf.domain.Member;
import com.jumore.zhxf.repository.MemberRepository;
import com.jumore.zhxf.repository.search.MemberSearchRepository;
import com.jumore.zhxf.service.dto.MemberDTO;
import com.jumore.zhxf.service.mapper.MemberMapper;

/**
 * Test class for the MemberResource REST controller.
 *
 * @see MemberResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MemberResourceIntTest {

    private static final String DEFAULT_WX_NO = "AAAAAAAAAA";
    private static final String UPDATED_WX_NO = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ALIAS = "AAAAAAAAAA";
    private static final String UPDATED_ALIAS = "BBBBBBBBBB";

    private static final String DEFAULT_PERSION_MOBILE = "AAAAAAAAAA";
    private static final String UPDATED_PERSION_MOBILE = "BBBBBBBBBB";

    private static final Integer DEFAULT_GENDER = 1;
    private static final Integer UPDATED_GENDER = 2;

    private static final Integer DEFAULT_NATURE = 1;
    private static final Integer UPDATED_NATURE = 2;

    private static final String DEFAULT_PROVINCE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PROVINCE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CITY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CITY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_AREA_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AREA_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    @Inject
    private MemberRepository memberRepository;

    @Inject
    private MemberMapper memberMapper;

    @Inject
    private MemberSearchRepository memberSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    private EntityManager em;

    private MockMvc restMemberMockMvc;

    private Member member;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        MemberResource memberResource = new MemberResource();
        ReflectionTestUtils.setField(memberResource, "memberSearchRepository", memberSearchRepository);
        ReflectionTestUtils.setField(memberResource, "memberRepository", memberRepository);
        ReflectionTestUtils.setField(memberResource, "memberMapper", memberMapper);
        this.restMemberMockMvc = MockMvcBuilders.standaloneSetup(memberResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Member createEntity(EntityManager em) {
        Member member = new Member()
                .wxNo(DEFAULT_WX_NO)
                .personName(DEFAULT_PERSON_NAME)
                .alias(DEFAULT_ALIAS)
                .personMobile(DEFAULT_PERSION_MOBILE)
                .gender(DEFAULT_GENDER)
                .nature(DEFAULT_NATURE)
                .provinceCode(DEFAULT_PROVINCE_CODE)
                .cityCode(DEFAULT_CITY_CODE)
                .areaCode(DEFAULT_AREA_CODE)
                .address(DEFAULT_ADDRESS);
        return member;
    }

    @Before
    public void initTest() {
        memberSearchRepository.deleteAll();
        member = createEntity(em);
    }

    @Test
    @Transactional
    public void createMember() throws Exception {
        int databaseSizeBeforeCreate = memberRepository.findAll().size();

        // Create the Member
        MemberDTO memberDTO = memberMapper.memberToMemberDTO(member);

        restMemberMockMvc.perform(post("/api/members")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memberDTO)))
            .andExpect(status().isCreated());

        // Validate the Member in the database
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList).hasSize(databaseSizeBeforeCreate + 1);
        Member testMember = memberList.get(memberList.size() - 1);
        assertThat(testMember.getWxNo()).isEqualTo(DEFAULT_WX_NO);
        assertThat(testMember.getPersonName()).isEqualTo(DEFAULT_PERSON_NAME);
        assertThat(testMember.getAlias()).isEqualTo(DEFAULT_ALIAS);
        assertThat(testMember.getPersonMobile()).isEqualTo(DEFAULT_PERSION_MOBILE);
        assertThat(testMember.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testMember.getNature()).isEqualTo(DEFAULT_NATURE);
        assertThat(testMember.getProvinceCode()).isEqualTo(DEFAULT_PROVINCE_CODE);
        assertThat(testMember.getCityCode()).isEqualTo(DEFAULT_CITY_CODE);
        assertThat(testMember.getAreaCode()).isEqualTo(DEFAULT_AREA_CODE);
        assertThat(testMember.getAddress()).isEqualTo(DEFAULT_ADDRESS);

        // Validate the Member in ElasticSearch
        Member memberEs = memberSearchRepository.findOne(testMember.getId());
        assertThat(memberEs).isEqualToComparingFieldByField(testMember);
    }

    @Test
    @Transactional
    public void createMemberWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = memberRepository.findAll().size();

        // Create the Member with an existing ID
        Member existingMember = new Member();
        existingMember.setId(1L);
        MemberDTO existingMemberDTO = memberMapper.memberToMemberDTO(existingMember);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMemberMockMvc.perform(post("/api/members")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(existingMemberDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllMembers() throws Exception {
        // Initialize the database
        memberRepository.saveAndFlush(member);

        // Get all the memberList
        restMemberMockMvc.perform(get("/api/members?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(member.getId().intValue())))
            .andExpect(jsonPath("$.[*].wxNo").value(hasItem(DEFAULT_WX_NO.toString())))
            .andExpect(jsonPath("$.[*].personName").value(hasItem(DEFAULT_PERSON_NAME.toString())))
            .andExpect(jsonPath("$.[*].alias").value(hasItem(DEFAULT_ALIAS.toString())))
            .andExpect(jsonPath("$.[*].persionMobile").value(hasItem(DEFAULT_PERSION_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER)))
            .andExpect(jsonPath("$.[*].nature").value(hasItem(DEFAULT_NATURE)))
            .andExpect(jsonPath("$.[*].provinceCode").value(hasItem(DEFAULT_PROVINCE_CODE.toString())))
            .andExpect(jsonPath("$.[*].cityCode").value(hasItem(DEFAULT_CITY_CODE.toString())))
            .andExpect(jsonPath("$.[*].areaCode").value(hasItem(DEFAULT_AREA_CODE.toString())))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS.toString())));
    }

    @Test
    @Transactional
    public void getMember() throws Exception {
        // Initialize the database
        memberRepository.saveAndFlush(member);

        // Get the member
        restMemberMockMvc.perform(get("/api/members/{id}", member.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(member.getId().intValue()))
            .andExpect(jsonPath("$.wxNo").value(DEFAULT_WX_NO.toString()))
            .andExpect(jsonPath("$.personName").value(DEFAULT_PERSON_NAME.toString()))
            .andExpect(jsonPath("$.alias").value(DEFAULT_ALIAS.toString()))
            .andExpect(jsonPath("$.persionMobile").value(DEFAULT_PERSION_MOBILE.toString()))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER))
            .andExpect(jsonPath("$.nature").value(DEFAULT_NATURE))
            .andExpect(jsonPath("$.provinceCode").value(DEFAULT_PROVINCE_CODE.toString()))
            .andExpect(jsonPath("$.cityCode").value(DEFAULT_CITY_CODE.toString()))
            .andExpect(jsonPath("$.areaCode").value(DEFAULT_AREA_CODE.toString()))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingMember() throws Exception {
        // Get the member
        restMemberMockMvc.perform(get("/api/members/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMember() throws Exception {
        // Initialize the database
        memberRepository.saveAndFlush(member);
        memberSearchRepository.save(member);
        int databaseSizeBeforeUpdate = memberRepository.findAll().size();

        // Update the member
        Member updatedMember = memberRepository.findOne(member.getId());
        updatedMember
                .wxNo(UPDATED_WX_NO)
                .personName(UPDATED_PERSON_NAME)
                .alias(UPDATED_ALIAS)
                .personMobile(UPDATED_PERSION_MOBILE)
                .gender(UPDATED_GENDER)
                .nature(UPDATED_NATURE)
                .provinceCode(UPDATED_PROVINCE_CODE)
                .cityCode(UPDATED_CITY_CODE)
                .areaCode(UPDATED_AREA_CODE)
                .address(UPDATED_ADDRESS);
        MemberDTO memberDTO = memberMapper.memberToMemberDTO(updatedMember);

        restMemberMockMvc.perform(put("/api/members")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memberDTO)))
            .andExpect(status().isOk());

        // Validate the Member in the database
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList).hasSize(databaseSizeBeforeUpdate);
        Member testMember = memberList.get(memberList.size() - 1);
        assertThat(testMember.getWxNo()).isEqualTo(UPDATED_WX_NO);
        assertThat(testMember.getPersonName()).isEqualTo(UPDATED_PERSON_NAME);
        assertThat(testMember.getAlias()).isEqualTo(UPDATED_ALIAS);
        assertThat(testMember.getPersonMobile()).isEqualTo(UPDATED_PERSION_MOBILE);
        assertThat(testMember.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testMember.getNature()).isEqualTo(UPDATED_NATURE);
        assertThat(testMember.getProvinceCode()).isEqualTo(UPDATED_PROVINCE_CODE);
        assertThat(testMember.getCityCode()).isEqualTo(UPDATED_CITY_CODE);
        assertThat(testMember.getAreaCode()).isEqualTo(UPDATED_AREA_CODE);
        assertThat(testMember.getAddress()).isEqualTo(UPDATED_ADDRESS);

        // Validate the Member in ElasticSearch
        Member memberEs = memberSearchRepository.findOne(testMember.getId());
        assertThat(memberEs).isEqualToComparingFieldByField(testMember);
    }

    @Test
    @Transactional
    public void updateNonExistingMember() throws Exception {
        int databaseSizeBeforeUpdate = memberRepository.findAll().size();

        // Create the Member
        MemberDTO memberDTO = memberMapper.memberToMemberDTO(member);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restMemberMockMvc.perform(put("/api/members")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memberDTO)))
            .andExpect(status().isCreated());

        // Validate the Member in the database
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteMember() throws Exception {
        // Initialize the database
        memberRepository.saveAndFlush(member);
        memberSearchRepository.save(member);
        int databaseSizeBeforeDelete = memberRepository.findAll().size();

        // Get the member
        restMemberMockMvc.perform(delete("/api/members/{id}", member.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate ElasticSearch is empty
        boolean memberExistsInEs = memberSearchRepository.exists(member.getId());
        assertThat(memberExistsInEs).isFalse();

        // Validate the database is empty
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchMember() throws Exception {
        // Initialize the database
        memberRepository.saveAndFlush(member);
        memberSearchRepository.save(member);

        // Search the member
        restMemberMockMvc.perform(get("/api/_search/members?query=id:" + member.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(member.getId().intValue())))
            .andExpect(jsonPath("$.[*].wxNo").value(hasItem(DEFAULT_WX_NO.toString())))
            .andExpect(jsonPath("$.[*].personName").value(hasItem(DEFAULT_PERSON_NAME.toString())))
            .andExpect(jsonPath("$.[*].alias").value(hasItem(DEFAULT_ALIAS.toString())))
            .andExpect(jsonPath("$.[*].persionMobile").value(hasItem(DEFAULT_PERSION_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER)))
            .andExpect(jsonPath("$.[*].nature").value(hasItem(DEFAULT_NATURE)))
            .andExpect(jsonPath("$.[*].provinceCode").value(hasItem(DEFAULT_PROVINCE_CODE.toString())))
            .andExpect(jsonPath("$.[*].cityCode").value(hasItem(DEFAULT_CITY_CODE.toString())))
            .andExpect(jsonPath("$.[*].areaCode").value(hasItem(DEFAULT_AREA_CODE.toString())))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS.toString())));
    }
}
