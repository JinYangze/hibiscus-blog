package gold.hibiscus.blog.domain.blog;

import gold.hibiscus.blog.domain.util.SnowFlakeGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * article class, contain field of article
 *
 * @author daze
 */
@Getter
@Setter
public class Article {
    private Long id;
    private String title;
    private String summary;
    private long contentId;
    private long authorId;
    private long categoryId;
    private int commentCount;

    /**
     * number of people who liked this article.
     */
    private int diggCount;
    /**
     * number of people who viewed this article.
     */
    private int viewCount;
    /**
     * whether this article is on top.
     * 0: not on top, 1: on top.
     */
    private int isPinned;
    private Date createDate;
    private Date updateDate;

    private void setId(Long id) {
        if (id == null) {
            this.id = SnowFlakeGenerator.nextId();
            return;
        }
        this.id = id;
    }
}
