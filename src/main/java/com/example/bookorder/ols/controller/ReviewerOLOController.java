package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Reviewer;
import com.example.bookorder.ols.ReviewerOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("ol/reviewer")
public class ReviewerOLOController extends HibernateOptionListController<Reviewer, ReviewerOLO>{

}
