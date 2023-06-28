package gold.hibiscus.blog.domain.blog;

import java.util.Date;
import java.util.List;

/**
 * article class, contain field of article
 *
 * @author daze
 */
public class article {
    private Long id;
    private String title;
    private String content;
    private List<String> tag;
    private int likedCount;
    private int dislikedCount;
    private int visitedCount;
    private Date createDate;
    private Date modifyDate;
}
