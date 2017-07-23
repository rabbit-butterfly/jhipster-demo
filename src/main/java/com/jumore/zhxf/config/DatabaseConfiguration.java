package com.jumore.zhxf.config;

import java.sql.SQLException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import liquibase.integration.spring.SpringLiquibase;
import com.jumore.zhxf.config.liquibase.AsyncSpringLiquibase;

@Configuration
@EnableJpaRepositories("com.*.*.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
@EnableElasticsearchRepositories("com.*.*.repository.search")
@EntityScan(value={"com.jumore.zhxf.domain","com.rd.pcms.domain"})
public class DatabaseConfiguration {

	private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

	@Inject
	private Environment env;

	@Autowired(required = false)
	private MetricRegistry metricRegistry;

	@Bean(destroyMethod = "close")
	@ConditionalOnExpression("#{!environment.acceptsProfiles('cloud') && !environment.acceptsProfiles('heroku')}")
	public DataSource dataSource(DataSourceProperties dataSourceProperties, JHipsterProperties jHipsterProperties,
			CacheManager cacheManager) {
		log.debug("Configuring Datasource");
		if (dataSourceProperties.getUrl() == null) {
			log.error(
					"Your database connection pool configuration is incorrect! The application"
							+ " cannot start. Please check your Spring profile, current profiles are: {}",
					Arrays.toString(env.getActiveProfiles()));

			throw new ApplicationContextException("Database connection pool is not configured correctly");
		}
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName(dataSourceProperties.getDriverClassName());
		config.addDataSourceProperty("url", dataSourceProperties.getUrl());
		if (dataSourceProperties.getUsername() != null) {
			config.addDataSourceProperty("user", dataSourceProperties.getUsername());
		} else {
			config.addDataSourceProperty("user", ""); // HikariCP doesn't allow
														// null user
		}
		if (dataSourceProperties.getPassword() != null) {
			config.addDataSourceProperty("password", dataSourceProperties.getPassword());
		} else {
			config.addDataSourceProperty("password", ""); // HikariCP doesn't
															// allow null
															// password
		}

		// MySQL optimizations, see
		// https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration
		if ("com.mysql.jdbc.jdbc2.optional.MysqlDataSource".equals(dataSourceProperties.getDriverClassName())) {
			config.addDataSourceProperty("cachePrepStmts", jHipsterProperties.getDatasource().isCachePrepStmts());
			config.addDataSourceProperty("prepStmtCacheSize",
					jHipsterProperties.getDatasource().getPrepStmtCacheSize());
			config.addDataSourceProperty("prepStmtCacheSqlLimit",
					jHipsterProperties.getDatasource().getPrepStmtCacheSqlLimit());
		}
		if (metricRegistry != null) {
			config.setMetricRegistry(metricRegistry);
		}
		return new HikariDataSource(config);
	}

	/**
	 * Open the TCP port for the H2 database, so it is available remotely.
	 */
	@Bean(initMethod = "start", destroyMethod = "stop")
	@Profile(Constants.SPRING_PROFILE_DEVELOPMENT)
	public Server h2TCPServer() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers");
	}

	@Bean
	public SpringLiquibase liquibase(DataSource dataSource, DataSourceProperties dataSourceProperties,
			LiquibaseProperties liquibaseProperties) {

		SpringLiquibase liquibase = new AsyncSpringLiquibase();
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog("classpath:config/liquibase/master.xml");
		liquibase.setContexts(liquibaseProperties.getContexts());
		liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
		liquibase.setDropFirst(liquibaseProperties.isDropFirst());
		if (env.acceptsProfiles("no-liquibase")) {
			liquibase.setShouldRun(false);
		} else {
			liquibase.setShouldRun(liquibaseProperties.isEnabled());
			log.debug("Configuring Liquibase");
		}

		return liquibase;
	}

	@Bean
	public Hibernate4Module hibernate4Module() {
		return new Hibernate4Module();
	}
}
