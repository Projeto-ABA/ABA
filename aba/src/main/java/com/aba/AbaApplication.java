package com.aba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableWebMvc
public class AbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbaApplication.class, args);
		printURLs();
	}

	public static void printURLs() {
		String margem = System.lineSeparator() + System.lineSeparator();
		String swagger = "SWAGGER UI URL: http://localhost:8080/swagger-ui/#/";
		String conteudo = String.format("%s============================" +
		"%s%s%s" +
		"============================%s", margem, margem, swagger, margem, margem);

		log.info(conteudo);
	}

}
