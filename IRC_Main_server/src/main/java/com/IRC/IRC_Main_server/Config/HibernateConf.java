package com.IRC.IRC_Main_server.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class HibernateConf {

	
	

	    @Bean
	    DataSource dataSource(Environment env) {
	        HikariConfig dataSourceConfig = new HikariConfig();
	        dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
	        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
	        dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
	        dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
	 
	        return new HikariDataSource(dataSourceConfig);
	    }

}
