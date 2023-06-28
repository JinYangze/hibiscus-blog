package gold.hibiscus.blog.presentation.rest.blog;

import gold.hibiscus.blog.application.blog.ArticleService;
import gold.hibiscus.blog.presentation.rest.blog.vo.PageParams;
import gold.hibiscus.blog.presentation.rest.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@RestController
@RequestMapping("/")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("v1/articles")
    public Result<?> queryArticles(@RequestBody PageParams pageParams) {
        return articleService.queryArticles(pageParams);
    }
}
