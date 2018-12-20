package com.shareride.profile.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shareride.core.dao.BaseDao;
import com.shareride.profile.model.Account;
import com.shareride.profile.model.Profile;
import com.shareride.profile.service.UserService;

/**
 * @author sridhar.reddy
 */

@Repository("userDao")
public class UserDao extends BaseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
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

/*    public Account getByEmail(String email){
    	logger.info("control in UserDao Layer: getAccountByEmail()");
    	Account account = getAccountByEmail(email);
		return account;
    	
    }
    public Account isValidUser(String emailId){
    	logger.info("control in UserDao Layer: isValidUser()");
    	return getAccountByEmail(emailId);
    }
    */
    public Account getAccountByEmail(String emailId){
    	logger.info("control in UserDao Layer: getAccountDetailsByEmail()");
    	String hql = "from Account where email = :email";
    	Query query =  entityManager.createQuery(hql);
    	query.setParameter("email", emailId);
    	logger.info("Before executing the query: "+query);
    	return (Account) query.getResultList().get(0);
    }
    

}
