package io.github.ilyalisov.springbootuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUserServiceApplication.class, args);
    }

}
