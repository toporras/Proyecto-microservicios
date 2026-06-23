package com.example.ms_arbitro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsArbitroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsArbitroApplication.class, args);
	}

}
