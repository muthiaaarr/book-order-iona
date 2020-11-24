package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Order;
import com.example.bookorder.models.dtos.OrderDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/order-iona")
public class OrderControllerIona extends HibernateCRUDController<Order, OrderDto> {

}
