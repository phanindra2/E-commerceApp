package com.virtusa.webapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.webapp.dao.CartItemDao;
import com.virtusa.webapp.model.Cart;
import com.virtusa.webapp.model.CartItem;
import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.Product;


@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemDao cartItemDao;
	@Transactional
	@Override
	public void addCart(Cart cart, Product product) {
		CartItem item=cartItemDao.getCartItem(cart, product);
		if(item==null) {
		item=new CartItem();
		item.setCart(cart);
		item.setProduct(product);
		item.setQuantity(1);
		item.setTotalPrice(product.getPrice());
		cartItemDao.addCart(item);
		}
		else {
			item.setQuantity(item.getQuantity()+1);
			item.setTotalPrice(item.getTotalPrice()+product.getPrice());
			cartItemDao.updateCart(item);
			Cart c=item.getCart();
			List<CartItem> ci=c.getCartItems();
			c.setTotal(ci.stream().mapToInt(CartItem::getTotalPrice).sum());
			cartItemDao.updateCart(c);
		}
	}
	@Override
	@Transactional
	public void removeCart(int cartItemId) {
		CartItem cartItem=cartItemDao.getCartItem(cartItemId);
		Cart cart=cartItem.getCart();
		List<CartItem> cartItems=cart.getCartItems();
		cartItems.remove(cartItem);
		cart.setCartItems(cartItems);
		cartItemDao.updateCart(cart);
		//cartItemDao.removeCart(cartItem);
		
	}
	@Override
	@Transactional
	public void removeAll(Cart cart) {
		cartItemDao.removeAll(cart);
		
	}

	@Override
	@Transactional
	public List<CartItem> findByCart(Customer customer) {
		Cart cart=customer.getCart();
		return cartItemDao.findCartItems(cart);
	}

	@Override
	@Transactional
	public CartItem getCartItem(Cart cart, Product product) {
		return cartItemDao.getCartItem(cart, product);
	}

	@Override
	@Transactional
	public CartItem getCartItem(int cartItemId) {
		return cartItemDao.getCartItem(cartItemId);
	}
	@Override
	@Transactional
	public void updateCart(Cart cart) {
		cartItemDao.updateCart(cart);
		
	}
	@Override
	@Transactional
	public void updateCart(int cartItemId, int quant) {
		CartItem ci=cartItemDao.getCartItem(cartItemId);
		ci.setQuantity(quant);
		ci.setTotalPrice(quant*(ci.getProduct().getPrice()));
		cartItemDao.updateCart(ci);
		Cart c=ci.getCart();
		List<CartItem> ls=c.getCartItems();
		c.setTotal(ls.stream().mapToInt(CartItem::getTotalPrice).sum());
		cartItemDao.updateCart(c);
		
	}
	
}


