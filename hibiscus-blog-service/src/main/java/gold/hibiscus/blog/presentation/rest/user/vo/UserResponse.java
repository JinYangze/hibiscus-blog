package gold.hibiscus.blog.presentation.rest.user.vo;

import gold.hibiscus.blog.domain.user.User;
import lombok.Getter;

/**
 * Query current user request response.
 *
 * @author Jinyang
 * @since 2023-09-23
 */
@Getter
public class UserResponse {
    private final long id;
    private final String username;
    private final String nickname;

    public UserResponse(User user) {
        id = user.getId();
        username = user.getUsername();
        nickname = user.getNickname();
    }
}
