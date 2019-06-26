package com.fnmusic.base.repository;

import com.fnmusic.base.models.Result;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

public abstract class AbstractMongoObjectRepository<T extends Object> implements IMongoObjectRepository<T> {

    protected MongoTemplate mongoTemplate;
    protected Class<T> type;

    @PostConstruct
    public abstract void init();

    @Override
    public void put(T object) {
        this.mongoTemplate.save(object);
    }

    @Override
    public Result<T> getOneByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        T data = (T) mongoTemplate.findOne(query, type);
        Result<T> result = new Result<>(0,data);

        return result;
    }

    @Override
    public Result<T> getbyName(String name, int pageNumber, int pageSize) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(name));
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        List<T> list = (List<T>) mongoTemplate.find(query, type);
        Result<T> result = new Result<>(0,list,0L,pageNumber,pageSize);

        return result;
    }

    @Override
    public Result<T> getAll(int pageNumber, int pageSize) {

        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        List<T> list = (List<T>) mongoTemplate.find(query, type);
        Result<T> result = new Result<T>(0,list,0L,pageNumber,pageSize);

        return result;
    }

    @Override
    public Result<T> getByDate(Date date) {

        Query query = new Query();
        query.addCriteria(Criteria.where("sentDate").is(date));

        T data = (T) mongoTemplate.find(query, type);
        Result<T> result = new Result<>(0,data);

        return result;
    }

    @Override
    public Result<T> getByDateRange(Date lowerBound, Date upperBound, int pageNumber, int pageSize) {
        Query query = new Query();
        query.addCriteria(Criteria.where("sentDate").gt(lowerBound).lt(upperBound));
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        List<T> list = (List<T>) mongoTemplate.find(query,type);
        Result result = new Result(0,list,0L,pageNumber,pageSize);

        return result;
    }
}
