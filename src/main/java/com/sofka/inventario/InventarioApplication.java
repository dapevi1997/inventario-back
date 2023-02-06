package com.sofka.inventario;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Reactive CRUD- Inventario",
        version = "1.0.0",
        description = "Creating a reactive CRUD with Java 11 and Spring Boot 2.7.7"
))
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

}
