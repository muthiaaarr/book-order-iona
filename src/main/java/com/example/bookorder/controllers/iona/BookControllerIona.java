package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Book;
import com.example.bookorder.models.dtos.BookDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/book-iona")
public class BookControllerIona extends HibernateCRUDController<Book, BookDto> {

}
