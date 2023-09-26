package gold.hibiscus.blog.domain.blog.repository;

import com.github.pagehelper.Page;
import gold.hibiscus.blog.domain.blog.Article;

import java.util.List;

/**
 * Article Repository.
 *
 * @author Jinyang
 * @since 2023-09-26
 */
public interface ArticleRepository {
    Page<Article> queryArticleList(int pageNum, int pageSize);

    Article queryArticleById(Long id);

    List<Article> queryHotArticleList(Integer limit);

    List<Article> queryNewArticleList(Integer limit);
}
