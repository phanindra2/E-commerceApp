package com.virtusa.webapp.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.webapp.dao.ProductDao;
import com.virtusa.webapp.model.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired(required = true)
	ProductDao productDao;

	@Override
	@Transactional
	public boolean addProduct(Product p) {
		return productDao.addProduct(p);
	}

	@Override
	@Transactional
	public void updateProduct(Product p) {
		productDao.updateProduct(p);
		
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
		
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}

	@Override
	@Transactional
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	@Transactional
	public List<Product> searchByName(String name) {
		return productDao.searchByName(name);
	}
	

}
