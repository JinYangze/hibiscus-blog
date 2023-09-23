package gold.hibiscus.blog.presentation.rest.user.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Login request parameters.
 *
 * @author Jinyang
 * @since 2023-09-19
 */
@Getter
@Setter
public class LoginParam {
    private String username;

    private String password;
}
