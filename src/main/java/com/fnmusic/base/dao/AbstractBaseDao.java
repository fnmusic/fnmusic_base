package com.fnmusic.base.dao;

import com.fnmusic.base.models.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Repository
public abstract class AbstractBaseDao<T extends Object> implements IBaseDao<T> {

    protected SimpleJdbcCall pspCreate,
            pspRetrieveByUniqueId,
            pspRetrieveByUniqueKey,
            pspRetrieveBySecondUniqueKey,
            pspRetrieveAllByUniqueParameter,
            pspRetrieveAll,
            pspUpdate,
            pspUpdateByUniqueKey,
            pspDelete,
            pspRetrieveByEmail,
            pspRetrieveByPhone,
            pspDeleteByEmail,
            pspDeleteByPhone;

    protected final String RETURN_VALUE = "RETURN_VALUE";
    protected final String IDENTITY = "id";
    protected final String DATA = "data";
    protected final String LIST = "list";
    protected final String NO_OF_RECORDS = "no_of_records";
    protected final String STATUS = "status";

    private final Logger logger = LoggerFactory.getLogger(AbstractBaseDao.class);

    @PostConstruct
    public abstract void init();

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> create(T object) {
        if (pspCreate == null) {
            throw new IllegalStateException("pspCreate cannot be null");
        }

        SqlParameterSource in = new BeanPropertySqlParameterSource(object);
        Map<String,Object> m = pspCreate.execute(in);

        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0;
        Result<T> result = new Result(resultCode,id);

        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> retrieveByUniqueId(long id) {
        if (pspRetrieveByUniqueId == null) {
            throw new IllegalStateException("pspRetrieveByUniqueId cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource().addValue("id",id);
        Map<String, Object> m = pspRetrieveByUniqueId.execute(in);

        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long noOfRecords = m.containsKey(NO_OF_RECORDS) ? (Long) m.get(NO_OF_RECORDS) : 0;
        List<T> list = m.containsKey(DATA) ? (List<T>) m.get(DATA) : null;

        Result<T> result = new Result<>();
        result.setIdentityValue(id);
        result.setData(!list.isEmpty() ? list.get(0) : null);
        result.setResultCode(resultCode);
        result.setNoOfRecords(noOfRecords);

        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> retrieveByUniqueKey(String key) {
        if (pspRetrieveByUniqueKey == null) {
            throw new IllegalStateException("pspRetrieveByUniqueKey cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource().addValue("key",key);
        Map<String,Object> m = pspRetrieveByUniqueKey.execute(in);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long noOfRecords = m.containsKey(NO_OF_RECORDS) ? (Long) m.get(NO_OF_RECORDS) : 0;
        List<T> list = m.containsKey(DATA) ? (List<T>) m.get(DATA) : null;

        Result<T> result = new Result<>();
        result.setIdentityValue(id);
        result.setData(!list.isEmpty() ? list.get(0) : null);
        result.setResultCode(resultCode);
        result.setNoOfRecords(noOfRecords);

        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> retrieveBySecondUniqueKey(String key) {
        if (pspRetrieveBySecondUniqueKey == null) {
            throw new IllegalStateException("pspRetrieveSecondByUniqueKey cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource().addValue("key",key);
        Map<String,Object> m = pspRetrieveBySecondUniqueKey.execute(in);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long noOfRecords = m.containsKey(NO_OF_RECORDS) ? (Long) m.get(NO_OF_RECORDS) : 0;
        List<T> list = m.containsKey(DATA) ? (List<T>) m.get(DATA) : null;
        
        Result<T> result = new Result<>(resultCode);
        result.setIdentityValue(id);
        result.setData(!list.isEmpty() ? list.get(0) : null);
        result.setResultCode(resultCode);
        result.setNoOfRecords(noOfRecords);

        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> retrieveAllByUniqueParameter(String key, int pageNumber, int pageSize) {
        if (pspRetrieveAllByUniqueParameter == null) {
            throw new IllegalStateException("pspRetrieveAllByUniqueParameter cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("key",key)
                .addValue("pageNumber",pageNumber)
                .addValue("pageSize",pageSize)
                .addValue("no_of_records",null);
        Map<String,Object> m = pspRetrieveAllByUniqueParameter.execute(in);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long noOfRecords = m.containsKey(NO_OF_RECORDS) ? (Long) m.get(NO_OF_RECORDS) : 0;
        List<T> list = m.containsKey(LIST) ? (List<T>) m.get(LIST) : null;

        Result<T> result = new Result(resultCode,list,noOfRecords,pageNumber,pageSize);
        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> retrieveAll(int pageNumber, int pageSize) {
        if (pspRetrieveAll == null) {
            throw new IllegalStateException("pspRetrieveAll cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("pageNumber",pageNumber)
                .addValue("pageSize",pageSize)
                .addValue("no_of_records",null);
        Map<String,Object> m = pspRetrieveAll.execute(in);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long noOfRecords = m.containsKey(NO_OF_RECORDS) ? (Long) m.get(NO_OF_RECORDS) : 0;
        List<T> list = m.containsKey(LIST) ? (List<T>) m.get(LIST) : null;

        Result<T> result = new Result(resultCode,list,noOfRecords,pageNumber,pageSize);
        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> update(T object) {
        if (pspUpdate == null) {
            throw new IllegalStateException("pspUpdate cannot be null");
        }

        SqlParameterSource in = new BeanPropertySqlParameterSource(object);
        Map<String,Object> m = pspUpdate.execute(in);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        Result<T> result = new Result(resultCode,id);
        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> updateByUniqueKey(String key, String value) {
        if (pspUpdateByUniqueKey == null) {
            throw new IllegalStateException("pspUpdateByUniqueKey cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("key",key)
                .addValue("value",value);
        Map<String,Object> m = pspUpdateByUniqueKey.execute(in);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        Result<T> result = new Result(resultCode,id);
        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> deleteByUniqueId(long id) {
        if (pspDelete == null) {
            throw new IllegalStateException("pspDelete cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource().addValue("id",id);
        Map<String,Object> m = pspDelete.execute(in);

        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : null;
        Result<T> result = new Result(resultCode);
        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> retrieveByEmail(String email) {
        if (pspRetrieveByEmail == null) {
            throw new IllegalStateException("pspRetrieveByEmail cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource().addValue("email",email);
        Map<String,Object> m = pspRetrieveByEmail.execute(email);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long noOfRecords = m.containsKey(NO_OF_RECORDS) ? (Long) m.get(NO_OF_RECORDS) : 0;
        List<T> list = m.containsKey(DATA) ? (List<T>) m.get(DATA) : null;

        Result<T> result = new Result<>();
        result.setIdentityValue(id);
        result.setData(!list.isEmpty() ? list.get(0) : null);
        result.setResultCode(resultCode);
        result.setNoOfRecords(noOfRecords);

        return result;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Result<T> retrieveByPhone(String phone) {
        if (pspRetrieveByPhone == null) {
            throw new IllegalStateException("pspRetrieveByPhone cannot be null");
        }

        SqlParameterSource in = new MapSqlParameterSource().addValue("phone",phone);
        Map<String,Object> m = pspRetrieveByPhone.execute(phone);

        long id = m.containsKey(IDENTITY) ? (long) m.get(IDENTITY) : 0L;
        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : 0;
        long noOfRecords = m.containsKey(NO_OF_RECORDS) ? (Long) m.get(NO_OF_RECORDS) : 0;
        List<T> list = m.containsKey(DATA) ? (List<T>) m.get(DATA) : null;

        Result<T> result = new Result<>();
        result.setIdentityValue(id);
        result.setData(!list.isEmpty() ? list.get(0) : null);
        result.setResultCode(resultCode);
        result.setNoOfRecords(noOfRecords);

        return result;
    }

    @Transactional
    @Override
    public Result<T> deleteByEmail(String email) {
        if (pspDeleteByEmail == null) {
            throw new IllegalStateException("pspDeleteByEmail cannot be empty");
        }

        SqlParameterSource in = new MapSqlParameterSource("email",email);
        Map<String,Object> m = pspDelete.execute(in);

        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : null;
        Result<T> result = new Result(resultCode);
        return result;
    }

    @Override
    public Result<T> deleteByPhone(String phone) {
        if (pspDeleteByPhone == null) {
            throw new IllegalStateException("pspDeleteByPhone cannot be empty");
        }

        SqlParameterSource in = new MapSqlParameterSource("phone",phone);
        Map<String,Object> m = pspDelete.execute(in);

        int resultCode = m.containsValue(RETURN_VALUE) ? (Integer) m.get(RETURN_VALUE) : null;
        Result<T> result = new Result(resultCode);
        return result;
    }
}
