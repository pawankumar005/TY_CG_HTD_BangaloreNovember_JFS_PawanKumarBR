package com.capgemini.phonesimulatorapplication.dao;

import java.util.List;

import com.capgemini.phonesimulatorapplication.bean.UserBean;

public interface DAO {
	public List<UserBean> getAllContacts();
	public boolean addContact(UserBean user);
	public boolean deleteContact(String name);
	public boolean editPhoneNum(long num, String name);
	public boolean editGroup(String group, String name);
	public UserBean searchContact(String name);



}
