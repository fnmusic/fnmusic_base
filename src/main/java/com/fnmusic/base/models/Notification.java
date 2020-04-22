package com.fnmusic.base.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fnmusic.base.utils.CharacterType;
import com.fnmusic.base.utils.NotificationType;
import com.fnmusic.base.utils.RandomGeneratorUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "notification")
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id = RandomGeneratorUtils.generateCode(CharacterType.ALPHANUMERIC,20);
    private String userId;
    private NotificationType notificationType;
    private String header;
    private String message;
    private Object NotificationObject;
    private String url;
    private boolean read;
    private Long timestamp = new Date().getTime();

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getNotificationObject() {
        return NotificationObject;
    }

    public void setNotificationObject(Object notificationObject) {
        NotificationObject = notificationObject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
