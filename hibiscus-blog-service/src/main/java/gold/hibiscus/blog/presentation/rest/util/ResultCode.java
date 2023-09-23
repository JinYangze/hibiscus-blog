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
    SERVICE_UNKNOWN_ERROR(10000, "service error"),
    PARAMS_ERROR(10001, "params error"),
    ACCOUNT_PWD_NOT_EXIST(10002, "username not exist"),
    NO_LOGIN(10003, "The user is not logged in");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
