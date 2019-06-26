package com.fnmusic.base.models;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public enum Role implements Serializable {

    @Value("USER")
    USER,
    @Value("ADMIN")
    ADMIN,
    @Value("SUPER_ADMIN")
    SUPER_ADMIN
}
