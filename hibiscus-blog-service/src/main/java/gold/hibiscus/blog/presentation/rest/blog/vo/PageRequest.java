package gold.hibiscus.blog.presentation.rest.blog.vo;

/**
 * The pagination parameter is used to query list data
 *
 * @author Jinyang
 * @since 2023-06-20
 */
public class PageRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public int getPageNum() {
        return pageNum;
    }

    /**
     * When the 'page' is empty or less than 1, set a default value of 1.
     *
     * @param pageNum current page number
     */
    public void setPageNum(Integer pageNum) {
        if (pageNum == null || pageNum < 1) {
            this.pageNum = 1;
            return;
        }
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * When the 'pageSize' is empty or less than 1, set a default value of 10.
     *
     * @param pageSize page size
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            this.pageSize = 10;
            return;
        }
        this.pageSize = pageSize;
    }
}
