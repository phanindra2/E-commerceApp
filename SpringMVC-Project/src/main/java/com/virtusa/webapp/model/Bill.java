package com.virtusa.webapp.model;

import java.util.Date;

public class Bill {
	
	private Customer customer;
	private Date date;
	private int total;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Bill(Customer customer, Date date, int total) {
		super();
		this.customer = customer;
		this.date = date;
		this.total = total;
	}
	public Bill() {
		super();
	}
	

}
