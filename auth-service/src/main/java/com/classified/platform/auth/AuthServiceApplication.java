package com.classified.platform.auth;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by aballen on 12/18/15.
 */
@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@EnableDiscoveryClient
@RestController
@Slf4j
public class AuthServiceApplication {

    public static void main( String[] args ) {

        SpringApplication.run( AuthServiceApplication.class, args );

    }

    @RequestMapping("/user")
    public Principal user( Principal user ) {
    	log.debug( "user : user=" + user );
    	
    	return user;
    }

}