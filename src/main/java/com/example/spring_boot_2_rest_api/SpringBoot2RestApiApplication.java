package com.example.spring_boot_2_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBoot2RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2RestApiApplication.class, args);
    }

}
