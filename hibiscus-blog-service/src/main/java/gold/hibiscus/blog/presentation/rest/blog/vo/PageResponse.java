package gold.hibiscus.blog.presentation.rest.blog.vo;

import com.github.pagehelper.Page;
import lombok.Getter;

import java.util.ArrayList;

/**
 * page response
 *
 * @author Jinyang
 * @since 2023-07-01
 */
@Getter
public class PageResponse<T> {
    private final int pageNum;
    private final int pageSize;
    private final long total;
    private final int pages;
    private final ArrayList<?> list;

    public PageResponse(Page<?> page) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.pages = page.getPages();
        list = page;
    }
}
