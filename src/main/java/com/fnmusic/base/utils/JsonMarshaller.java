package com.fnmusic.base.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonMarshaller<T extends Object> implements IMarshaller<T, String> {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(JsonMarshaller.class);

    @Override
    public String marshall(Object data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T unmarshall(String data, Class<?> classType) throws IOException {
        return (T) objectMapper.readValue(data,classType);
    }
}