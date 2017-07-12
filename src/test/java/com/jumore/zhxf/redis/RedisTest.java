package com.jumore.zhxf.redis;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jumore.zhxf.Application;
import com.jumore.zhxf.service.dto.EventDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class RedisTest {

	    @Inject
	    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

	    @Inject
	    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

	    @Inject
	    private EntityManager em;

	    @Resource(name = "redisCountingTemplate")
	    private RedisAtomicLong longCounter;
	    
		
	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }



	    @Test
	    public void createCategoryWithExistingId() throws Exception {
	    }
	    
	    
		@Test // DATAREDIS-469
		public void testGetAndIncrement() {

			longCounter.set(1);
			assertEquals(1, longCounter.getAndIncrement());
			assertEquals(2, longCounter.get());
		}

	    
}
