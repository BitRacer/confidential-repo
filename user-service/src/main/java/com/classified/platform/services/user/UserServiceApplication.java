package com.classified.platform.services.user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@SpringBootApplication
	@EnableDiscoveryClient
	@Controller
	public class UserServiceApplication extends SpringBootServletInitializer {
	    @Override
	    protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
	        return application.sources( UserServiceApplication.class ).web( true );
	    }
	    public static void main( String[] args ) {
	        new SpringApplicationBuilder( UserServiceApplication.class ).web( true ).run( args );
	    }
	    @RequestMapping ( "/" )
	    public String home() {
	        return "This is the User Service";
	    }
	    @RequestMapping ( "/user" )
	    
	    public String home() {
	        return "This is the User Service";
	    }

	
	}
	