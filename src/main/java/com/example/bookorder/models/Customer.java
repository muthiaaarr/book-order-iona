package com.example.bookorder.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3683728951800363565L;

	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_customer_customer_id_seq")
	@SequenceGenerator(name = "generator_customer_customer_id_seq", sequenceName = "customer_customer_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "customer_id", unique = true)
	private Long customerId;
	
	@Column(name = "name", nullable = false)
	private String customerName;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	// ONE TO MANY CUSTOMER-ORDER
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders;
	
	// CONSTRUCTOR
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String customerName, String country, String address, String phoneNumber,
			String postalCode, String email, Set<Order> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.country = country;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
		this.email = email;
		this.orders = orders;
	}

	// GETTER & SETTER
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
