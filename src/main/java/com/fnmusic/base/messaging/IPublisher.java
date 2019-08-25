package com.fnmusic.base.messaging;

import org.springframework.stereotype.Service;

@Service
public interface IPublisher<T> {

    public void publish(T object);
}
