package gold.hibiscus.blog.infrastructure.persistence.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-06-19
 */
@Configuration
@MapperScan("gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper")
public class MybatisConfiguration {
}
