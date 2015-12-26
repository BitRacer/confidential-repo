package com.classified.platform.eureka;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by aristotle on 12/15/15.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = EurekaServerApplicationTest.class )
@WebAppConfiguration
public class EurekaServerApplicationTest {
    @Test
    public void contextLoads() {
    }

}
