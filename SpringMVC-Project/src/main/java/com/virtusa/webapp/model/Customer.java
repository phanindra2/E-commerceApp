package com.virtusa.webapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Customer{
	@Id
	@NotEmpty(message = "Username is mandotary")
	private String username;
	@NotEmpty(message="Password is mandotary")
	private String password;
	@NotEmpty(message= "mail is mandotary")
	private String mail;
	@Min(value = 15, message = "Age must be greayter than 15")
	private Integer age;
	private String adress;
	
	public List<Orders> getOrder() {
		return order;
	}
	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Orders> order;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cartId")
	private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Customer(String username, String password, String mail, Integer age, String adress) {
		super();
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.age = age;
		this.adress = adress;
	}
	public Customer() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", mail=" + mail + ", age=" + age + ", adress=" + adress + "]";
	}

}
