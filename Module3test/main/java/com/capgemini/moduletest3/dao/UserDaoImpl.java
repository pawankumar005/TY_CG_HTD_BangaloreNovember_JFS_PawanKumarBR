package com.capgemini.moduletest3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.moduletest3.dto.UserInfo;
import com.capgemini.moduletest3.exception.UserException;
@Repository
public class UserDaoImpl implements UserDao{
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean registerUser(UserInfo userInfo) {
		EntityManager manager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= manager.getTransaction();
		entityTransaction.begin();
		try {
			manager.persist(userInfo);
			entityTransaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			throw new UserException("failed to register");
		}

		//return false;
	}
	

	@Override
	public UserInfo loginUser(String email, String password) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		String jpql="from UserInfo where email=:email and password=:password";
		TypedQuery<UserInfo> query= entityManager.createQuery(jpql,UserInfo.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		try {
			UserInfo userInfo= query.getSingleResult();
			return userInfo;
			}catch(Exception e) {
			throw new UserException("Invalid Credentials");
		}
	}
	
	public boolean changePassword(int id, String password) {
		EntityManager manager= entityManagerFactory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		UserInfo bean= manager.find(UserInfo.class, id);
		bean.setPassword(password);
		transaction.commit();
		return true;
	}


}
