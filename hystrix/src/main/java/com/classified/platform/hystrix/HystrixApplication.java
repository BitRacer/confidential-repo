package com.classified.platform.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author aballen 12/18/15
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
@Controller
public class HystrixApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
        return application.sources( HystrixApplication.class ).web( true );
    }
    public static void main( String[] args ) {
        new SpringApplicationBuilder( HystrixApplication.class ).web( true ).run( args );
    }
    @RequestMapping ( "/" )
    public String home() {
        return "forward:/hystrix";
    }
}
