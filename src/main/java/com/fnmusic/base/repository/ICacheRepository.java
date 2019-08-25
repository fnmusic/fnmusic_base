package com.fnmusic.base.repository;

public interface ICacheRepository {

    Object createCache(String appName, String cacheName, long ttl);
    void destroyCache(Object cache);
    void put(Object cache, String key, Object data);
    Object get(Object cache, String key);
    boolean isPresent(Object cache, String key);
    boolean remove(Object cache, String key);
    boolean clear(Object cache, String key);

}