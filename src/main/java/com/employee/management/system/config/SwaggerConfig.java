package com.employee.management.system.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig() {
        return new OpenAPI().
                info(
                new Info().title("Employee Management System API").version("1.0").description("By Saad"))
                .servers(List.of(new Server().url("http://localhost:8080").description("local")));
    }
}
