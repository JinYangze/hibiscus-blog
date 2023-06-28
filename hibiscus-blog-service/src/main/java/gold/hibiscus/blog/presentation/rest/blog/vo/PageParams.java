package gold.hibiscus.blog.presentation.rest.blog.vo;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-06-20
 */
public class PageParams {
    private int page = 1;
    private int pageSize = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
