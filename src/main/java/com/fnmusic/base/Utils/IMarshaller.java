package com.fnmusic.base.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface IMarshaller<T> {

    public String marshall(Object data) throws JsonProcessingException;

    public T unmarshall(String data, Class<?> classType) throws IOException;
}
