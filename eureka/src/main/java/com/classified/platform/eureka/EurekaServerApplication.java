package com.classified.platform.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by aristotle.allen on 8/28/15.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

  public static void main( String[] args ) {
    SpringApplication.run(EurekaServerApplication.class, args);

  }

}
