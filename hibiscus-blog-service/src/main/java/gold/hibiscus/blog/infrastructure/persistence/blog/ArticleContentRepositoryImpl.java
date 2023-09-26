package gold.hibiscus.blog.infrastructure.persistence.blog;

import gold.hibiscus.blog.domain.blog.ArticleContent;
import gold.hibiscus.blog.domain.blog.repository.ArticleContentRepository;
import gold.hibiscus.blog.infrastructure.persistence.blog.mapper.ArticleContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Article Content Repository Implementation
 *
 * @author Jinyang
 * @since 2023-09-26
 */
@Repository
public class ArticleContentRepositoryImpl implements ArticleContentRepository {
    private final ArticleContentMapper mapper;

    @Autowired
    public ArticleContentRepositoryImpl(ArticleContentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ArticleContent queryArticleContentById(long id) {
        return mapper.queryArticleContentById(id);
    }
}
