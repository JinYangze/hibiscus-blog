package gold.hibiscus.blog.application.user;

import gold.hibiscus.blog.domain.user.User;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-06-05
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public String getUsername(User user) {
        return user.getUsername();
    }
}
