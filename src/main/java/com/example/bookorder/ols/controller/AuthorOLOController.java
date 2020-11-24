package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Author;
import com.example.bookorder.ols.AuthorOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("ol/author")
public class AuthorOLOController extends HibernateOptionListController<Author, AuthorOLO> {

}
