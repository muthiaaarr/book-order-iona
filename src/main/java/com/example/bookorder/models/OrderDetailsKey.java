package com.example.bookorder.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailsKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4290386834373083333L;

	// ATTRIBUTE
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "book_id")
	private Long bookId;
	
	// CONSTRUCTOR
	public OrderDetailsKey() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetailsKey(Long orderId, Long bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}

	// GETTER & SETTER
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	// HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	// EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailsKey other = (OrderDetailsKey) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	
}
