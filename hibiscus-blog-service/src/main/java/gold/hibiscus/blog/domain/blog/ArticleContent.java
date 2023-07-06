package gold.hibiscus.blog.domain.blog;

import lombok.Getter;
import lombok.Setter;

/**
 * article content
 *
 * @author Jinyang
 * @since 2023-07-04
 */
@Getter
@Setter
public class ArticleContent {
    private long  id;
    private String content;
    private String htmlContent;
}
