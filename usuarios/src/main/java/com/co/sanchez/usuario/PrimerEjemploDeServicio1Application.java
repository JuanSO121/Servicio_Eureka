package com.co.sanchez.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.co.sanchez.common.usuario.models.entity", "com.co.sanchez"})
@EntityScan({"com.co.sanchez.common.usuario.models.entity"})

public class PrimerEjemploDeServicio1Application {

	public static void main(String[] args) {
		SpringApplication.run(PrimerEjemploDeServicio1Application.class, args);
	}

}
