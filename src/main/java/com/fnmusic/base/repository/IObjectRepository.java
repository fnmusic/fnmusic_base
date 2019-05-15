package com.fnmusic.base.repository;

import com.fnmusic.base.models.Result;

import java.util.Date;

public interface IObjectRepository<T> {

    public void put(T object);

    public Result<T> getOneByName(String name);

    public Result<T> getbyName(String name, int pageNumber, int pageSize);

    public Result<T> getAll(int pageNumber, int pageSize);

    public Result<T> getByDate(Date date);

    public Result<T> getByDateRange(Date lowerBound, Date upperBound, int pageNumber, int pageSize);


}
