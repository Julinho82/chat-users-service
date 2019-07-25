package com.dh.fullstack.users.service.model.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Santiago Mamani
 */
@Entity
@Table(name = "user_table")
//@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @Column(name = "userid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate", nullable = false, updatable = false)
    private Date createdDate;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "accounttableid", referencedColumnName = "id", nullable = false)
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @PrePersist
    void onPrePersist(){
        this.createdDate = new Date();
    }
}
