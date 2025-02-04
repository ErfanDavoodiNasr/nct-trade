package com.github.ncttrade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NctTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NctTradeApplication.class, args);
    }


    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
