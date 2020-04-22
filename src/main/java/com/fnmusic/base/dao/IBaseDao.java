package com.fnmusic.base.dao;

import com.fnmusic.base.models.Result;

public interface IBaseDao<T> {

    Result<T> create(T object);

    Result<T> retrieveByUniqueId(long id);

    Result<T> retrieveByUniqueKey(String key);

    Result<T> retrieveBySecondUniqueKey(String key);

    Result<T> retrieveByThirdUniqueKey(String key);

    Result<T> retrieveAllByUniqueParameter(String key, int pageNumber, int pageSize);

    Result<T> retrieveAll(int pageNumber, int pageSize);

    Result<T> update(T object);

    Result<T> updateByUniqueKey(String key, String value);

    Result<T> deleteByUniqueId(long id);

    Result<T> retrieveByEmail(String email);

    Result<T> retrieveByPhone(String phone);

    Result<T> deleteByEmail(String email);

    Result<T> deleteByPhone(String phone);

}
