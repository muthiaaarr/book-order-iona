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

import com.example.bookorder.models.BookOrderDetails;
import com.example.bookorder.models.Order;
import com.example.bookorder.models.dtos.OrderDto;
import com.example.bookorder.repositories.OrderRepository;


@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL ORDER
	@GetMapping("/readAll")
	public Map<String, Object> readAllOrder() {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		List<Order> orderList = orderRepository.findAll();
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		
		for (Order o : orderList) {
			OrderDto orderDto = modelMapper.map(o, OrderDto.class);
			orderDtoList.add(orderDto);
		}
		
		orderMap.put("message", "Read all orders success!");
		orderMap.put("data", orderDtoList);
		orderMap.put("total item", orderDtoList.size());
		
		return orderMap;
	}
	
	// READ ORDER BY ID
	@GetMapping("/read")
	public Map<String, Object> readOrderById(@RequestParam("ID") Long orderId) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = orderRepository.findById(orderId).get();
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		
		orderMap.put("message", "Read order by id success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}
	
	// CREATE ORDER
	@PostMapping("/create")
	public Map<String, Object> createOrder(@RequestBody OrderDto orderDto) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = modelMapper.map(orderDto, Order.class);
		orderRepository.save(order);
		
		orderDto.setOrderId(order.getOrderId());
		orderMap.put("message", "Create order success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}
	
	// UPDATE ORDER
	@PutMapping("/update")
	public Map<String, Object> updateOrder(@RequestParam("ID") Long orderId,
			@RequestBody OrderDto orderDto) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = orderRepository.findById(orderId).get();
		order = modelMapper.map(orderDto, Order.class);
		order.setOrderId(orderId);
		
		orderRepository.save(order);
		
		orderDto.setOrderId(orderId);
		orderMap.put("message", "Update order success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}
	
	// DELETE ORDER
	@DeleteMapping("/delete")
	public Map<String, Object> deleteOrder(@RequestParam("ID") Long orderId) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = orderRepository.findById(orderId).get();
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		
		orderRepository.delete(order);
		
		orderDto.setOrderId(orderId);
		orderMap.put("message", "Delete order success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}

	// METHOD CALCULATE TOTAL ORDER
	private BigDecimal calculateTotalOrder(Order order) {
		BigDecimal totalOrder = new BigDecimal(0);
		
		for (BookOrderDetails b : order.getOrders()) {
			totalOrder = totalOrder.add(b.getBook().getPrice()
					.multiply(new BigDecimal(b.getQuantity())))
					.add(b.getTax())
					.subtract(b.getDiscount());
		}
		
		return totalOrder;
	}
	
	// CALCULATE ALL TOTAL ORDER
	@PostMapping("/calculateAllTotalOrder")
	public Map<String, Object> calculateAllTotalOrder() {
		Map<String, Object> calculateMap = new HashMap<String, Object>();

		List<Order> order = orderRepository.findAll();
		
		for (Order o : order) {
			o.setTotalOrder(calculateTotalOrder(o));
			orderRepository.save(o);
		}
		
		calculateMap.put("message", "Calculate all total order success!");
		
		return calculateMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL ORDER
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllOrderQuery() {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		List<Order> orderList = orderRepository.getAllorders();
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		
		for (Order o : orderList) {
			OrderDto orderDto = modelMapper.map(o, OrderDto.class);
			orderDtoList.add(orderDto);
		}
		
		orderMap.put("message", "Read all orders success!");
		orderMap.put("data", orderDtoList);
		orderMap.put("total item", orderDtoList.size());
		
		return orderMap;
	}
	
	// READ ORDER BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readOrderByIdQuery(@RequestParam("ID") Long orderId) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = orderRepository.getOrderById(orderId);
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		
		orderMap.put("message", "Read order by id success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}
	
	// CREATE ORDER
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createOrderQuery(@RequestBody OrderDto orderDto) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = modelMapper.map(orderDto, Order.class);
		orderRepository.insertToOrder(order.getOrderDate(), 
				order.getCustomer().getCustomerId(), order.getTotalOrder());
		
		orderDto.setOrderId(order.getOrderId());
		orderMap.put("message", "Create order success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}
	
	// UPDATE ORDER
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updateOrderQuery(@RequestParam("ID") Long orderId,
			@RequestBody OrderDto orderDto) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = orderRepository.findById(orderId).get();
		order = modelMapper.map(orderDto, Order.class);
		order.setOrderId(orderId);
		
		orderRepository.updateOrder(order.getOrderDate(), 
				order.getCustomer().getCustomerId(), order.getTotalOrder(), orderId);
		
		orderDto.setOrderId(orderId);
		orderMap.put("message", "Update order success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}
	
	// DELETE ORDER
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deleteOrderQuery(@RequestParam("ID") Long orderId) {
		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		Order order = orderRepository.findById(orderId).get();
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		
		orderRepository.deleteOrder(orderId);
		
		orderDto.setOrderId(orderId);
		orderMap.put("message", "Delete order success!");
		orderMap.put("data", orderDto);
		
		return orderMap;
	}

}
