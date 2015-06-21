package com.shareride.profile.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sridhar.reddy
 * 
 */
public class UserBean implements Serializable{

	private static final long serialVersionUID = -4356940654408448529L;
	
	private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private Date dob;
    private String gender;

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
    
    public Date getDob() {
		return dob;
	}
    
    public void setDob(Date dob) {
		this.dob = dob;
	}
    
    public String getGender() {
		return gender;
	}
    
    public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserBean [email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNo=" + mobileNo + ", dob=" + dob
				+ ", gender=" + gender +"]";
	}

    
}
