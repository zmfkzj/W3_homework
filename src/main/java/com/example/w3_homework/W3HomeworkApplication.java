package com.example.w3_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class W3HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(W3HomeworkApplication.class, args);
    }

}
