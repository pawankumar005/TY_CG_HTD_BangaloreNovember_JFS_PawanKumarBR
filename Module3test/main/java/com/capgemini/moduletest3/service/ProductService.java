package com.capgemini.moduletest3.service;

import java.util.List;

import com.capgemini.moduletest3.dto.ProductInfo;

public interface ProductService {
	public List<ProductInfo> getProducts(int id);

}
