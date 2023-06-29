package gold.hibiscus.blog.application.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import gold.hibiscus.blog.domain.blog.Article;
import gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper.blog.ArticleMapper;
import gold.hibiscus.blog.presentation.rest.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Article Service
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@Service
public class ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public Result<?> queryArticleList(Integer page, @RequestParam Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        try (Page<Article> articlePage = articleMapper.queryArticleList()) {
            return Result.success(articlePage);
        }
    }

    public Result<?> queryArticle(String id) {
        return null;
    }
}
