package com.example.ms_arbitro.Config;

import io.swagger.v3.oar.models.OpenAPI;
import io.swagger.v3.oar.models.info.Info;
import java.beans.BeanProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customeOpenAPI(){
            info(new info()
                .title("API 2026 Temas en relacion con el arbitro")
                .version("1.0")
                .description("Documentacion de la API para el sistema relacionado con los arbitros"));
}
}
