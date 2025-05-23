package com.tanaka.tanaka;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Inventario Otaku API",
                version = "1.0",
                description = "API para gestionar el inventario de productos de Maestro Tanaka"
        )
)
public class TanakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TanakaApplication.class, args);
    }
}
