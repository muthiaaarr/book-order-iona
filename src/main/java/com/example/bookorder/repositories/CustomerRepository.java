package com.example.bookorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	// FIND ALL CUSTOMERS
	@Query(value = "SELECT * FROM customer", nativeQuery = true)
	public List<Customer> getAllCustomer();
	
	// FIND CUSTOMER BY ID
	@Query(value = "SELECT * FROM customer c WHERE c.customer_id =?", nativeQuery = true)
	public Customer getCustomerById(@Param("customerId") Long id);
	
	// CREATE CUSTOMER
	@Modifying
	@Query(value = "INSERT INTO customer (name, country, address, phone_number, postal_code, email) "
			+ "VALUES (:customerName, :country, :address, :phoneNumber, :postalCode, :email)", nativeQuery = true)
	public int insertIntoCustomer(@Param("customerName") String customerName,
			@Param("country") String country,
			@Param("address") String address,
			@Param("phoneNumber") String phoneNumber,
			@Param("postalCode") String postalCode,
			@Param("email") String email);
	
	// UPDATE CUSTOMER
	@Modifying
	@Query(value = "UPDATE customer c SET name =?, country =?, address =?, phone_number =?, "
			+ "postal_code =?, email =? WHERE c.customer_id =?", nativeQuery = true)
	public int updateCustomer(@Param("customerName") String customerName,
			@Param("country") String country,
			@Param("address") String address,
			@Param("phoneNumber") String phoneNumber,
			@Param("postalCode") String postalCode,
			@Param("email") String email,
			@Param("customerId") Long id);
	
	// DELETE CUSTOMER
	@Modifying
	@Query(value = "DELETE FROM customer c WHERE c.customer_id =?", nativeQuery = true)
	public int deleteCustomer(@Param("customerId") Long id);
	
	
}
