package com.classified.platform.persistance.config;

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
public @Data class JPAConfig {
	public static @Data class jdbc {
	    private String driverClassName;
	    private String url;
	    private String username;
	    private String password;
	}
}
