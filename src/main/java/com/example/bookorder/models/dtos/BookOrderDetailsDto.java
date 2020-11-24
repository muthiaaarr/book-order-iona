package com.example.bookorder.models.dtos;

import java.math.BigDecimal;

import com.example.bookorder.models.OrderDetailsKey;

public class BookOrderDetailsDto {
	
	private OrderDetailsKey orderKey;
	private int quantity;
	private BigDecimal discount;
	private BigDecimal tax;
	private OrderDto order;
	private BookDto book;
	
	public BookOrderDetailsDto() {
		// TODO Auto-generated constructor stub
	}

	public BookOrderDetailsDto(OrderDetailsKey orderKey, int quantity, BigDecimal discount, BigDecimal tax, OrderDto order, BookDto book) {
		super();
		this.orderKey = orderKey;
		this.quantity = quantity;
		this.discount = discount;
		this.tax = tax;
		this.order = order;
		this.book = book;
	}

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

	public OrderDto getOrder() {
		return order;
	}

	public void setOrder(OrderDto order) {
		this.order = order;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}
	
	
}
