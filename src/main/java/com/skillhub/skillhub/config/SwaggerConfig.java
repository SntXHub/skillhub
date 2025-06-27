package com.skillhub.skillhub.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI skillHubOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SkillHub API")
                        .description("API RESTful para la gestión de usuarios y autenticación JWT en SkillHub.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Santiago Cabrera")
                                .url("https://github.com/sntxhub")
                                .email("sntxhub@example.com"))
                        .license(new License()
                                .name("Licencia educativa")
                                .url("https://opensource.org/licenses")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio del proyecto")
                        .url("https://github.com/sntxhub/skillhub-backend"));
    }
}
