package com.shareride.profile.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.shareride.core.dao.BaseDao;
import com.shareride.profile.model.Account;
import com.shareride.profile.model.Profile;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sridhar.reddy
 */

@Repository("userDao")
public class UserDao extends BaseDao {
	
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
  /*  @Transactional(readOnly=true)
    public List<Profile> getAccountByEmail(String email){
    	String hql = "FROM Profile";
    	Query query =  entityManager.createQuery(hql);
    	List<Profile> userDetails = (ArrayList<Profile>)query.getResultList();
    	return userDetails;
    }*/
    
    public List<Account> isValidUser(String emailId){
    	
    	String hql = "from account email = :email";
    	Query query =  entityManager.createQuery(hql);
    	query.setParameter("email", emailId);
    	List<Account> accountDetails =  query.getResultList();
    	
		return accountDetails;
    	
    }

}
