package com.example.bookorder.view.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.view.dtos.VmBookPublisherReviewDTO;
import com.example.bookorder.views.VmBookPublisherReview;
import com.io.iona.springboot.controllers.HibernateViewController;

@RestController
@RequestMapping("api/book-publisher-review")
public class VmBookPublisherReviewController extends HibernateViewController<VmBookPublisherReview, VmBookPublisherReviewDTO> {

}
