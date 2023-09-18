package gold.hibiscus.blog.presentation.rest.blog;

import gold.hibiscus.blog.application.blog.ArticleService;
import gold.hibiscus.blog.presentation.rest.blog.vo.PageRequest;
import gold.hibiscus.blog.presentation.rest.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * article controller.
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@RestController
@RequestMapping("/")
@Tag(name = "Article", description = "Blog Article API")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("v1/article/list")
    @Operation(summary = "Query Article List", parameters = {@Parameter(name = "pageRequest", description = "Page Params")})
    @ApiResponse(responseCode = "200", description = "Query article list successfully, return article list")
    public Result<?> queryArticleList(@ModelAttribute PageRequest pageRequest) {
        return articleService.queryArticleList(pageRequest);
    }

    @GetMapping("v1/article/{id}")
    @Operation(summary = "Query Article", parameters = {@Parameter(name = "id", description = "Article ID")})
    @ApiResponse(responseCode = "200", description = "Query article successfully, return article object")
    public Result<?> queryArticle(@PathVariable Long id) {
        return articleService.queryArticle(id);
    }

    @GetMapping("v1/article/hot")
    @Operation(summary = "Query Hot Articles", parameters = {@Parameter(name = "limit", description = "Limit Size")})
    @ApiResponse(responseCode = "200", description = "Query hot articles successfully, return article list")
    public Result<?> queryHotArticle(@Parameter(name = "limit") Integer limit) {
        return articleService.queryHotArticle(limit);
    }
}
