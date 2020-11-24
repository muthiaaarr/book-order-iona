package com.example.bookorder.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Customer;
import com.example.bookorder.models.dtos.CustomerDto;
import com.example.bookorder.repositories.CustomerRepository;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL CUSTOMER
	@GetMapping("/readAll")
	public Map<String, Object> readAllCustomer() {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		List<Customer> customerList = customerRepository.findAll();
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		
		for (Customer c : customerList) {
			CustomerDto customerDto = modelMapper.map(c, CustomerDto.class);
			customerDtoList.add(customerDto);
		}
		
		customerMap.put("message", "Read all customers success!");
		customerMap.put("data", customerDtoList);
		customerMap.put("total item", customerDtoList.size());
		
		return customerMap;
	}
	
	// READ CUSTOMER BY ID
	@GetMapping("/read")
	public Map<String, Object> readCustomerById(@RequestParam("ID") Long customerId) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		Customer customer = customerRepository.findById(customerId).get();
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		
		customerMap.put("message", "Read customer by id success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}
	
	// CREATE CUSTOMER
	@PostMapping("/create")
	public Map<String, Object> createCustomer(@RequestBody CustomerDto customerDto) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		Customer customer = modelMapper.map(customerDto, Customer.class);
		customerRepository.save(customer);
		
		customerDto.setCustomerId(customer.getCustomerId());
		customerMap.put("message", "Create customer success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}
	
	// UPDATE CUSTOMER
	@PutMapping("/update")
	public Map<String, Object> updateCustomer(@RequestParam("ID") Long customerId,
			@RequestBody CustomerDto customerDto) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		Customer customer = customerRepository.findById(customerId).get();
		customer = modelMapper.map(customerDto, Customer.class);
		customer.setCustomerId(customerId);
		
		customerRepository.save(customer);
		
		customerDto.setCustomerId(customerId);
		customerMap.put("message", "Update customer success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}
	
	// DELETE CUSTOMER
	@DeleteMapping("/delete")
	public Map<String, Object> deleteCustomer(@RequestParam("ID") Long customerId) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		Customer customer = customerRepository.findById(customerId).get();
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		
		customerRepository.delete(customer);
		
		customerDto.setCustomerId(customerId);
		customerMap.put("message", "Delete customer success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL CUSTOMER
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllCustomerQuery() {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		List<Customer> customerList = customerRepository.getAllCustomer();
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		
		for (Customer c : customerList) {
			CustomerDto customerDto = modelMapper.map(c, CustomerDto.class);
			customerDtoList.add(customerDto);
		}
		
		customerMap.put("message", "Read all customers success!");
		customerMap.put("data", customerDtoList);
		customerMap.put("total item", customerDtoList.size());
		
		return customerMap;
	}

	// READ CUSTOMER BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readCustomerByIdQuery(@RequestParam("ID") Long customerId) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		Customer customer = customerRepository.getCustomerById(customerId);
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		
		customerMap.put("message", "Read customer by id success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}	
	
	// CREATE CUSTOMER
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createCustomerQuery(@RequestBody CustomerDto customerDto) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		Customer customer = modelMapper.map(customerDto, Customer.class);
		customerRepository.insertIntoCustomer(customer.getCustomerName(),
				customer.getCountry(), customer.getAddress(), customer.getPhoneNumber(), 
				customer.getPostalCode(), customer.getEmail());
		
		customerDto.setCustomerId(customer.getCustomerId());
		customerMap.put("message", "Create customer success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}
	
	// UPDATE CUSTOMER
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updateCustomerQuery(@RequestParam("ID") Long customerId,
			@RequestBody CustomerDto customerDto) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
			
		Customer customer = customerRepository.findById(customerId).get();
		customer = modelMapper.map(customerDto, Customer.class);
		customer.setCustomerId(customerId);
		
		customerRepository.updateCustomer(customer.getCustomerName(), 
				customer.getCountry(), customer.getAddress(), customer.getPhoneNumber(), 
				customer.getPostalCode(), customer.getEmail(), customerId);
		
		customerDto.setCustomerId(customerId);
		customerMap.put("message", "Update customer success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}
	
	// DELETE CUSTOMER
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deleteCustomerQuery(@RequestParam("ID") Long customerId) {
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		Customer customer = customerRepository.findById(customerId).get();
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		customer.setCustomerId(customerId);
		
		customerRepository.deleteCustomer(customerId);
		
		customerDto.setCustomerId(customerId);
		customerMap.put("message", "Delete customer success!");
		customerMap.put("data", customerDto);
		
		return customerMap;
	}

}
