package com.virtusa.webapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.webapp.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired(required = true)
	HibernateTemplate hibernateTemplate;

	@Override
	public boolean addProduct(Product p) {
		if(hibernateTemplate.get(Product.class,p.getId())==null){
			hibernateTemplate.save(p);
			return true;
		}
		return false;
	}

	@Override
	public void updateProduct(Product p) {
		hibernateTemplate.saveOrUpdate(p);
	}

	@Override
	public void deleteProduct(int id) {
		hibernateTemplate.delete(hibernateTemplate.get(Product.class,id));
		
	}

	@Override
	public Product getProduct(int id) {
		
		return hibernateTemplate.get(Product.class,id);
	}

	@Override
	public List<Product> getAll() {
		return hibernateTemplate.loadAll(Product.class);
	}
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Product> searchByName(String name){
		return (List<Product>) hibernateTemplate.find("from Product p where p.name=?0", name);
		//return (List<Product>) hibernateTemplate.findByNamedParam("from Product p where p.name = :name", "name", name);
		//return (List<Product>) hibernateTemplate.findByNamedQuery("from Products p where p.name=?",name);
		
	}

}
