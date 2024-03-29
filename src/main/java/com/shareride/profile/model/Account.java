package com.shareride.profile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Configuration;

import com.shareride.core.model.BaseEntity;

/**
 * @author sridhar.reddy
 */

@Configuration
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends BaseEntity {

<<<<<<< HEAD
    @Column(name = "email", nullable = false, unique= true)
=======
	private static final long serialVersionUID = 7667952751923622483L;

	@Column(name = "email", nullable = false)
>>>>>>> branch 'master' of https://github.com/leosignking/ShareRide.git
    private String email;

    @Column(name = "password", nullable = false)
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
