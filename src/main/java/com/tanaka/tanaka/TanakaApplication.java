package com.tanaka.tanaka;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Necesario para iniciar una aplicacion spring boot
@OpenAPIDefinition( //Documentacion Swagger
        info = @Info(
                title = "Inventario Tanaka",
                version = "3.0",
                description = "Gestion de inventario en tienda especializada en manga"
        )
)
public class TanakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TanakaApplication.class, args);
    }
}
