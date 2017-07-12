package com.jumore.zhxf.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * Standalone Redis configuration
 *
 * @author Raysmond<i@raysmond.com>
 */
@Configuration
@EnableCaching
@AutoConfigureAfter(value = { MetricsConfiguration.class, DatabaseConfiguration.class })
public class RedisConfiguration {

	@Autowired
	private RedisProperties redisProperties;

	public static final int DEFAULT_EXPIRE_TIME = 3600 * 24;

	@Bean
    JedisConnectionFactory jedisConnectionFactory() {
		if(StringUtils.isEmpty(redisProperties.getHost())){
			JedisConnectionFactory factory = new JedisConnectionFactory(new RedisClusterConfiguration(redisProperties.getCluster().getNodes()));
			/** 如果需要定制连接池,可以使用下面的方式进行配置 */  
			//        	    private JedisPoolConfig pool = new JedisPoolConfig();  
			//        	    pool.setMaxIdle(8)  
			//        	    pool.setMaxTotal(8)  
			//        	    pool.set...  
			//        	    factory.setPoolConfig(pool)  
			return factory;         	
		}  
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisProperties.getHost());
        factory.setPort(redisProperties.getPort());
        factory.setPassword(redisProperties.getPassword());
        factory.setUsePool(true);
        return factory;
    }

	@Bean
	RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	@Bean(name = "redisListTemplate")
	public RedisTemplate<String, Long> redisListTemplate() {
		RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Long.class));
		return redisTemplate;
	}

	@Bean(name = "redisCountingTemplate")
	RedisTemplate<String, Integer> redisCountingTemplate() {
		RedisTemplate<String, Integer> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericToStringSerializer<>(Long.class));
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
		cacheManager.setDefaultExpiration(DEFAULT_EXPIRE_TIME);
		return cacheManager;
	}

}