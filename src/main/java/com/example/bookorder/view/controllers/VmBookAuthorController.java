package com.example.bookorder.view.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.view.dtos.VmBookAuthorDTO;
import com.example.bookorder.views.VmBookAuthor;
import com.io.iona.springboot.controllers.HibernateViewController;

@RestController
@RequestMapping("/api/view-book-author")
public class VmBookAuthorController extends HibernateViewController<VmBookAuthor, VmBookAuthorDTO>{

}
