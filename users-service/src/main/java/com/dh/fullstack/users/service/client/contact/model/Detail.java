package com.dh.fullstack.users.service.client.contact.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Santiago Mamani
 */
public class Detail implements Serializable {

    private Long id;

    private String information;

    private Date createdDate;

    public Long getId() {
        return id;
    }

    public String getInformation() {
        return information;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
