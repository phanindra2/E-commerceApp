package com.virtusa.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.webapp.dao.OrdersDao;
import com.virtusa.webapp.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrdersDao ordersDao;

	@Override
	@Transactional
	public void addOrder(Orders orders) {
		ordersDao.addOrder(orders);
		
	}

	@Override
	@Transactional
	public void updateOrder(Orders orders) {
		ordersDao.updateOrder(orders);
		
	}

	@Override
	@Transactional
	public Orders getOrder(int id) {
		return ordersDao.getOrder(id);
	}

}
