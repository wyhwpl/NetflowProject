package com.netflow;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 汪培林
 * @data 2020-12-23  13:37:41
 */
@SpringBootApplication
public class AuthorityApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(AuthorityApplication.class);

//        app.setBannerMode(Banner.Mode.OFF);

        app.run(args);

    }
}
