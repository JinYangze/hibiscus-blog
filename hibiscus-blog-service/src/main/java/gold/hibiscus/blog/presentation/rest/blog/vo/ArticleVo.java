package gold.hibiscus.blog.presentation.rest.blog.vo;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import gold.hibiscus.blog.domain.blog.Article;
import gold.hibiscus.blog.domain.blog.ArticleContent;
import gold.hibiscus.blog.domain.blog.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * article vo
 *
 * @author Jinyang
 * @since 2023-07-04
 */
@Setter
@Getter
public class ArticleVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String title;
    private ArticleContent content;
    private long authorId;
    private int commentCount;
    /**
     * number of people who liked this article.
     */
    private int diggCount;
    /**
     * number of people who viewed this article.
     */
    private int viewCount;
    private Category category;

    private Date createDate;
    private Date updateDate;

    public ArticleVo(Article article, ArticleContent content, Category category) {
        BeanUtil.copyProperties(article, this);
        this.content = content;
        this.category = category;
    }
}
