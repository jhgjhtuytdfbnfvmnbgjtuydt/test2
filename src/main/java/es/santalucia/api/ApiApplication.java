package es.santalucia.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableConfigurationProperties
// @EntityScan(basePackages = { "es.santalucia.api.model" }) // scan JPA entities
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

