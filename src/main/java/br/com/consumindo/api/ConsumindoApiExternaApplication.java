package br.com.consumindo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API Para consumo da viacep",
			version = "1.0",
			description = "Documentando uma API para consumo da api pública viacep",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class ConsumindoApiExternaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumindoApiExternaApplication.class, args);
	}

}
