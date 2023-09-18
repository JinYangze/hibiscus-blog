package gold.hibiscus.blog.application.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import gold.hibiscus.blog.domain.blog.Article;
import gold.hibiscus.blog.domain.blog.ArticleContent;
import gold.hibiscus.blog.domain.blog.Category;
import gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper.blog.ArticleContentMapper;
import gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper.blog.ArticleMapper;
import gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper.blog.CategoryMapper;
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
    private final ArticleMapper articleMapper;
    private final CategoryMapper categoryMapper;
    private final ArticleContentMapper articleContentMapper;

    @Autowired
    public ArticleService(ArticleMapper articleMapper, CategoryMapper categoryMapper, ArticleContentMapper articleContentMapper) {
        this.articleMapper = articleMapper;
        this.categoryMapper = categoryMapper;
        this.articleContentMapper = articleContentMapper;
    }

    public Result<?> queryArticleList(PageRequest pageParams) {
        PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
        try (Page<Article> articlePage = articleMapper.queryArticleList()) {
            return Result.success(new PageResponse<Article>(articlePage));
        }
    }

    public Result<?> queryArticle(Long id) {
        Article article = articleMapper.queryArticleById(id);
        ArticleContent content = articleContentMapper.queryArticleContentById(article.getContentId());
        Category category = categoryMapper.queryCategoryById(article.getCategoryId());
        return Result.success(new ArticleVo(article, content, category));
    }

    public Result<?> queryHotArticle(Integer limit) {
        List<Article> articles = articleMapper.queryHotArticleList(limit);
        return Result.success(articles);
    }
}
