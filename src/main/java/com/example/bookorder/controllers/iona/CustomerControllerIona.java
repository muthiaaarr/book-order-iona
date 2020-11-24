package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Customer;
import com.example.bookorder.models.dtos.CustomerDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/customer-iona")
public class CustomerControllerIona extends HibernateCRUDController<Customer, CustomerDto> {

}
