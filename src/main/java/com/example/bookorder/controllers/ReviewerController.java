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

import com.example.bookorder.models.Reviewer;
import com.example.bookorder.models.dtos.ReviewerDto;
import com.example.bookorder.repositories.ReviewerRepository;


@RestController
@RequestMapping("/api/reviewer")
public class ReviewerController {

	@Autowired
	ReviewerRepository reviewerRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL REVIEWER
	@GetMapping("/readAll")
	public Map<String, Object> readAllReviewer() {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		List<Reviewer> reviewerList = reviewerRepository.findAll();
		List<ReviewerDto> reviewerDtoList = new ArrayList<ReviewerDto>();
		
		for (Reviewer r : reviewerList) {
			ReviewerDto reviewerDto = modelMapper.map(r, ReviewerDto.class);
			reviewerDtoList.add(reviewerDto);
		}
		
		reviewerMap.put("message", "Read all reviewers success!");
		reviewerMap.put("data", reviewerDtoList);
		reviewerMap.put("total item", reviewerDtoList.size());
		
		return reviewerMap;
	}
	
	// READ REVIEWER BY ID
	@GetMapping("/read")
	public Map<String, Object> readReviewerById(@RequestParam("ID") Long reviewerId) {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = reviewerRepository.findById(reviewerId).get();
		ReviewerDto reviewerDto = modelMapper.map(reviewer, ReviewerDto.class);
		
		reviewerMap.put("message", "Read reviewer by id success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	// CREATE REVIEWER
	@PostMapping("/create")
	public Map<String, Object> createReviewer(@RequestBody ReviewerDto reviewerDto) {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = modelMapper.map(reviewerDto, Reviewer.class);
		reviewerRepository.save(reviewer);
		
		reviewerDto.setReviewerId(reviewer.getReviewerId());
		reviewerMap.put("message", "Create reviewer success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	// UPDATE REVIEWER
	@PutMapping("/update")
	public Map<String, Object> updateReviewer(@RequestParam("ID") Long reviewerId,
			@RequestBody ReviewerDto reviewerDto) {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = reviewerRepository.findById(reviewerId).get();
		reviewer = modelMapper.map(reviewerDto, Reviewer.class);
		reviewer.setReviewerId(reviewerId);
		
		reviewerRepository.save(reviewer);
		
		reviewerDto.setReviewerId(reviewerId);
		reviewerMap.put("message", "Update reviewer success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	// DELETE REVIEWER
	@DeleteMapping("/delete")
	public Map<String, Object> deleteReviewer(@RequestParam("ID") Long reviewerId) {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = reviewerRepository.findById(reviewerId).get();
		ReviewerDto reviewerDto = modelMapper.map(reviewer, ReviewerDto.class);
		
		reviewerRepository.delete(reviewer);
		
		reviewerDto.setReviewerId(reviewerId);
		reviewerMap.put("message", "Delete reviewer success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL REVIEWER
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllReviewerQuery() {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		List<Reviewer> reviewerList = reviewerRepository.getAllReviewer();
		List<ReviewerDto> reviewerDtoList = new ArrayList<ReviewerDto>();
		
		for (Reviewer r : reviewerList) {
			ReviewerDto reviewerDto = modelMapper.map(r, ReviewerDto.class);
			reviewerDtoList.add(reviewerDto);
		}
		
		reviewerMap.put("message", "Read all reviewers success!");
		reviewerMap.put("data", reviewerDtoList);
		reviewerMap.put("total item", reviewerDtoList.size());
		
		return reviewerMap;
	}
	
	// READ REVIEWER BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readReviewerByIdQuery(@RequestParam("ID") Long reviewerId) {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = reviewerRepository.getReviewerById(reviewerId);
		ReviewerDto reviewerDto = modelMapper.map(reviewer, ReviewerDto.class);
		
		reviewerMap.put("message", "Read reviewer by id success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	// CREATE REVIEWER
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createReviewerQuery(@RequestBody ReviewerDto reviewerDto) {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = modelMapper.map(reviewerDto, Reviewer.class);
		reviewerRepository.insertIntoReviewer(reviewer.getReviewerName(), 
				reviewer.getCountry(), reviewer.getVerified());
		
		reviewerDto.setReviewerId(reviewer.getReviewerId());
		reviewerMap.put("message", "Create reviewer success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	// UPDATE REVIEWER
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updateReviewerQuery(@RequestParam("ID") Long reviewerId,
			@RequestBody ReviewerDto reviewerDto) {
		Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = reviewerRepository.findById(reviewerId).get();
		reviewer = modelMapper.map(reviewerDto, Reviewer.class);
		reviewer.setReviewerId(reviewerId);
		
		reviewerRepository.updateReviewer(reviewer.getReviewerName(), 
				reviewer.getCountry(), reviewer.getVerified(), reviewerId);
		
		reviewerDto.setReviewerId(reviewerId);
		reviewerMap.put("message", "Update reviewer success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	// DELETE REVIEWER
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deleteReviewerQuery(@RequestParam("ID") Long reviewerId) {
			Map<String, Object> reviewerMap = new HashMap<String, Object>();
		
		Reviewer reviewer = reviewerRepository.findById(reviewerId).get();
		ReviewerDto reviewerDto = modelMapper.map(reviewer, ReviewerDto.class);
		
		reviewerRepository.deleteReviewer(reviewerId);
		
		reviewerDto.setReviewerId(reviewerId);
		reviewerMap.put("message", "Delete reviewer success!");
		reviewerMap.put("data", reviewerDto);
		
		return reviewerMap;
	}
	
	
}
