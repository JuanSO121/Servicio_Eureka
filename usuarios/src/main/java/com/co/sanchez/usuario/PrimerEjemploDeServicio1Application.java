package com.co.sanchez.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PrimerEjemploDeServicio1Application {

	public static void main(String[] args) {
		SpringApplication.run(PrimerEjemploDeServicio1Application.class, args);
	}

}
