package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.BookRatings;
import com.example.bookorder.models.dtos.BookRatingsDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/book-rating-iona")
public class BookRatingsControllerIona extends HibernateCRUDController<BookRatings, BookRatingsDto> {

}
