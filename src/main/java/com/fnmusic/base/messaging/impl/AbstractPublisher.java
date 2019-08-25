package com.fnmusic.base.messaging.impl;

import com.fnmusic.base.messaging.IPublisher;
import com.fnmusic.base.utils.JsonMarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public abstract class AbstractPublisher<T extends Object> implements IPublisher<T> {

    protected RabbitTemplate abstractRabbitTemplate;
    private JsonMarshaller marshaller = new JsonMarshaller();
    private static Logger logger = LoggerFactory.getLogger(AbstractPublisher.class);

    @PostConstruct
    public abstract void init();

    @Override
    public void publish(T object) {

        try {
            String value = marshaller.marshall(object);
            abstractRabbitTemplate.convertAndSend(value);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
