package com.example.bookorder.interfaces;

import java.math.BigDecimal;

import com.example.bookorder.models.BookOrderDetails;

public interface Tax {

	// PERSENTAGE
	public final BigDecimal TAX_PERSENTAGE = new BigDecimal(0.05);
	
	// METHOD
	public BigDecimal calculateTax(BookOrderDetails orderDetails);
	
}
