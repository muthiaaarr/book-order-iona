package com.example.bookorder.interfaces;

import java.math.BigDecimal;

import com.example.bookorder.models.BookOrderDetails;

public interface Discount {

	// PERSENTAGE
	public final BigDecimal DISCOUNT_PERSENTAGE = new BigDecimal(0.1);
	
	// METHOD
	public BigDecimal calculateDiscount(BookOrderDetails orderDetails);
}
