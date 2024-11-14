package com.virtusa.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.webapp.model.Customer;
import com.virtusa.webapp.model.OrderItem;
import com.virtusa.webapp.model.Orders;
import com.virtusa.webapp.model.User;
import com.virtusa.webapp.service.CustomerService;
import com.virtusa.webapp.service.OrdersService;
import com.virtusa.webapp.service.ProductService;

@Controller
public class UserController{
	
	@RequestMapping("/login")
	public String login(Model m){
		m.addAttribute("user",new User());
		return "login";
		
	}
	@RequestMapping("/register")
	public String register(Model m){
		m.addAttribute("customer", new Customer());
		return "register";
		
	}
	@Autowired
	CustomerService  customerService;
	@Autowired
	ProductService productService;
	@RequestMapping("registerval")
	public String registerVal(@Valid @ModelAttribute("customer") Customer c,Errors er,Model m) {
		if(er.hasErrors()) {
			return "register";
		}
		else {
			if(customerService.addCustomer(c)) {
				m.addAttribute("message","Successfully Reistered Please Login");
				return "redirect:/login";
			}
			m.addAttribute("message","User already Existed try to login or rgister with unique details");
			return "register";
		}
		
	}
	@RequestMapping("loginval")
	public String loginVal(@Valid @ModelAttribute("user") User u,Errors er,Model m,HttpSession s) {
		if(er.hasErrors()) {
			return "login";
		}
		else {
			if(customerService.loginCheck(u)) {
				s.setAttribute("user",u.getUsername());
				return "userhome";
			}
			else {
				m.addAttribute("message","Invalid Credentials");
				return "login";
			}
		}
	}
	
	@RequestMapping("/getAll")
	public String getAllProducts(Model m,HttpSession session) {
		if(session.getAttribute("user")!=null) {
		m.addAttribute("productList",productService.getAll());
		return "viewProductCust";
		}
		return null;
	}
	@RequestMapping("/searchProduct")
	public String searchProduct(HttpSession session) {
		if(session.getAttribute("user")!=null) {
		return "productSearchCust";
		}
		return null;
	}
	@RequestMapping("/searchRes")
	public String searchRes(@RequestParam("product_name") String name,Model m,HttpSession session) {
		if(session.getAttribute("user")!=null) {
		m.addAttribute("productList",productService.searchByName(name));
		return "productSearchCust";
		}
		return null;
 		
	}
	@RequestMapping("/getOrders")
	public String getOrders(HttpSession session,Model m) {
		if(session.getAttribute("user")!=null) {
		String username=(String) session.getAttribute("user");
		Customer customer=customerService.getCustomer(username);
		List<Orders> orders=customer.getOrder();
		m.addAttribute("ordersList", orders);
		return "userOrders";
		}
		return null;
	}
	@Autowired
	OrdersService ordersService;
	@RequestMapping("orderDetails/{orderId}")
	public String getOrderDetails(@PathVariable("orderId") int orderId,Model m,HttpSession session) {
		if(session.getAttribute("user")!=null) {
		Orders order=ordersService.getOrder(orderId);
		List<OrderItem> items=order.getOrderItem();
		m.addAttribute("orderItems", items);
		return "userOrderDetails";
		}
		return null;
		
	}
	
	@RequestMapping("/Home")
	public String getHome(HttpSession session) {
		if(session.getAttribute("user")!=null) {
		return "userhome";
		}
		return null;
	}

}
