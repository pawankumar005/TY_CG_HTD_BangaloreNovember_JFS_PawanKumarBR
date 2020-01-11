package com.capgemini.moduletest3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moduletest3.dao.UserDao;
import com.capgemini.moduletest3.dto.UserInfo;

@Service
public class UserSeviceImpl implements UserSevice {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean registerUser(UserInfo userInfo) {

		return userDao.registerUser(userInfo);
	}

	@Override
	public UserInfo loginUser(String email, String password) {
		return userDao.loginUser(email, password);
	}

	@Override
	public boolean changePassword(int id, String password) {
		return userDao.changePassword(id, password);
	}

}
