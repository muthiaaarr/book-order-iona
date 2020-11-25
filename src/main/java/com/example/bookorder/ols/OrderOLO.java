package com.example.bookorder.ols;

import java.math.BigDecimal;
import java.util.Date;

import com.io.iona.core.data.annotations.OptionListKey;

public class OrderOLO {

	@OptionListKey
	private Long orderId;
	private CustomerOLO customer;
	private Date orderDate;
	private BigDecimal totalOrder;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public CustomerOLO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerOLO customer) {
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
