package gold.hibiscus.blog.application.user;

import com.auth0.jwt.exceptions.JWTVerificationException;
import gold.hibiscus.blog.application.user.utils.JwtUtil;
import gold.hibiscus.blog.domain.user.User;
import gold.hibiscus.blog.domain.user.UserRepository;
import gold.hibiscus.blog.infrastructure.persistence.utils.CacheUtil;
import gold.hibiscus.blog.presentation.rest.user.vo.LoginParam;
import gold.hibiscus.blog.presentation.rest.user.vo.UserResponse;
import gold.hibiscus.blog.presentation.rest.util.Result;
import gold.hibiscus.blog.presentation.rest.util.ResultCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * User Service.
 *
 * @author Jinyang
 * @since 2023-06-05
 */
@Service
public class UserService {
    private static final String SALT = "mszlu!@#";

    private final CacheUtil cacheUtil;

    private final UserRepository userRepository;

    @Autowired
    public UserService(CacheUtil cacheUtil, UserRepository userRepository) {
        this.cacheUtil = cacheUtil;
        this.userRepository = userRepository;
    }

    public Result<?> login(LoginParam loginParam) {
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return Result.failure(ResultCode.PARAMS_ERROR);
        }
        User user = userRepository.queryUser(username, DigestUtils.md5Hex(password + SALT));
        if (user == null) {
            return Result.failure(ResultCode.ACCOUNT_PWD_NOT_EXIST);
        }
        // Login is successful, token is generated, and saved in redis
        String token = JwtUtil.createToken("id", String.valueOf(user.getId()));
        cacheUtil.set(token, user);
        return Result.success(token);
    }

    public Result<?> queryUserByToken(String token) {
        try {
            JwtUtil.checkToken(token);
        } catch (JWTVerificationException ex) {
            return Result.failure(ResultCode.NO_LOGIN);
        }
        User user = cacheUtil.get(token, User.class);
        if (user == null) {
            return Result.failure(ResultCode.NO_LOGIN);
        }
        return Result.success(new UserResponse(user));
    }

    public Result<?> logout(String token) {
        cacheUtil.delete(token);
        return Result.success(null);
    }
}
