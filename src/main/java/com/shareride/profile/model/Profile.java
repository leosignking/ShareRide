package com.shareride.profile.model;

import com.shareride.core.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author sridhar.reddy
 * @created-on 6/10/15.
 */

@Entity
@Table(name = "profile")
@Inheritance(strategy = InheritanceType.JOINED)
public class Profile extends BaseEntity{

    @Size(min = 3, max = 128, message = "Minimum 3 characters")
    @Column(name = "first_name", columnDefinition = "VARCHAR(128)", nullable = false)
    private String firstName;

    @Size(min = 3, max = 128, message = "Minimum 3 characters")
    @Column(name = "last_name", columnDefinition = "VARCHAR(128)", nullable = false)
    private String lastName;

    @Size(min = 10, max = 10, message = "Required")
    @Column(name = "mobile_no", nullable = false)
    private int mobileNo;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }
}
