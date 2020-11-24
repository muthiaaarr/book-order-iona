package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Author;
import com.example.bookorder.models.dtos.AuthorDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/author-iona")
public class AuthorControllerIona extends HibernateCRUDController<Author, AuthorDto>{

}
