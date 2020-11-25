package com.example.bookorder.ols;

import java.math.BigDecimal;

import com.example.bookorder.models.OrderDetailsKey;
import com.io.iona.core.data.annotations.OptionListKey;

public class BookOrderDetailsOLO {

	@OptionListKey
	private OrderDetailsKey orderKey;
	private int quantity;
	private BigDecimal discount;
	private BigDecimal tax;
	private OrderOLO order;
	private BookOLO book;
	
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
	public OrderOLO getOrder() {
		return order;
	}
	public void setOrder(OrderOLO order) {
		this.order = order;
	}
	public BookOLO getBook() {
		return book;
	}
	public void setBook(BookOLO book) {
		this.book = book;
	}
	
	
}
