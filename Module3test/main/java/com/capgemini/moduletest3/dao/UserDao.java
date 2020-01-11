package com.capgemini.moduletest3.dao;

import com.capgemini.moduletest3.dto.UserInfo;

public interface UserDao {
	public boolean registerUser(UserInfo userInfo);
	public UserInfo loginUser(String email, String password);
	public boolean changePassword(int id, String password);

}
