package com.example.bookorder.controllers.iona;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Paper;
import com.example.bookorder.models.dtos.PaperDto;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/paper-iona")
public class PaperControllerIona extends HibernateCRUDController<Paper, PaperDto> {

}
