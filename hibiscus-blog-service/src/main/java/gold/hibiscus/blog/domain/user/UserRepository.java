package gold.hibiscus.blog.domain.user;

/**
 * User Repository.
 *
 * @author Jinyang
 * @since 2023-09-26
 */
public interface UserRepository {
    User queryUser(String username, String password);
}
