package com.IRC.IRC_Main_server.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configurable
public class EntityManager {
	//I've got my data source defined in application.yml config file, 
	//so there is no need to configure it from java.
	@Autowired
	private DataSource dataSource;

	@Bean
	public EntityManagerFactory entityManagerFactory() {
	    //JpaVendorAdapteradapter can be autowired as well if it's configured in application properties.
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(false);
	    
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    //Add package to scan for entities.
	    factory.setPackagesToScan("com.*");
	    factory.setDataSource(dataSource);
	    return (EntityManagerFactory) factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory);
	    return txManager;
	}
}
