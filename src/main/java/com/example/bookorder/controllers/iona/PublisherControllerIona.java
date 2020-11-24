package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Publisher;
import com.example.bookorder.models.dtos.PublisherDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/publisher-iona")
public class PublisherControllerIona extends HibernateCRUDController<Publisher, PublisherDto> {

}
