package es.santalucia.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "es.santalucia")
@EnableJpaRepositories(basePackages = "es.santalucia.api.repository")
@EntityScan(basePackages = { "es.santalucia.api.model" }) // scan JPA entities
public class ApiApplication extends SpringBootServletInitializer {


  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(ApiApplication .class);
    }

    public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }
}


