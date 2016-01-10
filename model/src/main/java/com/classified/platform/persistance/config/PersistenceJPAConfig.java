package com.classified.platform.persistance.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.classified.platform.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = User.class)
@ComponentScan("com.classified.platform.persistance.config")
@Slf4j
public class PersistenceJPAConfig {
	
  /*
   * TODO: use jpaconfig and hibernate config values from remote config
   */
	
  @Autowired
  JPAConfig jpaConfig;
  
  @Autowired
  HibernateConfig hibernateConfig;
  
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	em.setDataSource(dataSource());
	em.setPackagesToScan("com.classified.platform.model");	 
	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	em.setJpaVendorAdapter(vendorAdapter);
	em.setJpaProperties(additionalProperties());
	log.debug("CONFIG------" + jpaConfig.toString());
	return em;
  }
	 
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(jpaConfig.getDriverClassName());
	    dataSource.setUrl(jpaConfig.getUrl());
	    dataSource.setUsername(jpaConfig.getUsername());
	    dataSource.setPassword(jpaConfig.getPassword());
	    //dataSource.setDriverClassName( "org.apache.derby.jdbc.EmbeddedDriver");
	    //dataSource.setUrl("jdbc:derby://localhost:1527/myDB;create=true;user=root;password=secret");
	    //dataSource.setUsername( "root" );
	    //dataSource.setPassword( "secret" );
	    return dataSource;
    }
	 
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
      return transactionManager;
    }
 
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
    }
	 
    Properties additionalProperties() {
      Properties properties = new Properties();
 	  //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	  //properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	  properties.setProperty("hibernate.hbm2ddl.auto", hibernateConfig.getAuto());
	  properties.setProperty("hibernate.dialect", hibernateConfig.getDialect());
	  log.debug("CONFIG------" + hibernateConfig.toString());	  
	  return properties;
	}
}
