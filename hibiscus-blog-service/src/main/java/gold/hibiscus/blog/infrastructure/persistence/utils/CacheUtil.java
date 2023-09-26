package gold.hibiscus.blog.infrastructure.persistence.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * Cache implementation
 *
 * @author YangJinyang
 * @since 2023-09-23
 */
@Component
public class CacheUtil {
    private Cache cache;

    @Value("${cache.name}")
    private String cacheName;

    private final CacheManager cacheManager;

    @Autowired
    public CacheUtil(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void set(String key, Object value) {
        initCache();
        cache.put(key, value);
    }

    public <T> T get(String key, Class<T> clazz) {
        initCache();
        return cache.get(key, clazz);
    }

    public void delete(String key) {
        initCache();
        cache.evict(key);
    }

    private void initCache() {
        if (cache == null) {
            cache = cacheManager.getCache(cacheName);
        }
    }
}
