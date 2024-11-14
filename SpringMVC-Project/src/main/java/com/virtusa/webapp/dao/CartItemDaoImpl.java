package com.virtusa.webapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.webapp.model.Cart;
import com.virtusa.webapp.model.CartItem;
import com.virtusa.webapp.model.Product;

@Repository
public class CartItemDaoImpl implements CartItemDao{
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public CartItem getCartItem(Cart cart, Product product) {
		@SuppressWarnings("unchecked")
		List<CartItem> cartItem =(List<CartItem>) hibernateTemplate.find("From CartItem c where c.cart= ?0 and  c.product=?1 ",cart,product);
		if(cartItem.isEmpty()) {
			return null;
		}
		else {
			return cartItem.get(0);
		}
		
	}
	@Override
	public CartItem getCartItem(int cartItemId) {
		return hibernateTemplate.get(CartItem.class,cartItemId);
	}

	@Override
	public void addCart(CartItem item) {
		hibernateTemplate.save(item);	
	}

	@Override
	public void updateCart(CartItem item) {
		hibernateTemplate.saveOrUpdate(item);
	}

	@Override
	public void removeCart(CartItem item) {
		hibernateTemplate.delete(item);
		
	}

	@Override
	public void removeAll(Cart cart) {
		
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<CartItem> findCartItems(Cart cart) {
		return (List<CartItem>) hibernateTemplate.find("from cartItem c where c.cart=?0",cart);
	}
	@Override
	public void updateCart(Cart cart) {
		hibernateTemplate.saveOrUpdate(cart);
		
	}

}
