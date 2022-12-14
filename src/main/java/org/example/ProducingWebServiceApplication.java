package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.example.*")
@EntityScan("org.example.*")
@SpringBootApplication
public class ProducingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducingWebServiceApplication.class, args);
    }
}
