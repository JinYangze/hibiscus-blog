package gold.hibiscus.blog.presentation.rest.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Token response.
 *
 * @author Jinyang
 * @since 2023-09-23
 */
@Setter
@Getter
@AllArgsConstructor
public class TokenResponse {
    private String token;
}
