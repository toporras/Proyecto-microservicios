package com.example.ms_entrenador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsEntrenadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEntrenadorApplication.class, args);
    }
}
