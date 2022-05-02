package com.cs6083.nanoneck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAsync
@SpringBootApplication
public class NanoNeckApplication {

    public static void main(String[] args) {
        SpringApplication.run(NanoNeckApplication.class, args);
    }

}
