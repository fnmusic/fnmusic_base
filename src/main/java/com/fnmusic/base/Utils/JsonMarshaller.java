package com.fnmusic.base.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonMarshaller<T extends Object> implements IMarshaller<T> {

    private ObjectMapper om;
    private static Logger logger = LoggerFactory.getLogger(JsonMarshaller.class);

    public JsonMarshaller() {
        this.om = new ObjectMapper();
    }

    @Override
    public String marshall(Object data) throws JsonProcessingException {
        return om.writeValueAsString(data);
    }

    @SuppressWarnings("unchecked")
    public T unmarshall(String data, Class<?> classType) throws IOException {
        return (T) om.readValue(data,classType);
    }
}
