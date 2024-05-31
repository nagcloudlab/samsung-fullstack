package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MySQLDataSourceConfiguration {

    // @Bean
    // public DataSource dataSource() {
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://localhost:3306/bankdb");
    // dataSource.setUsername("root");
    // dataSource.setPassword("root1234");
    // return dataSource;
    // }

}