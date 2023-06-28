package gold.hibiscus.blog.presentation.rest.util;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-06-20
 */
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

    public static <T> Result<T> failure(int code, String message) {
        return new Result<>(code, message, null);
    }
}
