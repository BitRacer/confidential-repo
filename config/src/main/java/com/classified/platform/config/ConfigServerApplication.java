package com.classified.platform.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by aristotle.allen on 12/12/15.
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {
        public static void main( String[] args ) {
                SpringApplication.run( ConfigServerApplication.class, args );

        }
}

