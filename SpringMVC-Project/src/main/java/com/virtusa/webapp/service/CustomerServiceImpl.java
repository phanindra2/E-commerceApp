package com.virtusa.webapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.webapp.dao.CartItemDao;
import com.virtusa.webapp.dao.CustomerDao;
import com.virtusa.webapp.dao.ProductDao;
import com.virtusa.webapp.model.Cart;
import com.virtusa.webapp.model.CartItem;
import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.OrderItem;
import com.virtusa.webapp.model.Orders;
import com.virtusa.webapp.model.Product;
import com.virtusa.webapp.model.User;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartItemDao cartItemDao;
	
	@Transactional
	@Override
	public boolean addCustomer(Customer c) {
		return customerDao.addCustomer(c);
	}
	@Transactional
	@Override
	public void updateCustomer(Customer c) {
		customerDao.updateCustomer(c);
	}

	@Override
	@Transactional
	public Customer getCustomer(String username) {
		return customerDao.getCustomer(username);
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Override
	@Transactional
	public void deleteCustomer(String username) {
		
		customerDao.deleteCustomer(username);
	}

	@Override
	@Transactional
	public boolean loginCheck(User u) {
		return customerDao.loginCheck(u);
	}
	@Transactional
	@Override
	public List<OrderItem> placeOrder(Customer c) {
		int total=0;
		Cart cart=c.getCart();
		List<CartItem> items=cart.getCartItems();
		List <CartItem> dups=new ArrayList<>(items);
		List<OrderItem> orderItems=new ArrayList<>();
		for(CartItem i:dups) {
			Product product=i.getProduct();
			if(product.getQuantity()>=i.getQuantity()) {
				OrderItem orderItem=new OrderItem();
				product.setQuantity(product.getQuantity()-i.getQuantity());
				productDao.updateProduct(product);
				orderItem.setProductId(product.getId());
				orderItem.setProductName(product.getName());
				orderItem.setQuantity(i.getQuantity());
				orderItem.setAmount(i.getTotalPrice());
				total+=i.getTotalPrice();
				orderItems.add(orderItem);
				//orderItem.add()
				items.remove(i);
			}
		}
		if(!orderItems.isEmpty()) {
		cart.setCartItems(items);
		cartItemDao.updateCart(cart);
		c.setCart(cart);
		List<Orders> orders=c.getOrder();
		Orders or=new Orders();
		or.setOrderedDate(new Date());
		for(OrderItem objs:orderItems) {
			objs.setOrders(or);
		}
		or.setOrderItem(orderItems);
		or.setTotal(total);
		or.setCustomer(c);
		orders.add(or);
		customerDao.updateCustomer(c);
		}
		return orderItems;
		
	}

}
