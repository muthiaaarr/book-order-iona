package com.example.bookorder.interfaces;

import com.example.bookorder.models.BookOrderDetails;

public interface MinimumOrder {

	// MINIMUN ORDER TO GET DISCOUNT
	public final int MINIMUM_ORDER = 3;
	
	// METHOD
	public Boolean discountValidation(BookOrderDetails orderDetails);
	
}
