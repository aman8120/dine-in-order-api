package com.example.dio.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class AppDoc {

    @Bean
    OpenAPI getOpenAPI() {
        return new OpenAPI().info(info());
    }

    private Info info() {
        return new Info()
                .title("Dine In Order API")
                .description("""
                        ## Discription:
                        **Dine In Order** is an API built using spring boot under REST Architecture.
                        The API is designed to serve as a backend to application that deals in ordering food online.
                        ---
                        
                        ## Tech-Stack
                        - Java 8
                        - Spring Boot
                        - Spring Data JPA
                        - MySQL Database 
                        - Spring Security
                        """).version("v1").contact(contact());
    }

    private Contact contact() {
        return new Contact().email("amannagle2000@gmail.com")
                .name("Aman")
                .url("https://google.com");
    }


}
