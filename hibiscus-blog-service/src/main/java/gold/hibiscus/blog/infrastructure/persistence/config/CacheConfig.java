package gold.hibiscus.blog.infrastructure.persistence.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Cache configuration.
 *
 * @author YangJinyang
 * @since 2023-09-23
 */
@Configuration
public class CacheConfig {
    @Value("${cache.duration}")
    private int duration;
    @Value("${cache.name}")
    private String cacheName;
    @Value("${cache.max-size}")
    private int maxCacheSize;
    @Value("${cache.initial-size}")
    private int initialCacheSize;

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> list = new ArrayList<>();
        list.add(createCaffeineCache());
        cacheManager.setCaches(list);
        return cacheManager;
    }

    private CaffeineCache createCaffeineCache() {
        return new CaffeineCache(cacheName, Caffeine.newBuilder()
                .maximumSize(maxCacheSize)
                .initialCapacity(initialCacheSize)
                .expireAfterWrite(duration, TimeUnit.MINUTES)
                .recordStats()
                .build(),
                true);
    }
}
