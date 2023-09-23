package gold.hibiscus.blog.infrastructure.persistence.mybatis.mapper.user;

import gold.hibiscus.blog.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * User Mapper.
 *
 * @author Jinyang
 * @since 2023-09-21
 */
@Mapper
public interface UserMapper {
    User queryUser(String username, String password);
}
