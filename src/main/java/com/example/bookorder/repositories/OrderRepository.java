package com.example.bookorder.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	// FIND ALL ORDERS
	@Query(value = "SELECT * FROM orders", nativeQuery = true)
	public List<Order> getAllorders();
	
	// FIND ORDER BY ID
	@Query(value = "SELECT * FROM orders WHERE order_id = ?", nativeQuery = true)
	public Order getOrderById(Long id);
	
	// CREATE ORDER
	@Modifying
	@Query(value = "INSERT INTO orders (order_date, customer_id, total_order) "
			+ "VALUES (:orderDate, :customerId, :totalOrder)",
			nativeQuery = true)
	public int insertToOrder(@Param("orderDate") Date date, 
			@Param("customerId") Long customerId,
			@Param("totalOrder") BigDecimal totalOrder);
	
	// UPDATE ORDER
	@Modifying
	@Query(value = "UPDATE orders SET order_date =?, customer_id =?, total_order =? "
			+ "WHERE order_id = ?",
			nativeQuery = true)
	public int updateOrder(@Param("orderDate") Date date, 
			@Param("customerId") Long customerId,
			@Param("totalOrder") BigDecimal totalOrder,
			@Param("orderId") Long id);
	
	// DELETE ORDER
	@Modifying
	@Query(value = "DELETE FROM orders WHERE order_id = ?", nativeQuery = true)
	public int deleteOrder(@Param("orderId") Long id);
		
}
