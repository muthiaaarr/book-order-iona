package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.BookOrderDetails;
import com.example.bookorder.ols.BookOrderDetailsOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("ol/book-order-details")
public class BookOrderDetailsOLOController extends HibernateOptionListController<BookOrderDetails, BookOrderDetailsOLO>{

}
