package com.virtusa.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.webapp.model.Cart;
import com.virtusa.webapp.model.CartItem;
import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.OrderItem;
import com.virtusa.webapp.model.Product;
import com.virtusa.webapp.service.CartItemService;
import com.virtusa.webapp.service.CustomerService;
import com.virtusa.webapp.service.ProductService;


@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	ProductService productService;
	@Autowired
	CartItemService cartItemService;
	@RequestMapping
	public String goToCart(HttpSession session,Model m){
		
		if(session.getAttribute("user")!=null) {
		System.out.println(session.getAttribute("abc"));
		String username=(String) session.getAttribute("user");
		Customer customer=customerService.getCustomer(username);
		Cart cart=customer.getCart();
		List<CartItem> cartList=cart.getCartItems();
		m.addAttribute("cartList",cartList);
		return "cart";
		}
		return null;
	}
	@RequestMapping("/add_item/{productId}")
	public String  addItem(@PathVariable("productId") int id,Model m,HttpSession session) {
		String username=(String) session.getAttribute("user");
		Customer customer=customerService.getCustomer(username);
		Product product=productService.getProduct(id);
		cartItemService.addCart(customer.getCart(),product);
		return "redirect:/cart";
	}
	@RequestMapping("remove_item/{cartItem}")
	public String removeItem(@PathVariable("cartItem") int id,Model m,HttpSession session){
		if(session.getAttribute("user")!=null) {
		cartItemService.removeCart(id);
		return "redirect:/cart";
		}
		return null;
	}
	@RequestMapping("edit_item/{cartItem}")
	public String editItem(@PathVariable("cartItem") int id,Model m,HttpSession session){
		if(session.getAttribute("user")!=null) {
			m.addAttribute("cartItemId",id);
			return "editCartItem";
		}
		return null;
	}
	@RequestMapping("edit_item/editItem")
	public String editCartItem(@RequestParam("cartItemId") int id,@RequestParam("quantity") int quant,Model m,HttpSession session) {
		cartItemService.updateCart(id, quant);
		return "redirect:/cart";
	}
	
	@RequestMapping("/checkout")
	public String checkoutCart(HttpSession session,Model m) {
		String username=(String) session.getAttribute("user");
		Customer customer=customerService.getCustomer(username);
		List<OrderItem> itemsList=customerService.placeOrder(customer);
		Cart cart=customer.getCart();
		List<CartItem> cartList=cart.getCartItems();
		m.addAttribute("orderList",itemsList);
		m.addAttribute("cartList",cartList);
		m.addAttribute("userDetails",customer);
		
		return "order";
		
	}
	

}
