package com.fnmusic.base.utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface IMarshaller<T, A extends Object> {

    public A marshall(Object data) throws JsonProcessingException;

    public T unmarshall(String data, Class<?> classType) throws IOException;
}
