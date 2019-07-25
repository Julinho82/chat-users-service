package com.dh.fullstack.users.service.input;

import com.dh.fullstack.users.service.model.domain.AccountState;

/**
 * @author Santiago Mamani
 */
public class AccountInput {

    private String email;

    private Integer age;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
