package gold.hibiscus.blog.application.blog;

import com.github.pagehelper.Page;
import gold.hibiscus.blog.domain.blog.Article;
import gold.hibiscus.blog.domain.blog.ArticleContent;
import gold.hibiscus.blog.domain.blog.Category;
import gold.hibiscus.blog.domain.blog.repository.ArticleContentRepository;
import gold.hibiscus.blog.domain.blog.repository.ArticleRepository;
import gold.hibiscus.blog.domain.blog.repository.CategoryRepository;
import gold.hibiscus.blog.presentation.rest.blog.vo.ArticleVo;
import gold.hibiscus.blog.presentation.rest.blog.vo.PageRequest;
import gold.hibiscus.blog.presentation.rest.blog.vo.PageResponse;
import gold.hibiscus.blog.presentation.rest.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Article Service
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    private final CategoryRepository categoryRepository;

    private final ArticleContentRepository articleContentRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CategoryRepository categoryRepository, ArticleContentRepository articleContentRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.articleContentRepository = articleContentRepository;
    }

    public Result<?> queryArticleList(PageRequest pageParams) {
        Page<Article> articles = articleRepository.queryArticleList(pageParams.getPageNum(), pageParams.getPageSize());
        return Result.success(new PageResponse<Article>(articles));
    }

    public Result<?> queryArticle(Long id) {
        Article article = articleRepository.queryArticleById(id);
        if (article == null) {
            return Result.success(null);
        }
        ArticleContent content = articleContentRepository.queryArticleContentById(article.getContentId());
        Category category = categoryRepository.queryCategoryById(article.getCategoryId());
        return Result.success(new ArticleVo(article, content, category));
    }

    public Result<?> queryHotArticle(Integer limit) {
        List<Article> articles = articleRepository.queryHotArticleList(limit);
        return Result.success(articles);
    }

    public Result<?> queryNewArticle(Integer limit) {
        List<Article> articles = articleRepository.queryNewArticleList(limit);
        return Result.success(articles);
    }
}
