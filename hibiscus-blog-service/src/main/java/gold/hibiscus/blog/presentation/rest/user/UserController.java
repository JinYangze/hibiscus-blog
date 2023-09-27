package gold.hibiscus.blog.presentation.rest.user;

import gold.hibiscus.blog.application.user.UserService;
import gold.hibiscus.blog.presentation.rest.user.vo.LoginRequest;
import gold.hibiscus.blog.presentation.rest.user.vo.RegisterRequest;
import gold.hibiscus.blog.presentation.rest.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * User Controller.
 *
 * @author Jinyang
 * @since 2023-09-19
 */
@RestController
@RequestMapping("/")
@Tag(name = "User", description = "Blog User API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("v1/user/register")
    @Operation(summary = "User Register")
    @ApiResponse(responseCode = "200", description = "User register successfully, return user token.")
    public Result<?> register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    @PostMapping("v1/user/login")
    @Operation(summary = "User Login")
    @ApiResponse(responseCode = "200", description = "User login successfully, return user token.")
    public Result<?> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @GetMapping("v1/user/current")
    @Operation(summary = "Query Current User")
    @ApiResponse(responseCode = "200", description = "Query current user successfully, return user info.")
    public Result<?> getCurrentUser(@RequestHeader("Authorization") String token) {
        return userService.queryUserByToken(token);
    }

    @GetMapping("v1/user/logout")
    @Operation(summary = "User Logout")
    @ApiResponse(responseCode = "200", description = "User logout successfully.")
    public Result<?> logout(@RequestHeader("Authorization") String token) {
        return userService.logout(token);
    }
}
