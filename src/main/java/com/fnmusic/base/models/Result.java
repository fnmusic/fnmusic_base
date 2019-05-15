package com.fnmusic.base.models;

import java.util.List;

public class Result<T> {

    private List<T> list;
    private T data;
    private Integer resultCode;
    private Long identityValue;
    private Long noOfRecords;
    private int PageNumber;
    private Integer PageSize;

    public Result() {
    }

    public Result(Integer resultCode, List<T> list, Long noOfRecords, Integer pageNumber, Integer pageSize) {
        this.list = list;
        this.resultCode = resultCode;
        this.noOfRecords = noOfRecords;
        this.PageNumber = pageNumber;
        this.PageSize = pageSize;
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
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }
}
