package com.shareride.service;

import com.shareride.beans.UserBean;
import com.shareride.dao.UserDao;
import com.shareride.model.Account;
import com.shareride.model.Profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sridhar.reddy
 *
 */

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public void createUser(UserBean userBean) {

        Profile profile = new Profile();
        profile.setFirstName(userBean.getFirstName());
        profile.setLastName(userBean.getLastName());
        profile.setMobileNo(userBean.getMobileNo());

        Account account = new Account();
        account.setEmail(userBean.getEmail());
        account.setPassword(userBean.getPassword());
        account.setProfile(profile);

        userDao.saveUser(profile, account);

    }




}
