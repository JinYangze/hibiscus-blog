package gold.hibiscus.blog.infrastructure.persistence.blog;

import gold.hibiscus.blog.domain.blog.Category;
import gold.hibiscus.blog.domain.blog.repository.CategoryRepository;
import gold.hibiscus.blog.infrastructure.persistence.blog.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Category Repository Implementation.
 *
 * @author Jinyang
 * @since 2023-09-26
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryMapper mapper;

    @Autowired
    public CategoryRepositoryImpl(CategoryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Category queryCategoryById(Long id) {
        return mapper.queryCategoryById(id);
    }
}
