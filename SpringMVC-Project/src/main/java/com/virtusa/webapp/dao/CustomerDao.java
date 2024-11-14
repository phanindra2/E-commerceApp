package com.virtusa.webapp.dao;

import java.util.List;

import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.User;

public interface CustomerDao {
	boolean addCustomer(Customer c);
	void updateCustomer(Customer c);
	Customer getCustomer(String username);
	List<Customer> getAll();
	void deleteCustomer(String username);
	boolean loginCheck(User u);

}
