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
import com.jumore.zhxf.domain.News;
import com.jumore.zhxf.repository.NewsRepository;
import com.jumore.zhxf.repository.search.NewsSearchRepository;
import com.jumore.zhxf.service.dto.NewsDTO;
import com.jumore.zhxf.service.mapper.NewsMapper;

/**
 * Test class for the NewsResource REST controller.
 *
 * @see NewsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NewsResourceIntTest {

    private static final Long DEFAULT_CATEGORY_ID = 1L;
    private static final Long UPDATED_CATEGORY_ID = 2L;

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_PIC_PATH = "AAAAAAAAAA";
    private static final String UPDATED_PIC_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_SUMMARY = "AAAAAAAAAA";
    private static final String UPDATED_SUMMARY = "BBBBBBBBBB";

    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

    private static final String DEFAULT_CONTENT_URL = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT_URL = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_MODIFY_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_MODIFY_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Inject
    private NewsRepository newsRepository;

    @Inject
    private NewsMapper newsMapper;

    @Inject
    private NewsSearchRepository newsSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    private EntityManager em;

    private MockMvc restNewsMockMvc;

    private News news;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        NewsResource newsResource = new NewsResource();
        ReflectionTestUtils.setField(newsResource, "newsSearchRepository", newsSearchRepository);
        ReflectionTestUtils.setField(newsResource, "newsRepository", newsRepository);
        ReflectionTestUtils.setField(newsResource, "newsMapper", newsMapper);
        this.restNewsMockMvc = MockMvcBuilders.standaloneSetup(newsResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static News createEntity(EntityManager em) {
        News news = new News()
                .categoryId(DEFAULT_CATEGORY_ID)
                .title(DEFAULT_TITLE)
                .picPath(DEFAULT_PIC_PATH)
                .summary(DEFAULT_SUMMARY)
                .status(DEFAULT_STATUS)
                .contentUrl(DEFAULT_CONTENT_URL)
                .createdTime(DEFAULT_CREATE_TIME)
                .modifyTime(DEFAULT_MODIFY_TIME);
        return news;
    }

    @Before
    public void initTest() {
        newsSearchRepository.deleteAll();
        news = createEntity(em);
    }

    @Test
    @Transactional
    public void createNews() throws Exception {
        int databaseSizeBeforeCreate = newsRepository.findAll().size();

        // Create the News
        NewsDTO newsDTO = newsMapper.newsToNewsDTO(news);

        restNewsMockMvc.perform(post("/api/news")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newsDTO)))
            .andExpect(status().isCreated());

        // Validate the News in the database
        List<News> newsList = newsRepository.findAll();
        assertThat(newsList).hasSize(databaseSizeBeforeCreate + 1);
        News testNews = newsList.get(newsList.size() - 1);
        assertThat(testNews.getCategoryId()).isEqualTo(DEFAULT_CATEGORY_ID);
        assertThat(testNews.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testNews.getPicPath()).isEqualTo(DEFAULT_PIC_PATH);
        assertThat(testNews.getSummary()).isEqualTo(DEFAULT_SUMMARY);
        assertThat(testNews.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testNews.getContentUrl()).isEqualTo(DEFAULT_CONTENT_URL);
        assertThat(testNews.getCreatedTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testNews.getModifyTime()).isEqualTo(DEFAULT_MODIFY_TIME);

        // Validate the News in ElasticSearch
        News newsEs = newsSearchRepository.findOne(testNews.getId());
        assertThat(newsEs).isEqualToComparingFieldByField(testNews);
    }

    @Test
    @Transactional
    public void createNewsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = newsRepository.findAll().size();

        // Create the News with an existing ID
        News existingNews = new News();
        existingNews.setId(1L);
        NewsDTO existingNewsDTO = newsMapper.newsToNewsDTO(existingNews);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNewsMockMvc.perform(post("/api/news")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(existingNewsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<News> newsList = newsRepository.findAll();
        assertThat(newsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllNews() throws Exception {
        // Initialize the database
        newsRepository.saveAndFlush(news);

        // Get all the newsList
        restNewsMockMvc.perform(get("/api/news?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(news.getId().intValue())))
            .andExpect(jsonPath("$.[*].categoryId").value(hasItem(DEFAULT_CATEGORY_ID.intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].picPath").value(hasItem(DEFAULT_PIC_PATH.toString())))
            .andExpect(jsonPath("$.[*].summary").value(hasItem(DEFAULT_SUMMARY.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].contentUrl").value(hasItem(DEFAULT_CONTENT_URL.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(sameInstant(DEFAULT_MODIFY_TIME))));
    }

    @Test
    @Transactional
    public void getNews() throws Exception {
        // Initialize the database
        newsRepository.saveAndFlush(news);

        // Get the news
        restNewsMockMvc.perform(get("/api/news/{id}", news.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(news.getId().intValue()))
            .andExpect(jsonPath("$.categoryId").value(DEFAULT_CATEGORY_ID.intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.picPath").value(DEFAULT_PIC_PATH.toString()))
            .andExpect(jsonPath("$.summary").value(DEFAULT_SUMMARY.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.contentUrl").value(DEFAULT_CONTENT_URL.toString()))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)))
            .andExpect(jsonPath("$.modifyTime").value(sameInstant(DEFAULT_MODIFY_TIME)));
    }

    @Test
    @Transactional
    public void getNonExistingNews() throws Exception {
        // Get the news
        restNewsMockMvc.perform(get("/api/news/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNews() throws Exception {
        // Initialize the database
        newsRepository.saveAndFlush(news);
        newsSearchRepository.save(news);
        int databaseSizeBeforeUpdate = newsRepository.findAll().size();

        // Update the news
        News updatedNews = newsRepository.findOne(news.getId());
        updatedNews
                .categoryId(UPDATED_CATEGORY_ID)
                .title(UPDATED_TITLE)
                .picPath(UPDATED_PIC_PATH)
                .summary(UPDATED_SUMMARY)
                .status(UPDATED_STATUS)
                .contentUrl(UPDATED_CONTENT_URL)
                .createdTime(UPDATED_CREATE_TIME)
                .modifyTime(UPDATED_MODIFY_TIME);
        NewsDTO newsDTO = newsMapper.newsToNewsDTO(updatedNews);

        restNewsMockMvc.perform(put("/api/news")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newsDTO)))
            .andExpect(status().isOk());

        // Validate the News in the database
        List<News> newsList = newsRepository.findAll();
        assertThat(newsList).hasSize(databaseSizeBeforeUpdate);
        News testNews = newsList.get(newsList.size() - 1);
        assertThat(testNews.getCategoryId()).isEqualTo(UPDATED_CATEGORY_ID);
        assertThat(testNews.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testNews.getPicPath()).isEqualTo(UPDATED_PIC_PATH);
        assertThat(testNews.getSummary()).isEqualTo(UPDATED_SUMMARY);
        assertThat(testNews.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testNews.getContentUrl()).isEqualTo(UPDATED_CONTENT_URL);
        assertThat(testNews.getCreatedTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testNews.getModifyTime()).isEqualTo(UPDATED_MODIFY_TIME);

        // Validate the News in ElasticSearch
        News newsEs = newsSearchRepository.findOne(testNews.getId());
        assertThat(newsEs).isEqualToComparingFieldByField(testNews);
    }

    @Test
    @Transactional
    public void updateNonExistingNews() throws Exception {
        int databaseSizeBeforeUpdate = newsRepository.findAll().size();

        // Create the News
        NewsDTO newsDTO = newsMapper.newsToNewsDTO(news);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restNewsMockMvc.perform(put("/api/news")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newsDTO)))
            .andExpect(status().isCreated());

        // Validate the News in the database
        List<News> newsList = newsRepository.findAll();
        assertThat(newsList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteNews() throws Exception {
        // Initialize the database
        newsRepository.saveAndFlush(news);
        newsSearchRepository.save(news);
        int databaseSizeBeforeDelete = newsRepository.findAll().size();

        // Get the news
        restNewsMockMvc.perform(delete("/api/news/{id}", news.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate ElasticSearch is empty
        boolean newsExistsInEs = newsSearchRepository.exists(news.getId());
        assertThat(newsExistsInEs).isFalse();

        // Validate the database is empty
        List<News> newsList = newsRepository.findAll();
        assertThat(newsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchNews() throws Exception {
        // Initialize the database
        newsRepository.saveAndFlush(news);
        newsSearchRepository.save(news);

        // Search the news
        restNewsMockMvc.perform(get("/api/_search/news?query=id:" + news.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(news.getId().intValue())))
            .andExpect(jsonPath("$.[*].categoryId").value(hasItem(DEFAULT_CATEGORY_ID.intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].picPath").value(hasItem(DEFAULT_PIC_PATH.toString())))
            .andExpect(jsonPath("$.[*].summary").value(hasItem(DEFAULT_SUMMARY.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].contentUrl").value(hasItem(DEFAULT_CONTENT_URL.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].modifyTime").value(hasItem(sameInstant(DEFAULT_MODIFY_TIME))));
    }
}
