package com.example.bookorder.models.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto {

	private Long orderId;
	private CustomerDto customer;
	private Date orderDate;
	private BigDecimal totalOrder;
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderDto(Long orderId, CustomerDto customer, Date orderDate, BigDecimal totalOrder) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.totalOrder = totalOrder;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
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
	
	
}
