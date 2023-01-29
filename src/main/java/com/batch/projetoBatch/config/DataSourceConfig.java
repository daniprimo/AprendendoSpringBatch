package com.batch.projetoBatch.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = "classpath:/application.properties")
public class DataSourceConfig {
	
	@Value("${spring.datasource.jdbcUrl}")
    private String url;

	@Value("${spring.datasource.username}")
    private String username;
    
	@Value("${spring.datasource.password}")
    private String password;
    
//    private String poolName;
//
//    private int minumunIdle;
//
//    private int maximunPoolSize;
//
//    private Long connectionTimeout;
//
//    private Long idleTimeout;
//
//    private Long maxLifetime;
//
//    private String passwordEncrypt;
//	
	
	@Primary
	@Bean
	public DataSource mySqlData () {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		return new HikariDataSource(config);
	}
	
	
	public DataSource mongoData () {
		
		
		
		return null;
	}

}
