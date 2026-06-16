package main.java.com.example.ms_torneo.Config;

import io.swagger.v3.oar.models.OpenAPI;
import io.swagger.v3.oar.models.info.Info;
import java.beans.BeanProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customeOpenAPI(){
        return new OpenAPI()
            .info(new info()
                .title("API 2026 Temas relacion torneo")
                .version("1.0")
                .description("Documentacion de la API para el sistema relacionado con los torneos"));
}
}