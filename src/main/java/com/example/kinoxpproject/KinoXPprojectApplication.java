package com.example.kinoxpproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KinoXPprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinoXPprojectApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(); // smid repo ind her

}
