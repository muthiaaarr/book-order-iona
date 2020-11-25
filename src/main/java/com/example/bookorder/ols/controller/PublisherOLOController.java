package com.example.bookorder.ols.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Publisher;
import com.example.bookorder.ols.PublisherOLO;
import com.io.iona.springboot.controllers.HibernateOptionListController;

@RestController
@RequestMapping("ol/publisher")
public class PublisherOLOController extends HibernateOptionListController<Publisher, PublisherOLO> {

}
