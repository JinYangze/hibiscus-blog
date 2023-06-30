package gold.hibiscus.blog.presentation.rest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger Document Config
 *
 * @author Jinyang
 * @since 2023-06-30
 */
@Configuration
public class SpringDocConfig {
    private static final String API_VERSION = "v0.0.1";
    private static final String API_TITLE = "Hibiscus Blog API";
    private static final String API_DESCRIPTION = "RESTful API Documentation for Blogging System";

    @Bean
    public OpenAPI restfulOpenApi() {
        return new OpenAPI().info(new Info().title(API_TITLE).description(API_DESCRIPTION).version(API_VERSION));
    }
}
