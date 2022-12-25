package br.com.example.testemodelmapper.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApiDefinition() {
        var contact = new Contact()
                .name("gasfgrv")
                .email("gustavo_almeida11@hotmail.com")
                .url("https://github.com/gasfgrv");

        var license = new License()
                .name("Apache License Version 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");

        var info = new Info()
                .title("Teste Modelmapper")
                .description("Aplicação de teste para a criação de dois tipos de mapeamento de propriedades diferentes de uma mesma classe.")
                .contact(contact)
                .version("v1")
                .license(license);

        return new OpenAPI()
                .info(info);
    }

    @Bean
    public GroupedOpenApi logApi() {
        return GroupedOpenApi.builder()
                .group("api-v1")
                .packagesToScan("br.com.example.testemodelmapper.controller")
                .pathsToMatch("/**")
                .build();
    }

}
