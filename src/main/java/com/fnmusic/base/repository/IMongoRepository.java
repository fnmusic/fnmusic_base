package com.fnmusic.base.repository;

import com.fnmusic.base.models.Result;

public interface IMongoRepository<T> {

    void put(T object);

    Result<T> getById(String id);

    Result<T> getAllByUniquekey(Object key, int pageNumber, int pageSize);

    Result<T> getAllByUniqueKeyOrderedByDateRange(Object key, int pageNumber, int pageSize, int from, int to);

    Result<T> getAll(int pageNumber, int pageSize);

    Result<T> getAllByDateRange(int pageNumber, int pageSize, int from, int to);

    void update(T object);

    void removeById(String id);

}
