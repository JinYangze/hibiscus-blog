package gold.hibiscus.blog.domain.blog;

import lombok.Getter;
import lombok.Setter;

/**
 * Category
 *
 * @author Jinyang
 * @since 2023-07-06
 */
@Getter
@Setter
public class Category {
    private Long id;
    private String name;
    private String description;
}
