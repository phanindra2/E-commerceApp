package com.virtusa.webapp.service;

import java.util.List;

import com.virtusa.webapp.model.Product;

public interface ProductService {
	boolean addProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(int id);
	Product getProduct(int id);
	List<Product> getAll();
	List<Product> searchByName(String name);

}
