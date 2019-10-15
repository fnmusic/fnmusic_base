package com.fnmusic.base.repository.impl;

import com.fnmusic.base.models.Result;
import com.fnmusic.base.repository.IMongoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public abstract class AbstractMongoRepository<T extends Object> implements IMongoRepository<T> {

    protected MongoTemplate abstractMongoTemplate;
    protected Class<T> type;

    @PostConstruct
    public abstract void init();

    @Transactional
    @Override
    public void put(T object) {
        this.abstractMongoTemplate.save(object);
    }

    @Transactional
    @Override
    public Result<T> getById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        T data = abstractMongoTemplate.findOne(query, type);
        return new Result<>(0,data);
    }

    @Transactional
    @Override
    public Result<T> getAllByUniquekey(Object key, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("userId").is(key));
        List<T> list = abstractMongoTemplate.find(query,type);
        return new Result<T>(0,list, 0L,pageNumber,pageSize);
    }

    @Transactional
    @Override
    public Result<T> getAllByUniqueKeyOrderedByDateRange(Object key, int pageNumber, int pageSize, int from, int to) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("userId").is(key).and("timeStamp").lte(from).gte(to));
        List<T> list = abstractMongoTemplate.find(query,type);
        return new Result<T>(0,list, 0L,pageNumber,pageSize);
    }

    @Override
    public Result<T> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);
        List<T> list = abstractMongoTemplate.find(query,type);
        return new Result<T>(0,list, 0L,pageNumber,pageSize);
    }

    @Transactional
    @Override
    public Result<T> getAllByDateRange(int pageNumber, int pageSize, int from, int to) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("timeStamp").lte(from).gte(to));
        List<T> list = abstractMongoTemplate.find(query,type);
        return new Result<T>(0,list, 0L,pageNumber,pageSize);
    }

    @Transactional
    @Override
    public void update(T object) {

    }

    @Transactional
    @Override
    public void removeById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        abstractMongoTemplate.remove(query,id);
    }
}
