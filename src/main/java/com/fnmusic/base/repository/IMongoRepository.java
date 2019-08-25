package com.fnmusic.base.repository;

import com.fnmusic.base.models.Result;

import java.util.Date;

public interface IMongoRepository<T> {

    public void put(T object);

    public Result<T> getOneByUniqueKey(String key);

    public Result<T> getAllByUniqueKey(String key, int pageNumber, int pageSize);

    public Result<T> getAll(int pageNumber, int pageSize);

    public Result<T> getDateRangeByUniqueKey(String key, int pageNumber, int pageSize, Date from, Date to);

    public Result<T> getAllByDateRange(int pageNumber, int pageSize, Date from, Date to);

    public void remove(String key);

    public void clear(String key);


}
