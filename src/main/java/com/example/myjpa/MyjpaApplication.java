package com.example.myjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyjpaApplication.class, args);
    }
}
