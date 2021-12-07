package com.przychodniamk2.config;

import com.przychodniamk2.database.MockDatabase;
import com.przychodniamk2.systemControl.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public Database database(){
        //return new SpringMySQLDatabase();
        return new MockDatabase();
    }
}
