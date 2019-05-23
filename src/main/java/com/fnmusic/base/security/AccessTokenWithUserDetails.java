package com.fnmusic.base.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fnmusic.base.models.Permission;
import com.fnmusic.base.models.User;

import java.io.Serializable;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessTokenWithUserDetails implements Serializable {

    @JsonProperty("AccessToken")
    private String accessToken;
    @JsonProperty("Username")
    private String username;
    @JsonProperty("User")
    private User user;

    private Collection<Permission> permissions;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
