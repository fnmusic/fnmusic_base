package com.fnmusic.base.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fnmusic.base.utils.CharacterType;
import com.fnmusic.base.utils.RandomGeneratorUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "sms")
public class SMS implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id = RandomGeneratorUtils.generateCode(CharacterType.ALPHANUMERIC,20);
    private String userId;
    private String recipient;
    private String message;
    private boolean sent;
    private Long timeStamp = new Date().getTime();

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}
