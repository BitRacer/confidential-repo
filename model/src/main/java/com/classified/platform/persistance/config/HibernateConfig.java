package com.classified.platform.persistance.config;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.context.annotation.Configuration;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by aristotle on 12/27/15.
 */
//@Configuration("hibernate")
//@ConfigurationProperties( "hibernate" )
@Data
//@RefreshScope
public class HibernateConfig {

  @NotNull
  //@Value("hibernate.hbm2ddl.auto")
  private String auto;
  @NotNull
  private String dialect;
}