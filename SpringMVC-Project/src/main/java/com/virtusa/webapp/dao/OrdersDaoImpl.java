package com.virtusa.webapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.webapp.model.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired(required = true)
	HibernateTemplate hibernateTemplate;
	@Override
	public void addOrder(Orders orders) {
		hibernateTemplate.save(orders);
	}

	@Override
	public void updateOrder(Orders orders) {
		hibernateTemplate.saveOrUpdate(orders);
	}

	@Override
	public Orders getOrder(int id) {
		return hibernateTemplate.get(Orders.class,id);
	}

}
