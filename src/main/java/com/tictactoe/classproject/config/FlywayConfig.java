package com.tictactoe.classproject.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    private final DataSource dataSource;


    @Autowired
    public FlywayConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean(initMethod = "migrate")
    public Flyway flyway(){
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migrations")
                .load();
        return flyway;
    }
}
