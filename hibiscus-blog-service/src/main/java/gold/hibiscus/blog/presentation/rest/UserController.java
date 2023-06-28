package gold.hibiscus.blog.presentation.rest;

import gold.hibiscus.blog.application.user.UserService;
import gold.hibiscus.blog.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-06-05
 */
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/test")
    public String getUser(@RequestBody User user) {
        return userService.getUsername(user);
    }
}
