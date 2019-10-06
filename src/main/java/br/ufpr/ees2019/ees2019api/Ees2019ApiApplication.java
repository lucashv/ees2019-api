package br.ufpr.ees2019.ees2019api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Ees2019ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ees2019ApiApplication.class, args);
	}

}
