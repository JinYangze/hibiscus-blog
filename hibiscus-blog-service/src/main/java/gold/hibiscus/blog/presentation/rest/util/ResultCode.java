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
    SQL_OPERATE_ERROR(10002, "Sql operate error"),
    ACCOUNT_PWD_NOT_EXIST(20000, "username not exist"),
    NO_LOGIN(20001, "The user is not logged in"),
    USER_EXIST(20002, "username exist");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
