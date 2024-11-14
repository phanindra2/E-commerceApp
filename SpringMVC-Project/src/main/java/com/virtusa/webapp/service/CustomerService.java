package com.virtusa.webapp.service;

import java.util.List;

import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.OrderItem;
import com.virtusa.webapp.model.User;

public interface CustomerService{
	boolean addCustomer(Customer c);
	void updateCustomer(Customer c);
	Customer getCustomer(String username);
	List<Customer> getAll();
	void deleteCustomer(String username);
	boolean loginCheck(User u);
	List<OrderItem> placeOrder(Customer c);
	
}
