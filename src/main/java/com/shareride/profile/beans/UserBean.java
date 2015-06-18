package com.shareride.profile.beans;

import java.io.Serializable;

/**
 * @author reddy
 * @created-on 6/10/15.
 */
public class UserBean implements Serializable{

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNo;

    public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	@Override
	public String toString() {
		return "UserBean [email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNo=" + mobileNo + "]";
	}

    
}
