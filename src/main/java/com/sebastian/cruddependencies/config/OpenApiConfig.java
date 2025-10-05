package com.sebastian.cruddependencies.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Dependency Management API")
                        .version("1.0.0")
                        .description("API to manage software dependencies using CRUD operations. Built with Spring Boot.")
                        .contact(new Contact()
                                .name("Cesar Sebastian")
                                .email("cesarsebastian.dev@example.com")
                                .url("https://cesar-seb.netlify.app/"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local Dev")
                ));
    }

}
