package com.virtusa.webapp.service;

import com.virtusa.webapp.model.Orders;

public interface OrdersService {
	
	public void addOrder(Orders orders);
	public void updateOrder(Orders orders);
	public Orders getOrder(int id);

}
