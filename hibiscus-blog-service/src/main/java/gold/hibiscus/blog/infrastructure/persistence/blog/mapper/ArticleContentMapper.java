package gold.hibiscus.blog.infrastructure.persistence.blog.mapper;

import gold.hibiscus.blog.domain.blog.ArticleContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * Article Content Mapper
 *
 * @author Jinyang
 * @since 2023-07-04
 */
@Mapper
public interface ArticleContentMapper {
        /**
        * query article content by id
        *
        * @param id article id
        * @return article content
        */
        ArticleContent queryArticleContentById(long id);
}
