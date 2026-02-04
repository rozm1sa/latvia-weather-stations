package com.weatherstations.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Latvia Weather Stations API",
        version = "1.0.0",
        description = "REST API providing information about weather stations in Latvia. " +
                     "Data is sourced from the Latvian open data portal (data.gov.lv).",
        contact = @Contact(
            name = "API Support"
        )
    ),
    servers = {
        @Server(
            description = "Local Development",
            url = "http://localhost:8080"
        )
    }
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    description = "Enter your bearer token (without 'Bearer' prefix)"
)
public class OpenAPIConfig {
}