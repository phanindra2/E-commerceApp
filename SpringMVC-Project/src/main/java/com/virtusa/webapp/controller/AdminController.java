package com.virtusa.webapp.controller;

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
import com.virtusa.webapp.model.Product;
import com.virtusa.webapp.model.User;
import com.virtusa.webapp.service.AdminService;
import com.virtusa.webapp.service.CustomerService;
import com.virtusa.webapp.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired(required = true)
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/login")
	public String adminLogin(Model m) {
		m.addAttribute("user", new User());
		return "adminLogin";
		
	}
	@RequestMapping("/loginval")
	public String adminLoginVal(@Valid @ModelAttribute("user")User u,Errors er,Model m,HttpSession session){
		if(er.hasErrors()) {
			return "adminLogin";
		}
		else {
			if(adminService.loginCheck(u)) {
				session.setAttribute("admin", u.getUsername());
				return "adminHome";
			}
			else {
				m.addAttribute("message","Invalid Credentials");
				return "adminLogin";
			}
			
		}
		
	}
	@RequestMapping("/getAll")
	public String getAllCustomers(Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		m.addAttribute("custList",customerService.getAll());
		return "viewCustomers";
		}
		return null;
	}
	@RequestMapping("/edit/{customer_name}")
	public String editCustomer(@PathVariable("customer_name") String username,Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		m.addAttribute("customer_details",customerService.getCustomer(username));
		return "editCustomer";
		}
		return null;
		
	}
	@RequestMapping("/edit/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute("customer_details") Customer c,Errors er,Model m) {
		if(!er.hasErrors()) {
			customerService.updateCustomer(c);
			
			m.addAttribute("message","Updated Successfullyyyyy");
			m.addAttribute("custList",customerService.getAll());
			return "viewCustomers";
		}
		else {
			return "editCustomer";
		}
		
	}
	@RequestMapping("/remove/{customer_name}")
	public String deleteCustomer(@PathVariable("customer_name") String username,Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		customerService.deleteCustomer(username);
		m.addAttribute("message","deleted Successfullyyyyy");
		m.addAttribute("custList",customerService.getAll());
		return "viewCustomers";
		}
		return null;
	}
	
	
	@RequestMapping("/addProduct")
	public String addProduct(Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		m.addAttribute("product",new Product());
		return "addProduct";
		}
		return null;
	}
	
	@RequestMapping("/addProductVal")
	public String productVal(@Valid @ModelAttribute("product") Product p,Errors er,Model m) {
		if(er.hasErrors()) {
			return "addProduct";
		}
		else {
			if(productService.addProduct(p)) {
				m.addAttribute("message","Successfully added a product");
				return "addSuccess";
			}
			m.addAttribute("message","Product already existed");
			return "addProduct";
		}
	}
	
	@RequestMapping("/getAllProducts")
	public String getAllProducts(Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		m.addAttribute("productList",productService.getAll());
		return "viewProducts";
		}
		return null;
		
	}
	@RequestMapping("/remove_product/{product_id}")
	public String deleteProduct(@PathVariable("product_id") int id,Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		productService.deleteProduct(id);
		m.addAttribute("message","deleted Successfullyyyyy");
		m.addAttribute("productList",productService.getAll());
		return "viewProducts";	
		}
		return null;
	}
	@RequestMapping("/edit_product/{product_id}")
	public String editProduct(@PathVariable("product_id") int id,Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		m.addAttribute("product_details",productService.getProduct(id));
		return "editProduct";
		}
		return null;
	}
	
	@RequestMapping("/edit_product/updateProduct")
	public String updateProduct(@Valid @ModelAttribute("product_details") Product p,Errors er,Model m) {
		if(!er.hasErrors()) {
			productService.updateProduct(p);
			m.addAttribute("message","Updated Successfullyyyyy");
			m.addAttribute("productList",productService.getAll());
			return "viewProducts";
		}
		else {
			return "editProduct";
		}
		
	}
	
	@RequestMapping("/searchProduct")
	public String searchProduct(HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		return "productSearch";
		}
		return null;
	}
	@RequestMapping("/searchRes")
	public String searchRes(@RequestParam("product_name") String name,Model m,HttpSession session) {
		if(session.getAttribute("admin")!=null) {
		m.addAttribute("productList",productService.searchByName(name));
		return "productSearch";
		}
		return null;
 		
	}
	@RequestMapping("/home")
	public String homePage(HttpSession session) {
		if(session.getAttribute("admin")!=null) {
			return "adminHome";
		}
		return null;
		
	}
	
	

}
