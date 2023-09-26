package gold.hibiscus.blog.infrastructure.persistence.user;

import gold.hibiscus.blog.domain.user.User;
import gold.hibiscus.blog.domain.user.UserRepository;
import gold.hibiscus.blog.infrastructure.persistence.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User Repository Implementation.
 *
 * @author Jinyang
 * @since 2023-09-26
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper mapper;

    @Autowired
    public UserRepositoryImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User queryUser(String username, String password) {
        return mapper.queryUser(username, password);
    }
}
