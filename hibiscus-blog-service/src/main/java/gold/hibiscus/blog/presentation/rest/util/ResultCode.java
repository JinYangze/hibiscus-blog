package gold.hibiscus.blog.presentation.rest.util;

import lombok.Getter;

/**
 * result code
 *
 * @author Jinyang
 * @since 2023-07-04
 */
@Getter
public enum ResultCode {
    SUCCESS(200, "success"),
    SERVICE_UNKNOWN_ERROR(10000, "service error");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
