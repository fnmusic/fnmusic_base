package com.fnmusic.base.messaging.impl;

import com.fnmusic.base.messaging.IListener;
import com.fnmusic.base.utils.JsonMarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public abstract class AbstractListener<T extends Object> implements IListener {

    protected Class<T> type;

    @SuppressWarnings("unchecked")
    private JsonMarshaller<T> marshaller = new JsonMarshaller();
    private static Logger logger = LoggerFactory.getLogger(AbstractListener.class);

    @PostConstruct
    public abstract void init();

    @Override
    public void onListen(Object message) {

        try {
            String data = (String) message;
            T object = marshaller.unmarshall(data,type);
            handleMessage(object);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public abstract void handleMessage(T Object);

}
