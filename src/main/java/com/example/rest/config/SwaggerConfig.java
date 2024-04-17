package com.example.rest.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Sistema Kanban 🥁", version = "1.0", description = "API para gestionar proyectos y tareas. Proyecto integrador del Bootcamp Makaia 🪢"))
public class SwaggerConfig {
}
