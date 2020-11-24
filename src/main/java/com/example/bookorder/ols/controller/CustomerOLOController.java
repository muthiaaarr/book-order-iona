package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Customer;
import com.example.bookorder.ols.CustomerOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("ol/customer")
public class CustomerOLOController extends HibernateOptionListController<Customer, CustomerOLO> {

}
