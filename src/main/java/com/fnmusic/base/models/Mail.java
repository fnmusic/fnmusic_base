package com.fnmusic.base.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Stephen.Enunwah
 */

@Document
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String mailFrom;
    private String[] mailTo;
    private String[] mailCc;
    private String[] mailBcc;
    private String mailSubject;
    private String templateName;
    private String body;
    private String actionLink;
    private Date sentDate;

    public Mail() {
        this.id = UUID.randomUUID().toString();
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
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

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getActionLink() {
        return actionLink;
    }

    public void setActionLink(String actionLink) {
        this.actionLink = actionLink;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "mailFrom='" + mailFrom + '\'' +
                ", mailTo=" + Arrays.toString(mailTo) +
                ", mailCc=" + Arrays.toString(mailCc) +
                ", mailBcc=" + Arrays.toString(mailBcc) +
                ", mailSubject='" + mailSubject + '\'' +
                ", templateName='" + templateName + '\'' +
                ", body='" + body + '\'' +
                ", actionLink='" + actionLink + '\'' +
                ", sentDate=" + sentDate +
                '}';
    }
}
