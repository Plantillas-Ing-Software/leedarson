package com.leedarson.platform.ucodigoestudiante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Si729pc2ucodigoestudianteApplication
 *
 * @summary
 * The main class of the Leedarson Platform application.
 * It is responsible for starting the Spring Boot application.
 * It also enables JPA auditing.
 *
 * @since 1.0
 */
@EnableJpaAuditing
@SpringBootApplication
public class Si729pc2ucodigoestudianteApplication {

    public static void main(String[] args) {
        SpringApplication.run(Si729pc2ucodigoestudianteApplication.class, args);
    }

}
