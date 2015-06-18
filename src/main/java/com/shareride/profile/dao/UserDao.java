package com.shareride.profile.dao;

import com.shareride.core.dao.BaseDao;
import com.shareride.profile.model.Account;
import com.shareride.profile.model.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author sridhar.reddy
 */

@Repository("userDao")
public class UserDao extends BaseDao {

    public void saveUser(Profile profile, Account account) {
        create(profile);
        create(account);
    }

    public void saveAccount(Account account) {
        create(account);
    }

    public void saveProfile(Profile profile) {
        create(profile);
    }

    public void saveOrUpdateAccount(Account account) {
        update(account);
    }
    
    public void saveOrUpdateProfile(Profile profile) {
        update(profile);
    }

}
