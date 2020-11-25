package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Order;
import com.example.bookorder.ols.OrderOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("ol/order")
public class OrderOLOController extends HibernateOptionListController<Order, OrderOLO>{

}
