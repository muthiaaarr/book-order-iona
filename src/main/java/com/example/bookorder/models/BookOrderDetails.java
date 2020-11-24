package com.example.bookorder.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "book_order_details")
public class BookOrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8896264429804503802L;

	// ATTRIBUTE
	@EmbeddedId		// COMPOSITE-KEY BOOK-ORDER
	private OrderDetailsKey orderKey;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "discount")
	private BigDecimal discount;
	
	@Column(name = "tax")
	private BigDecimal tax;
	
	// MANY TO MANY BOOK-ORDER
	@ManyToOne
	@MapsId("order_id")
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@MapsId("book_id")
	@JoinColumn(name = "book_id")
	private Book book;
	
	// CONSTRUCTOR
	public BookOrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public BookOrderDetails(OrderDetailsKey orderKey, int quantity, BigDecimal discount, BigDecimal tax, Order order, Book book) {
		super();
		this.orderKey = orderKey;
		this.quantity = quantity;
		this.discount = discount;
		this.tax = tax;
		this.order = order;
		this.book = book;
	}

	// GETTER & SETTER
	public OrderDetailsKey getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(OrderDetailsKey orderKey) {
		this.orderKey = orderKey;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
