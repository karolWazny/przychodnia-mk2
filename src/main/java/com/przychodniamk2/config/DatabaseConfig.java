package com.przychodniamk2.config;

import com.przychodniamk2.systemControl.database.SpringMySQLDatabase;
import com.przychodniamk2.systemControl.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    private SpringMySQLDatabase springMySQLDatabase;

    @Autowired
    public void setSpringMySQLDatabase(SpringMySQLDatabase springMySQLDatabase) {
        this.springMySQLDatabase = springMySQLDatabase;
    }

    @Bean
    public Database database(){
        return springMySQLDatabase;
    }
}
