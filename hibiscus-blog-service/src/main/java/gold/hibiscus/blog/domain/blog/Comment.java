package gold.hibiscus.blog.domain.blog;

import java.util.Date;

/**
 * the comment of article
 *
 * @author daze
 */
public class Comment {
    private long id;
    private long userId;
    private String comment;
    private long replyId;
    private long articleId;
    private Date createDate;
}
