package gold.hibiscus.blog.presentation.rest.handler;

import gold.hibiscus.blog.presentation.rest.util.Result;
import gold.hibiscus.blog.presentation.rest.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * blog global exception handler
 *
 * @author Jinyang
 * @since 2023-07-04
 */
@RestControllerAdvice
public class BlogExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(BlogExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception ex) {
        logger.error("blog exception: {}", ex.getMessage());
        return Result.failure(ResultCode.SERVICE_UNKNOWN_ERROR);
    }
}
