package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Paper;
import com.example.bookorder.ols.PaperOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("/ol/paper")
public class PaperOLOController extends HibernateOptionListController<Paper, PaperOLO>{

}
