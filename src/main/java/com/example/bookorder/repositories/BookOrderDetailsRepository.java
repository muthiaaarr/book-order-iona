package com.example.bookorder.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.BookOrderDetails;
import com.example.bookorder.models.OrderDetailsKey;

@Repository
public interface BookOrderDetailsRepository extends JpaRepository<BookOrderDetails, OrderDetailsKey>{

	
	// FIND ALL ORDER DETAILS
	@Query(value = "SELECT * FROM book_order_details", nativeQuery = true)
	public List<BookOrderDetails> getAllOrderDetails();
		
	// FIND ORDER DETAILS BY ID
	@Query(value = "SELECT * FROM book_order_details WHERE order_id =? AND book_id = ?",
			nativeQuery = true)
	public BookOrderDetails getOrderDetailsById(@Param("orderId") Long orderId,
			@Param("bookId") Long bookId);
		
	// CREATE ORDER DETAILS
	@Modifying
	@Query(value = "INSERT INTO book_order_details (order_id, book_id, quantity, discount, tax) "
			+ "VALUES (:orderId, :bookId, :quantity, :discount, :tax)",
			nativeQuery = true)
	public int insertToOrderDetails(@Param("orderId") Long orderId,
			@Param("bookId") Long bookId,
			@Param("quantity") int quantity,
			@Param("discount") BigDecimal discount,
			@Param("tax") BigDecimal tax);
		
	// UPDATE ORDER DETAILS
	@Modifying
	@Query(value = "UPDATE book_order_details SET quantity =?, discount =?, tax =?"
			+ " WHERE order_id =? AND book_id = ?",
			nativeQuery = true)
	public int updateOrderDetails(@Param("quantity") int quantity,
			@Param("discount") BigDecimal discount,
			@Param("tax") BigDecimal tax,
			@Param("orderId") Long orderId,
			@Param("bookId") Long bookId);
	
	// DELETE ORDER DETAILS
	@Modifying
	@Query(value = "DELETE FROM book_order_details WHERE order_id =? AND book_id = ?", 
	nativeQuery = true)
	public int deleteOrderDetais(@Param("orderId") Long orderId,
			@Param("bookId") Long bookId);
	
}
