package com.fnmusic.base.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fnmusic.base.utils.AuditLogType;
import com.fnmusic.base.utils.CharacterType;
import com.fnmusic.base.utils.RandomGeneratorUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "auditLog")
public class AuditLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private final String id = RandomGeneratorUtils.generateCode(CharacterType.ALPHANUMERIC,100);
    private String userId;
    private AuditLogType auditLogType;
    private String event;
    private String description;
    private Role role;
    private Object auditLogObject;
    private final Long timeStamp = new Date().getTime();

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AuditLogType getAuditLogType() {
        return auditLogType;
    }

    public void setAuditLogType(AuditLogType auditLogType) {
        this.auditLogType = auditLogType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Object getAuditLogObject() {
        return auditLogObject;
    }

    public void setAuditLogObject(Object auditLogObject) {
        this.auditLogObject = auditLogObject;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}
