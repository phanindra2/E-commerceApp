package com.virtusa.webapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.webapp.model.Cart;
import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.User;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addCustomer(Customer c) {
		if(hibernateTemplate.get(Customer.class,c.getUsername())==null) {
			c.setCart(new Cart());
			hibernateTemplate.persist(c);
			return true;
		}
		return false;
	}

	@Override
	public void updateCustomer(Customer c) {
		hibernateTemplate.saveOrUpdate(c);
	}

	@Override
	public Customer getCustomer(String username) {
		return hibernateTemplate.get(Customer.class, username);
	}

	@Override
	public List<Customer> getAll() {
		return hibernateTemplate.loadAll(Customer.class);
	}

	@Override
	public void deleteCustomer(String username) {
		hibernateTemplate.delete(hibernateTemplate.get(Customer.class, username));
	}

	@Override
	public boolean loginCheck(User u) {
		if(hibernateTemplate.get(Customer.class,u.getUsername())==null) {
			return false;
		}
		else {
			Customer c=hibernateTemplate.get(Customer.class,u.getUsername());
			if(c.getPassword().equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
