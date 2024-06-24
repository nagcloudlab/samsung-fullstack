package com.example;

import com.example.repository.BoyRepository;
import com.example.repository.JpaManualRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class JpaLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLearningApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(JpaManualRepository jpaRepository, BoyRepository boyRepository) {
        return args -> {

            //jpaRepository.findAll();
            //jpaRepository.findById(1);
            //jpaRepository.findByName("John Doe");

            boyRepository.findAll().forEach(b-> System.out.println(b.getName()));

        };
    }


}


// in how many ways we can select data from database using JPA

// 1. find() method if we know the primary key
// 2. JPQL (Java Persistence Query Language) - select e from Employee e where e.name = 'John Doe'
// 3. Criteria API - CriteriaBuilder, CriteriaQuery, Root - if we want to build query dynamically
// 4. Native SQL - if we want to use database specific queries
// 5. Named Queries - if we want to use the same query multiple times

