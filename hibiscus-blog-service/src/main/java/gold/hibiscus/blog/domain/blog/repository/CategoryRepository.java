package gold.hibiscus.blog.domain.blog.repository;

import gold.hibiscus.blog.domain.blog.Category;

/**
 * Category Repository.
 *
 * @author Jinyang
 * @since 2023-09-26
 */
public interface CategoryRepository {
    Category queryCategoryById(Long id);
}
