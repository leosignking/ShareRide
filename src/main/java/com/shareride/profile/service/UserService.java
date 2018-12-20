package com.shareride.profile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shareride.profile.beans.UserBean;
import com.shareride.profile.dao.UserDao;
import com.shareride.profile.model.Account;
import com.shareride.profile.model.Profile;

/**
 * @author sridhar.reddy
 */

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);

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

	public String isUserValid(UserBean userBean) {

		logger.info("control in UserService Layer: isUserValid()");
		String emailId = userBean.getEmail();
		String password = userBean.getPassword();
		logger.info("Before calling to userDao : values are email ID:"+emailId+" and password: "+password);
		Account account = userDao.getAccountByEmail(emailId);
		logger.info("After response came from DAO layer ");

		if(account != null){
			if (emailId.equalsIgnoreCase(account.getEmail())
					&& (password.equalsIgnoreCase(account.getPassword()))) {
				return "validUser";
			} else if (emailId.equalsIgnoreCase(account.getEmail())
					&& (!password.equalsIgnoreCase(account.getPassword()))) {
				return "Please check the password";
			} 
		}else{
			return"The Email Id You entered is not registred";
		}
		return "error";
	}

	public UserBean getUserDetailsByEmail(String emailId){

		logger.info("control in UserService Layer: getUserDetailsByEmail()");
		logger.info("Before calling to userDao : values are email ID:"+emailId);
		Account account = userDao.getAccountByEmail(emailId);
		
		UserBean userDetails = new UserBean();
	
		logger.info("After response came from DAO layer ");


		return userDetails;


	}



}
