package gold.hibiscus.blog.domain.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户
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

    public Map<String, String> toUserMap() {
        Map<String, String> map = new HashMap<>(3);
        map.put("id", String.valueOf(id));
        map.put("username", username);
        map.put("password", password);
        return map;
    }
}
