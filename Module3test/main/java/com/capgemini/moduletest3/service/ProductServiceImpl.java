package com.capgemini.moduletest3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moduletest3.dao.ProductDao;
import com.capgemini.moduletest3.dto.ProductInfo;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<ProductInfo> getProducts(int id) {
		// TODO Auto-generated method stub
		return productDao.getProducts(id);
	}

}
