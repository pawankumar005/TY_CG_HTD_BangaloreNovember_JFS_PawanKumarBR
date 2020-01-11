package com.capgemini.moduletest3.service;

import com.capgemini.moduletest3.dto.UserInfo;

public interface UserSevice {
	public boolean registerUser(UserInfo userInfo);
	public UserInfo loginUser(String email, String password);
	public boolean changePassword(int id, String password);

}
