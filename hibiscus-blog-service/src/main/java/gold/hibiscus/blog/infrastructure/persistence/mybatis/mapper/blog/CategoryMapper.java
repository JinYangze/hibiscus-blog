package gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper.blog;

import gold.hibiscus.blog.domain.blog.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * Category Mapper
 *
 * @author Jinyang
 * @since 2023-07-06
 */
@Mapper
public interface CategoryMapper {
   Category queryCategoryById(Long id);
}
