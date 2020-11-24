package com.example.bookorder.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.BookRatings;
import com.example.bookorder.models.dtos.BookRatingsDto;
import com.example.bookorder.repositories.BookRatingsRepository;


@RestController
@RequestMapping("/api/bookratings")
public class BookRatingsController {

	@Autowired
	BookRatingsRepository bookRatingRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL BOOK RATINGS
	@GetMapping("/readAll")
	public Map<String, Object> readAllBookRatings() {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		List<BookRatings> ratingList = bookRatingRepository.findAll();
		List<BookRatingsDto> ratingDtoList = new ArrayList<BookRatingsDto>();
		
		for (BookRatings r : ratingList) {
			BookRatingsDto ratingDto = modelMapper.map(r, BookRatingsDto.class);
			ratingDtoList.add(ratingDto);
		}
		
		ratingMap.put("message", "Read all book ratings success!");
		ratingMap.put("data", ratingDtoList);
		ratingMap.put("total item", ratingDtoList.size());
		
		return ratingMap;
	}
	
	// READ BOOK RATING BY ID
	@GetMapping("/read")
	public Map<String, Object> readBookRatingById(@RequestParam("ID") Long ratingId) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = bookRatingRepository.findById(ratingId).get();
		BookRatingsDto ratingDto = modelMapper.map(rating, BookRatingsDto.class);
		
		ratingMap.put("message", "Read book rating by id success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
	// CREATE BOOK RATING
	@PostMapping("/create")
	public Map<String, Object> createBookRating(@RequestBody BookRatingsDto ratingDto) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = modelMapper.map(ratingDto, BookRatings.class);
		bookRatingRepository.save(rating);
		
		ratingDto.setRatingId(rating.getRatingId());
		ratingMap.put("message", "Create book rating success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
	// UPDATE BOOK RATING
	@PutMapping("/update")
	public Map<String, Object> updateBookRating(@RequestParam("ID") Long ratingId,
			@RequestBody BookRatingsDto ratingDto) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = bookRatingRepository.findById(ratingId).get();
		rating = modelMapper.map(ratingDto, BookRatings.class);
		rating.setRatingId(ratingId);
		
		bookRatingRepository.save(rating);
		
		ratingDto.setRatingId(ratingId);
		ratingMap.put("message", "Update book rating success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
	// DELETE BOOK RATING
	@DeleteMapping("/delete")
	public Map<String, Object> deleteBookRating(@RequestParam("ID") Long ratingId) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = bookRatingRepository.findById(ratingId).get();
		BookRatingsDto ratingDto = modelMapper.map(rating, BookRatingsDto.class);
		
		bookRatingRepository.delete(rating);
		
		ratingDto.setRatingId(ratingId);
		ratingMap.put("message", "Delete book rating success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL BOOK RATINGS
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllBookRatingsQuery() {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		List<BookRatings> ratingList = bookRatingRepository.getAllRatings();
		List<BookRatingsDto> ratingDtoList = new ArrayList<BookRatingsDto>();
		
		for (BookRatings r : ratingList) {
			BookRatingsDto ratingDto = modelMapper.map(r, BookRatingsDto.class);
			ratingDtoList.add(ratingDto);
		}
		
		ratingMap.put("message", "Read all book ratings success!");
		ratingMap.put("data", ratingDtoList);
		ratingMap.put("total item", ratingDtoList.size());
		
		return ratingMap;
	}
	
	// READ BOOK RATING BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readBookRatingByIdQuery(@RequestParam("ID") Long ratingId) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = bookRatingRepository.getRatingById(ratingId);
		BookRatingsDto ratingDto = modelMapper.map(rating, BookRatingsDto.class);
		
		ratingMap.put("message", "Read book rating by id success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
	// CREATE BOOK RATING
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createBookRatingQuery(@RequestBody BookRatingsDto ratingDto) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = modelMapper.map(ratingDto, BookRatings.class);
		bookRatingRepository.insertIntoRating(rating.getRatingScore(), 
				rating.getBook().getBookId(), rating.getReviewer().getReviewerId());
		
		ratingDto.setRatingId(rating.getRatingId());
		ratingMap.put("message", "Create book rating success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
	// UPDATE BOOK RATING
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updateBookRatingQuery(@RequestParam("ID") Long ratingId,
			@RequestBody BookRatingsDto ratingDto) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = bookRatingRepository.findById(ratingId).get();
		rating = modelMapper.map(ratingDto, BookRatings.class);
		rating.setRatingId(ratingId);
		
		bookRatingRepository.updateRating(rating.getRatingScore(), 
				rating.getBook().getBookId(), rating.getReviewer().getReviewerId(),
				ratingId);
		
		ratingDto.setRatingId(ratingId);
		ratingMap.put("message", "Update book rating success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
	// DELETE BOOK RATING
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deleteBookRatingQuery(@RequestParam("ID") Long ratingId) {
		Map<String, Object> ratingMap = new HashMap<String, Object>();
		
		BookRatings rating = bookRatingRepository.findById(ratingId).get();
		BookRatingsDto ratingDto = modelMapper.map(rating, BookRatingsDto.class);
		
		bookRatingRepository.deleteRating(ratingId);
		
		ratingDto.setRatingId(ratingId);
		ratingMap.put("message", "Delete book rating success!");
		ratingMap.put("data", ratingDto);
		
		return ratingMap;
	}
	
}
