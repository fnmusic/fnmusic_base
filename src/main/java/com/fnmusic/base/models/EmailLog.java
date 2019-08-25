package com.fnmusic.base.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.UUID;

@Document(collection = "emailLog")
public class EmailLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String userId;
    private String recipient;
    private String[] cc;
    private String[] bcc;
    private String mailSubject;
    private Object mailObject;
    private boolean sent;
    private Long timeStamp;

    @PostConstruct
    public void init() {
        if (id == null) id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public Object getMailObject() {
        return mailObject;
    }

    public void setMailObject(Object mailObject) {
        this.mailObject = mailObject;
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

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
