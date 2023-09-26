package gold.hibiscus.blog.domain.blog.repository;

import gold.hibiscus.blog.domain.blog.ArticleContent;

/**
 * Article Content Repository.
 *
 * @author Jinyang
 * @since 2023-09-26
 */
public interface ArticleContentRepository {
    /**
     * query article content by id
     *
     * @param id article id
     * @return article content
     */
    ArticleContent queryArticleContentById(long id);
}
