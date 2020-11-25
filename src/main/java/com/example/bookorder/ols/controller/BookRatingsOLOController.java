package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.BookRatings;
import com.example.bookorder.ols.BookRatingsOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("ol/book-ratings")
public class BookRatingsOLOController extends HibernateOptionListController<BookRatings, BookRatingsOLO>{

}
