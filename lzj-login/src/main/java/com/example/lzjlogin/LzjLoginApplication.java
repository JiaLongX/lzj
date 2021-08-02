package com.example.lzjlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LzjLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LzjLoginApplication.class, args);
    }

}
