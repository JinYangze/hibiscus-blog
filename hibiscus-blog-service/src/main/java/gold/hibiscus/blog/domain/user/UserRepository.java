package gold.hibiscus.blog.domain.user;

/**
 * User Repository.
 *
 * @author Jinyang
 * @since 2023-09-26
 */
public interface UserRepository {
    boolean saveUser(User user);

    User queryUser(String username, String password);

    User queryUserByUsername(String username);
}
