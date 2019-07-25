package com.dh.fullstack.users.service.model.domain;

import javax.persistence.*;

/**
 * @author Santiago Mamani
 */
@Entity
@Table(name = "employee_table")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "employeeid", referencedColumnName = "userid")
})
//@DiscriminatorValue("emp") Cuando se esta usando sigle
public class Employee extends User{

    @Column(name = "firstname", length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastanme", length = 50, nullable = false)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
