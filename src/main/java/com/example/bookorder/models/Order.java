package com.example.bookorder.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 447974315301090509L;

	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_order_order_id_seq")
	@SequenceGenerator(name = "generator_order_order_id_seq", sequenceName = "order_order_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "order_id", unique = true)
	private Long orderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "order_date", nullable = false)
	private Date orderDate;
	
	@Column(name = "total_order")
	private BigDecimal totalOrder;
	
	// MANY TO ONE ORDER-CUSTOMER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	// MANY TO MANY BOOK-ORDER
	@OneToMany(mappedBy = "order")
	private Set<BookOrderDetails> orders;
	
	// CONSTRUCTOR
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Long orderId, Customer customer, Date orderDate, BigDecimal totalOrder, Set<BookOrderDetails> orders) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.totalOrder = totalOrder;
		this.orders = orders;
	}

	// GETTER & SETTER
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(BigDecimal totalOrder) {
		this.totalOrder = totalOrder;
	}

	public Set<BookOrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(Set<BookOrderDetails> orders) {
		this.orders = orders;
	}
	
	
}
