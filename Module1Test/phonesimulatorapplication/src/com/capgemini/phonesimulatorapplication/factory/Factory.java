package com.capgemini.phonesimulatorapplication.factory;

import com.capgemini.phonesimulatorapplication.dao.DAO;
import com.capgemini.phonesimulatorapplication.dao.DaoImpl;

public class Factory {
	public static DAO insataceOfDaoImpl() {
		DAO d = new DaoImpl();
		return d;
	}

}
