package com.example.aivlemini7springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class AivleMini7SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AivleMini7SpringbootApplication.class, args);
    }

}
