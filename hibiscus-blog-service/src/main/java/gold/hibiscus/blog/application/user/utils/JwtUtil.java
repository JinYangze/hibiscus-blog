package gold.hibiscus.blog.application.user.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * Token Util
 *
 * @author Jinyang
 * @since 2023-09-19
 */
public class JwtUtil {
    /**
     * Token expiry date(Day).
     */
    private static final int INVALID_TIME = 1;
    /**
     * Token Secret.
     */
    private static final String SECRET = "123456Mszlu!@#$$";

    /**
     * Generate token.
     *
     * @param name key
     * @param value value
     * @return token
     */
    public static String createToken(String name, String value) {
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(name, value);
        // 设置有效期
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, INVALID_TIME);
        builder.withExpiresAt(instance.getTime());//指定令牌的过期时间
        return builder.sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * Verify the validity of the token.
     *
     * @param token token
     */
    public static DecodedJWT checkToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }
}
