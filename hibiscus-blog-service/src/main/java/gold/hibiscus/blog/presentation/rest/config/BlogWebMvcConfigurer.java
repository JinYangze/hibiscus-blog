package gold.hibiscus.blog.presentation.rest.config;

import gold.hibiscus.blog.presentation.rest.handler.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigure
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@Configuration
public class BlogWebMvcConfigurer implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    public BlogWebMvcConfigurer(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域配置
        registry.addMapping("/**").allowedOriginPatterns("http://localhost:8080");
    }

    /**
     * Add login interceptor list.
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/v1/article/list");
    }
}
