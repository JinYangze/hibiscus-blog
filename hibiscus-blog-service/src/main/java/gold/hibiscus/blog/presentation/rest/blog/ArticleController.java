package gold.hibiscus.blog.presentation.rest.blog;

import gold.hibiscus.blog.application.blog.ArticleService;
import gold.hibiscus.blog.presentation.rest.util.Result;
import org.springframework.web.bind.annotation.*;

/**
 * article controller
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

    @GetMapping("v1/article/list")
    public Result<?> queryArticleList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer pageSize) {
        return articleService.queryArticleList(page, pageSize);
    }

    @GetMapping("v1/article/{id}")
    public Result<?> queryArticle(@PathVariable String id) {
        return articleService.queryArticle(id);
    }
}
