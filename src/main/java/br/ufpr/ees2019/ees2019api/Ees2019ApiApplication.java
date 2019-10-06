package br.ufpr.ees2019.ees2019api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
	"br.ufpr.ees2019.ees2019api.repository",
	"br.ufpr.ees2019.ees2019api.service",
	"br.ufpr.ees2019.ees2019api.converter"
})
public class Ees2019ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ees2019ApiApplication.class, args);
	}

}
