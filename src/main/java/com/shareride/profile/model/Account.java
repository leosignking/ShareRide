package com.shareride.profile.model;

import com.shareride.core.model.BaseEntity;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

/**
 * @author sridhar.reddy
 *
 */

@Configuration
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends BaseEntity{

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
