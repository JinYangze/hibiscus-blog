package gold.hibiscus.blog.infrastructure.persistence.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import gold.hibiscus.blog.domain.blog.Article;
import gold.hibiscus.blog.domain.blog.repository.ArticleRepository;
import gold.hibiscus.blog.infrastructure.persistence.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Article Repository Implementation
 *
 * @author Jinyang
 * @since 2023-09-26
 */
@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleRepositoryImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public Page<Article> queryArticleList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        try (Page<Article> articlePage = articleMapper.queryArticleList()) {
            return articlePage;
        }
    }

    @Override
    public Article queryArticleById(Long id) {
        return articleMapper.queryArticleById(id);
    }

    @Override
    public List<Article> queryHotArticleList(Integer limit) {
        return articleMapper.queryHotArticleList(limit);
    }

    @Override
    public List<Article> queryNewArticleList(Integer limit) {
        return articleMapper.queryNewArticleList(limit);
    }
}
