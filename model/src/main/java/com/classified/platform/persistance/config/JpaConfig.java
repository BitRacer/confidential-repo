package com.classified.platform.persistance.config;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aristotle on 12/27/15.
 */

@Configuration("jdbc")
@ConfigurationProperties("jdbc")
public @Data class JpaConfig {
  @NotNull
  private String driverClassName;
  @NotNull
  private String url;
  @NotNull
  private String userName;
  @NotNull
  private String password;
}
