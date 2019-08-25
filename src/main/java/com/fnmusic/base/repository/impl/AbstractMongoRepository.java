package com.fnmusic.base.repository.impl;

import com.fnmusic.base.models.Result;
import com.fnmusic.base.repository.IMongoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Repository
public abstract class AbstractMongoRepository<T extends Object> implements IMongoRepository<T> {

    protected MongoTemplate abstractMongoTemplate;
    protected Class<T> type;

    @PostConstruct
    public abstract void init();

    @Override
    public void put(T object) {
        this.abstractMongoTemplate.save(object);
    }

    @Override
    public Result<T> getOneByUniqueKey(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(key));

        T data = abstractMongoTemplate.findOne(query, type);
        return new Result<>(0,data);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Result<T> getAllByUniqueKey(String key, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("userId").is(key));

        List<T> list = abstractMongoTemplate.find(query, type);
        return new Result(0,list,(long) list.size(),pageNumber,pageSize);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Result<T> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);

        List<T> list = abstractMongoTemplate.find(query, type);
        return new Result(0,list,(long) list.size(),pageNumber,pageSize);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Result<T> getDateRangeByUniqueKey(String key, int pageNumber, int pageSize, Date from, Date to) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("userId").is(key).and("timeStamp").gte(from.getTime()).lte(to.getTime()));

        List<T> list = abstractMongoTemplate.find(query,type);
        return new Result(0,list,(long) list.size(),pageNumber,pageSize);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Result<T> getAllByDateRange(int pageNumber, int pageSize, Date from, Date to) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("timeStamp").gte(to.getTime()).lte(to.getTime()));

        List<T> list = (List<T>) abstractMongoTemplate.find(query,type);
        return new Result(0,list,(long) list.size(),pageNumber,pageSize);
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void clear(String key) {

    }
}
