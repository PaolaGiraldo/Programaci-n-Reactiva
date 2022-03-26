package com.reactivo.app;

import com.reactivo.app.data.LacteoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories

public class Practica3AppSpringReactivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Practica3AppSpringReactivoApplication.class, args);
	}

}
