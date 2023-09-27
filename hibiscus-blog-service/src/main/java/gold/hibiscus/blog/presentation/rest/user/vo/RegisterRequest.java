package gold.hibiscus.blog.presentation.rest.user.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Register request parameters.
 *
 * @author YangJinyang
 * @since 2023-09-25
 */
@Setter
@Getter
public class RegisterRequest {
    private String username;
    private String password;
    private String nickname;
}
