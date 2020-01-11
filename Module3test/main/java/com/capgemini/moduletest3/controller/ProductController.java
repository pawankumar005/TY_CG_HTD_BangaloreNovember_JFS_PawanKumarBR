package com.capgemini.moduletest3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moduletest3.dto.ProductInfo;
import com.capgemini.moduletest3.dto.ProductResponse;
import com.capgemini.moduletest3.service.ProductService;
import com.capgemini.moduletest3.service.UserSevice;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse serachEmployee(@RequestParam("id") int id) {
		ProductResponse response = new ProductResponse();
		List<ProductInfo> productInfos = productService.getProducts(id);
		if (productInfos.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product of " + id + " found");
			response.setProductInfo(productInfos);
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("product of " + id + " not found");
			response.setProductInfo(productInfos);
		}
		return response;

	}
}
