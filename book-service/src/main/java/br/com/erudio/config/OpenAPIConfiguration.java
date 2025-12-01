package br.com.erudio.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Book Microservice API",
        version = "V1",
        description = "Documentation of Book Microservice API"))
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info().title("Book Microservice API").version("V1").license(new License().name("apache 2.0").url("chatgpt.com")));
    }
}
