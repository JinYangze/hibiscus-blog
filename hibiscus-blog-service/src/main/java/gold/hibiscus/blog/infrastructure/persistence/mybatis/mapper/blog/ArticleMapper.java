package gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper.blog;

import com.github.pagehelper.Page;
import gold.hibiscus.blog.domain.blog.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * Article Mapper
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@Mapper
public interface ArticleMapper {
    Page<Article> queryArticleList();

    Article queryArticleById(Long id);
}
