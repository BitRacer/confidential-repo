package com.classified.platform.persistance.config;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.context.annotation.Configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by aristotle on 12/27/15.
 */
@Component
//@Configuration
@ConfigurationProperties
@RefreshScope
public @Data class HibernateConfig {
	public static @Data class hibernate {
	    private String dialect;
	    public static @Data class hbm2ddl {
	    	private String auto;
	    }
	}
}