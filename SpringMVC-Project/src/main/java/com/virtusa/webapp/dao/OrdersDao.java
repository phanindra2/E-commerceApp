package com.virtusa.webapp.dao;

import com.virtusa.webapp.model.Orders;

public interface OrdersDao{
	
	public void addOrder(Orders orders);
	public void updateOrder(Orders orders);
	public Orders getOrder(int id);
	

}
