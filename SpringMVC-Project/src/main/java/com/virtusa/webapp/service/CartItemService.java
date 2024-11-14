package com.virtusa.webapp.service;

import java.util.List;

import com.virtusa.webapp.model.Cart;
import com.virtusa.webapp.model.CartItem;
import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.Product;

public interface CartItemService {
	 CartItem getCartItem(Cart cart, Product product);
	 CartItem getCartItem(int cartItemId);
	void addCart(Cart cart,Product product);
	void removeCart(int cartItemId);
	void removeAll(Cart cart);
	List<CartItem> findByCart(Customer customer);
	void updateCart(Cart cart);
	void updateCart(int cartItemId,int quant);

}
