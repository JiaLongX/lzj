package com.example.lzjeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LzjEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LzjEurekaApplication.class, args);
    }

}
