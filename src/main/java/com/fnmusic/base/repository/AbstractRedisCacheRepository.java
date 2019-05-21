package com.fnmusic.base.repository;

import com.fnmusic.base.models.RedisCacheConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Repository
public abstract class AbstractRedisCacheRepository implements IRedisCacheRepository {

    protected RedisTemplate<String, Object> abstractRedisTemplate;
    private static Logger logger = LoggerFactory.getLogger(AbstractRedisCacheRepository.class);

    @PostConstruct
    public abstract void init();

    @Override
    public Object createCache(String appName, String cacheName, long ttl) {
        RedisCacheConfig config = new RedisCacheConfig();
        config.setCacheName(appName + ":" + cacheName + ":");
        config.setTtl(ttl);
        config.setTtlEnabled(ttl > 0);

        return config;
    }

    @Override
    public void destroyCache(Object cache) {

    }

    @Override
    public void put(Object cache, String key, Object data) {
        RedisCacheConfig config = (RedisCacheConfig) cache;
        if (config != null) {
            String cacheKey = config.getCacheName() + key;
            if (config != null) {
                this.abstractRedisTemplate.opsForValue().set(cacheKey,data);
                if (config.isTtlEnabled()) {
                    this.abstractRedisTemplate.expire(cacheKey, config.getTtl(), TimeUnit.SECONDS);
                }
            }
        }
    }

    @Override
    public Object get(Object cache, String key) {

        try {
            RedisCacheConfig config = (RedisCacheConfig) cache;
            if (config != null) {
                String cacheKey = config.getCacheName() + key;
                if (config.isTtlEnabled()) {
                    this.abstractRedisTemplate.expire(cacheKey, config.getTtl(), TimeUnit.SECONDS);
                }
                return this.abstractRedisTemplate.opsForValue().get(cacheKey);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean isPresent(Object cache, String key) {
        return get(cache,key) != null;
    }

    @Override
    public boolean remove(Object cache, String key) {
        return false;
    }
}
