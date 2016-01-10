package com.classified.platform.persistance.config;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.context.annotation.Configuration;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by aristotle on 12/27/15.
 */
@Component
@Configuration
@ConfigurationProperties("hibernate")
@RefreshScope
public @Data class HibernateConfig {
    @Value("hbm2ddl.auto")
	private String auto;
	private String dialect;
}