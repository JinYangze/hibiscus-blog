package gold.hibiscus.blog.domain.blog;

import java.util.Date;

/**
 * article class, contain field of article
 *
 * @author daze
 */
public class Article {
    private Long id;
    private String title;
    private String content;
    private String author;
    private int likedCount;
    private int dislikedCount;
    private int visitedCount;
    private Date createDate;
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public int getDislikedCount() {
        return dislikedCount;
    }

    public void setDislikedCount(int dislikedCount) {
        this.dislikedCount = dislikedCount;
    }

    public int getVisitedCount() {
        return visitedCount;
    }

    public void setVisitedCount(int visitedCount) {
        this.visitedCount = visitedCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
