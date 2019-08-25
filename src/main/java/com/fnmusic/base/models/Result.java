package com.fnmusic.base.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("List")
    private List<T> list;
    @JsonProperty("Data")
    private T data;
    @JsonProperty("ResultCode")
    private Integer resultCode;
    @JsonProperty("IdentityValue")
    private Long identityValue;
    @JsonProperty("NoOfRecords")
    private Long noOfRecords;
    @JsonProperty("PageNumber")
    private int pageNumber;
    @JsonProperty("PageSize")
    private int pageSize;

    public Result() {
    }

    public Result(Integer resultCode, List<T> list, Long noOfRecords, int pageNumber, int pageSize) {
        this.list = list;
        this.resultCode = resultCode;
        this.noOfRecords = noOfRecords;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Result(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Result(Integer resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public Result(Integer resultCode, Long identityValue) {
        this.resultCode = resultCode;
        this.identityValue = identityValue;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Long getIdentityValue() {
        return identityValue;
    }

    public void setIdentityValue(Long identityValue) {
        this.identityValue = identityValue;
    }

    public Long getNoOfRecords() {
        return noOfRecords;
    }

    public void setNoOfRecords(Long noOfRecords) {
        this.noOfRecords = noOfRecords;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
