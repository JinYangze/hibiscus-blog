package gold.hibiscus.blog.infrastructure.persistence.blog.mapper;

import com.github.pagehelper.Page;
import gold.hibiscus.blog.domain.blog.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Article Mapper.
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@Mapper
public interface ArticleMapper {
    Page<Article> queryArticleList();

    Article queryArticleById(Long id);

    List<Article> queryHotArticleList(Integer limit);

    List<Article> queryNewArticleList(Integer limit);
}
