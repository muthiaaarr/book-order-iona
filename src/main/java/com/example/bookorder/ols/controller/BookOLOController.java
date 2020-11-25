package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Book;
import com.example.bookorder.ols.BookOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("/ol/book")
public class BookOLOController extends HibernateOptionListController<Book, BookOLO>{

}
