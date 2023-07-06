package gold.hibiscus.blog.presentation.rest.util;

import lombok.Getter;

/**
 * api response structure
 *
 * @author Jinyang
 * @since 2023-06-20
 */
@Getter
public class Result<T> {
    private final T data;
    private final int code;
    private final String message;

    public Result(int code, String message, T data) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> failure(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), null);
    }
}
