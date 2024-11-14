package com.virtusa.webapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Product{
	@Id
	@NotNull(message = "ID required")
	private Integer id;
	@NotEmpty(message = "NAME is mandatory")
	private String name;
	@NotNull(message = "Price is mandatory")
	@Min(value = 1)
	private Integer price;
	@NotNull(message ="Quantity required")
	@Min(value = 0)
	private Integer quantity;
	private String description;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)
	private List<CartItem> cartItems;
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Product() {
		
	}

	public Product(Integer id, String name, Integer price, Integer quantity, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", description="
				+ description + "]";
	}
	
}
