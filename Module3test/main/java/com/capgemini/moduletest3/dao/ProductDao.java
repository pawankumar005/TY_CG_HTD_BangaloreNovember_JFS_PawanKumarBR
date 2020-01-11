package com.capgemini.moduletest3.dao;

import java.util.List;

import com.capgemini.moduletest3.dto.ProductInfo;
import com.capgemini.moduletest3.dto.UserInfo;

public interface ProductDao {
	public List<ProductInfo> getProducts(int id);

}
