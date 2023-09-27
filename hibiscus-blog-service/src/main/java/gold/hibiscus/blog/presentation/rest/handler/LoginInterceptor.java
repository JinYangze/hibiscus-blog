package gold.hibiscus.blog.presentation.rest.handler;

import com.google.gson.Gson;
import gold.hibiscus.blog.application.user.UserService;
import gold.hibiscus.blog.presentation.rest.user.vo.UserResponse;
import gold.hibiscus.blog.presentation.rest.util.Result;
import gold.hibiscus.blog.presentation.rest.util.ResultCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Login interceptor.
 *
 * @author Jinyang
 * @since 2023-09-27
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final UserService userService;

    @Autowired
    public LoginInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader("Authorization");
        log.info("=================request start===========================");
        String requestUri = request.getRequestURI();
        log.info("request uri:{}", requestUri);
        log.info("request method:{}", request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        // Authorization parameter is null.
        if (token == null) {
            Result<?> result = Result.failure(ResultCode.NO_LOGIN);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(new Gson().toJson(result));
            return false;
        }

        // User is no login.
        UserResponse user = (UserResponse) userService.queryUserByToken(token).getData();
        if (user == null) {
            Result<?> result = Result.failure(ResultCode.NO_LOGIN);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(new Gson().toJson(result));
            return false;
        }
        return true;
    }
}
