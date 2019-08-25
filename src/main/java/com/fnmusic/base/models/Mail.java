package com.fnmusic.base.models;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.UUID;

public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String userId;
    private String[] mailTo;
    private String[] mailCc;
    private String[] mailBcc;
    private String subject;
    private String text;
    private String actionUrl;

    @PostConstruct
    public void init() {
        if (id == null) this.id = UUID.randomUUID().toString();
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

    public String[] getMailTo() {
        return mailTo;
    }

    public void setMailTo(String[] mailTo) {
        this.mailTo = mailTo;
    }

    public String[] getMailCc() {
        return mailCc;
    }

    public void setMailCc(String[] mailCc) {
        this.mailCc = mailCc;
    }

    public String[] getMailBcc() {
        return mailBcc;
    }

    public void setMailBcc(String[] mailBcc) {
        this.mailBcc = mailBcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
}
