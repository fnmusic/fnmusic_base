package com.fnmusic.base.models;

import org.springframework.beans.factory.annotation.Value;

public enum Role {

    @Value("user")
    USER,
    @Value("admin")
    ADMIN,
    @Value("superadmin")
    SUPERADMIN
}
