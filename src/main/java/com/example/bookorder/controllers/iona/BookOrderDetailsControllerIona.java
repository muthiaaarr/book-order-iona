package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.BookOrderDetails;
import com.example.bookorder.models.dtos.BookOrderDetailsDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/book-order-details-iona")
public class BookOrderDetailsControllerIona extends HibernateCRUDController<BookOrderDetails, BookOrderDetailsDto>{

}
