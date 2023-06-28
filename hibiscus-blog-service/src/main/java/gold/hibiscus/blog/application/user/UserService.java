package gold.hibiscus.blog.application.user;

import gold.hibiscus.blog.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-06-05
 */
@Validated
public interface UserService {
    String getUsername(@Valid User user);
}
