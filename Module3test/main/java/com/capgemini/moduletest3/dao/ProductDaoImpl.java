package com.capgemini.moduletest3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.moduletest3.dto.ProductInfo;

@Repository
public class ProductDaoImpl implements ProductDao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	public List<ProductInfo> getProducts(int id) {
		String jpql="from ProductInfo where id=:id";
		EntityManager manager= entityManagerFactory.createEntityManager();
		TypedQuery<ProductInfo> query= manager.createQuery(jpql,ProductInfo.class);
		query.setParameter("id", id);
		
		return query.getResultList();
			}

}
