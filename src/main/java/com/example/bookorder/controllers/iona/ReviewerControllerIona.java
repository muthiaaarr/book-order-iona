package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Reviewer;
import com.example.bookorder.models.dtos.ReviewerDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/reviewer-iona")
public class ReviewerControllerIona extends HibernateCRUDController<Reviewer, ReviewerDto> {

}
