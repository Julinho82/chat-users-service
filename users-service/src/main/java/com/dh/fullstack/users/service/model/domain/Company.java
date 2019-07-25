package com.dh.fullstack.users.service.model.domain;

import javax.persistence.*;

/**
 * @author Santiago Mamani
 */
@Entity
@Table(name = "company_Table")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "companyid", referencedColumnName = "userid")
})
public class Company extends User{

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
