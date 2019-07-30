package com.dh.fullstack.users.service.client.contact.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Santiago Mamani
 */
public class Contact implements Serializable {

    private Long id;

    private Long userId;

    private Long accountId;

    private String email;

    private String name;

    private String avatarId;

    private Date createdDate;

    private Detail detail;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Detail getDetail() {
        return detail;
    }
}
