package com.virtusa.webapp.dao;

import java.util.List;

import com.virtusa.webapp.model.Cart;
import com.virtusa.webapp.model.CartItem;
import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.Product;

public interface CartItemDao {
	CartItem getCartItem(Cart cart,Product product);
	CartItem getCartItem(int cartItemId);
	void addCart(CartItem item);
	void updateCart(CartItem item);
	void removeCart(CartItem item);
	void removeAll(Cart cart);
	List<CartItem> findCartItems(Cart cart);
	void updateCart(Cart cart);
}
