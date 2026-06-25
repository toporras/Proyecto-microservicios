package com.example.ms_estadio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsEstadioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEstadioApplication.class, args);
    }

}