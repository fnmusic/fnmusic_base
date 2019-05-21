package com.fnmusic.base.dao;

import com.fnmusic.base.models.Result;

public interface IBaseDao<T> {

    public Result<T> create(T object);

    public Result<T> retrieveByUniqueId(long id);

    public Result<T> retrieveByUniqueKey(String key);

    public Result<T> retrieveBySecondUniqueKey(String key);

    public Result<T> retrieveAllByUniqueParameter(String key, int pageNumber, int pageSize);

    public Result<T> retrieveAll(int pageNumber, int pageSize);

    public Result<T> update(T object);

    public Result<T> deleteByUniqueKey(String key);
}
