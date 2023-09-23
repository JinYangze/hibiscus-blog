package gold.hibiscus.blog.infrastructure.persistence.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author Jinyang
 * @since 2023-09-21
 */
@Component
public class RedisUtil {
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisUtil(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * set value
     *
     * @param key     key
     * @param value   value
     * @param timeout timeout
     */
    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.DAYS);
    }

    /**
     * get value
     *
     * @param key key
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
