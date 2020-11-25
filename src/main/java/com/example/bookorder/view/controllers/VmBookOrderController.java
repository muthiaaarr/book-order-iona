package com.example.bookorder.view.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.view.dtos.VmBookOrderDTO;
import com.example.bookorder.views.VmBookOrder;
import com.io.iona.springboot.controllers.HibernateViewController;

@RestController
@RequestMapping("/api/book-order")
public class VmBookOrderController extends HibernateViewController<VmBookOrder, VmBookOrderDTO> {

}
