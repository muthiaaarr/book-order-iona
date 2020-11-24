package com.example.bookorder.controllers;

import java.math.BigDecimal;
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

import com.example.bookorder.interfaces.Discount;
import com.example.bookorder.interfaces.MinimumOrder;
import com.example.bookorder.interfaces.Tax;
import com.example.bookorder.models.BookOrderDetails;
import com.example.bookorder.models.OrderDetailsKey;
import com.example.bookorder.models.dtos.BookOrderDetailsDto;
import com.example.bookorder.repositories.BookOrderDetailsRepository;


@RestController
@RequestMapping("/api/orderdetails")
public class BookOrderDetailsController implements Tax, Discount, MinimumOrder {

	@Autowired
	BookOrderDetailsRepository orderDetailsRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL ORDER DETAILS
	@GetMapping("/readAll")
	public Map<String, Object> readAllOrderDetails() {
		Map<String, Object> orderdetailsMap = new HashMap<String, Object>();
		
		List<BookOrderDetails> orderDetailsList = orderDetailsRepository.findAll();
		List<BookOrderDetailsDto> orderDetailsDtoList = new ArrayList<BookOrderDetailsDto>();
		
		for (BookOrderDetails bo : orderDetailsList) {
			BookOrderDetailsDto orderDetailsDto = modelMapper.map(bo, BookOrderDetailsDto.class);
			orderDetailsDtoList.add(orderDetailsDto);
		}
		
		orderdetailsMap.put("message", "Read all order details success!");
		orderdetailsMap.put("data", orderDetailsDtoList);
		orderdetailsMap.put("total item", orderDetailsDtoList.size());
		
		return orderdetailsMap;
	}
	
	// READ ORDER DETAILS BY ID
	@GetMapping("/read")
	public Map<String, Object> readOrderDetailsById(@RequestParam("order_id") Long orderId, 
			@RequestParam("book_id") Long bookId) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		OrderDetailsKey id = new OrderDetailsKey(orderId, bookId);
		
		BookOrderDetails orderDetails = orderDetailsRepository.findById(id).get();
		BookOrderDetailsDto orderDetailsDto = modelMapper.map(orderDetails, BookOrderDetailsDto.class);
		
		orderDetailsMap.put("message", "Read order details by id success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}
	
	// CREATE ORDER DETAILS
	@PostMapping("/create")
	public Map<String, Object> createOrderDetails(@RequestBody BookOrderDetailsDto orderDetailsDto) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		BookOrderDetails orderDetails = modelMapper.map(orderDetailsDto, BookOrderDetails.class);
		orderDetailsRepository.save(orderDetails);

		orderDetailsDto.setOrderKey(orderDetails.getOrderKey());
		orderDetailsMap.put("message", "Create order details success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}
	
	// UPDATE ORDER DETAILS
	@PutMapping("/update")
	public Map<String, Object> updateOrderDetails(@RequestParam("order_id") Long orderId, 
			@RequestParam("book_id") Long bookId,
			@RequestBody BookOrderDetailsDto orderDetailsDto) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		OrderDetailsKey id = new OrderDetailsKey(orderId, bookId);
		
		BookOrderDetails orderDetails = orderDetailsRepository.findById(id).get();
		
		orderDetails = modelMapper.map(orderDetailsDto, BookOrderDetails.class);
		orderDetails.getOrderKey().setBookId(bookId);
		orderDetails.getOrderKey().setOrderId(orderId);
		
		orderDetailsRepository.save(orderDetails);
		
		orderDetailsDto.getOrderKey().setBookId(bookId);
		orderDetailsDto.getOrderKey().setOrderId(orderId);
		orderDetailsMap.put("message", "Update order success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}
	
	// DELETE ORDER DETAILS
	@DeleteMapping("/delete")
	public Map<String, Object> deleteOrderDetails(@RequestParam("order_id") Long orderId, 
			@RequestParam("book_id") Long bookId) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		OrderDetailsKey id = new OrderDetailsKey(orderId, bookId);
		
		BookOrderDetails orderDetails = orderDetailsRepository.findById(id).get();
		BookOrderDetailsDto orderDetailsDto = modelMapper.map(orderDetails, BookOrderDetailsDto.class);
		
		orderDetailsRepository.delete(orderDetails);
		
		orderDetailsDto.getOrderKey().setBookId(bookId);
		orderDetailsDto.getOrderKey().setOrderId(orderId);
		orderDetailsMap.put("message", "Delete order details success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}
	
	// METHOD CALCULATE TAX
	@Override
	public BigDecimal calculateTax(BookOrderDetails orderDetails) {
		BigDecimal tax = new BigDecimal(0);
		
		tax = tax.add(orderDetails.getBook().getPrice())
				.multiply(new BigDecimal(orderDetails.getQuantity()))
				.multiply(TAX_PERSENTAGE);
		
		return tax;
	}
	
	// CONDITION FOR DISCOUNT
	@Override
	public Boolean discountValidation(BookOrderDetails orderDetails) {
		Boolean result = false;
		
		if (orderDetails.getOrder().getOrders().size() >= MINIMUM_ORDER) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
	// METHOD CALCULATE DISCOUNT
	@Override
	public BigDecimal calculateDiscount(BookOrderDetails orderDetails) {
		BigDecimal discount = new BigDecimal(0);
		
		if (discountValidation(orderDetails) == false) {
			discount = new BigDecimal(0);
		} else {
			discount = discount.add(orderDetails.getBook().getPrice())
					.multiply(new BigDecimal(orderDetails.getQuantity()))
					.multiply(DISCOUNT_PERSENTAGE);
		}
		
		return discount;
	}
	
	// CALCULATE ALL DISCOUNT AND TAX
	@PostMapping("/calculateDiscountAndTax")
	public Map<String, Object> calculateDiscountAndTax() {
		Map<String, Object> calculateMap = new HashMap<String, Object>();
		
		List<BookOrderDetails> orderDetailsList = orderDetailsRepository.findAll();

		for (BookOrderDetails b : orderDetailsList) {
			b.setDiscount(calculateDiscount(b));	// set discount
			b.setTax(calculateTax(b));	// set tax
			
			orderDetailsRepository.save(b);
		}	
		
		calculateMap.put("message", "Calculate all discount and tax success!");
		
		return calculateMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL ORDER DETAILS
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllOrderDetailsQuery() {
		Map<String, Object> orderdetailsMap = new HashMap<String, Object>();
		
		List<BookOrderDetails> orderDetailsList = orderDetailsRepository.getAllOrderDetails();
		List<BookOrderDetailsDto> orderDetailsDtoList = new ArrayList<BookOrderDetailsDto>();
		
		for (BookOrderDetails bo : orderDetailsList) {
			BookOrderDetailsDto orderDetailsDto = modelMapper.map(bo, BookOrderDetailsDto.class);
			orderDetailsDtoList.add(orderDetailsDto);
		}
		
		orderdetailsMap.put("message", "Read all order details success!");
		orderdetailsMap.put("data", orderDetailsDtoList);
		orderdetailsMap.put("total item", orderDetailsDtoList.size());
		
		return orderdetailsMap;
	}
	
	// READ ORDER DETAILS BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readOrderDetailsByIdQuery(@RequestParam("order_id") Long orderId, 
			@RequestParam("book_id") Long bookId) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		BookOrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(bookId, orderId);
		BookOrderDetailsDto orderDetailsDto = modelMapper.map(orderDetails, BookOrderDetailsDto.class);
		
		orderDetailsMap.put("message", "Read order details by id success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}
	
	// CREATE ORDER DETAILS
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createOrderDetailsQuery(@RequestBody BookOrderDetailsDto orderDetailsDto) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		BookOrderDetails orderDetails = modelMapper.map(orderDetailsDto, BookOrderDetails.class);
		orderDetailsRepository.insertToOrderDetails(orderDetails.getOrderKey().getOrderId(), 
				orderDetails.getOrderKey().getBookId(), orderDetails.getQuantity(), 
				orderDetails.getDiscount(), orderDetails.getTax());
		
		orderDetailsDto.setOrderKey(orderDetails.getOrderKey());
		orderDetailsMap.put("message", "Create order details success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}
	
	// UPDATE ORDER DETAILS
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updateOrderDetailsQuery(@RequestParam("order_id") Long orderId, 
			@RequestParam("book_id") Long bookId,
			@RequestBody BookOrderDetailsDto orderDetailsDto) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		OrderDetailsKey id = new OrderDetailsKey(orderId, bookId);
		
		BookOrderDetails orderDetails = orderDetailsRepository.findById(id).get();
		
		orderDetails = modelMapper.map(orderDetailsDto, BookOrderDetails.class);
		orderDetails.getOrderKey().setBookId(bookId);
		orderDetails.getOrderKey().setOrderId(orderId);
		
		orderDetailsRepository.updateOrderDetails(orderDetails.getQuantity(), 
				orderDetails.getDiscount(), orderDetails.getTax(), orderId, bookId);
		
		orderDetailsDto.getOrderKey().setBookId(bookId);
		orderDetailsDto.getOrderKey().setOrderId(orderId);
			orderDetailsMap.put("message", "Update order success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}
	
	// DELETE ORDER DETAILS
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deleteOrderDetailsQuery(@RequestParam("order_id") Long orderId, 
			@RequestParam("book_id") Long bookId) {
		Map<String, Object> orderDetailsMap = new HashMap<String, Object>();
		
		OrderDetailsKey id = new OrderDetailsKey(orderId, bookId);
		
		BookOrderDetails orderDetails = orderDetailsRepository.findById(id).get();
		BookOrderDetailsDto orderDetailsDto = modelMapper.map(orderDetails, BookOrderDetailsDto.class);
		
		orderDetailsRepository.deleteOrderDetais(orderId, bookId);
		
		orderDetailsDto.getOrderKey().setBookId(bookId);
		orderDetailsDto.getOrderKey().setOrderId(orderId);
		orderDetailsMap.put("message", "Delete order details success!");
		orderDetailsMap.put("data", orderDetailsDto);
		
		return orderDetailsMap;
	}

}
