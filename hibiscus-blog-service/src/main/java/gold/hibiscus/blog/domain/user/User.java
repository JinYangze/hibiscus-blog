package gold.hibiscus.blog.domain.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * User.
 *
 * @author Jinyang
 * @since 2023-06-05
 */
@Setter
@Getter
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String nickname;
}
