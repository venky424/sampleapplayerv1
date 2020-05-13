package de.summer.sampleapplayerv1.config;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customopeOpenAPI (@Value("${application.name}") String appName, @Value("${application.version}") String appVersion){
        return new OpenAPI()
                .info(new Info().title("Sample App Layer V1")
                        .version(appVersion)
                        .description(appName)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
