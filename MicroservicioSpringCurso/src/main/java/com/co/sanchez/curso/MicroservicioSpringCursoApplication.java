package com.co.sanchez.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//com.co.sanchez.common.usuario.models.entity
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.co.sanchez.common.usuario.models.entity", "com.co.sanchez.curso.models.entity", "com.co.sanchez"})
@EnableJpaRepositories({"com.co.sanchez.common.usuario.repository", "com.co.sanchez.curso.repository"})
@EntityScan({"com.co.sanchez.curso.models.entity", "com.co.sanchez.common.usuario.models.entity"})

public class MicroservicioSpringCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioSpringCursoApplication.class, args);
	}

}
