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

import com.example.bookorder.models.Paper;
import com.example.bookorder.models.dtos.PaperDto;
import com.example.bookorder.repositories.PaperRepository;

@RestController
@RequestMapping("/api/paper")
public class PaperController {

	@Autowired
	PaperRepository paperRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL PAPER
	@GetMapping("/readAll")
	public Map<String, Object> readAllPaper() {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		List<Paper> paperList = paperRepository.findAll();
		List<PaperDto> paperDtoList = new ArrayList<PaperDto>();
		
		for (Paper p : paperList) {
			PaperDto paperDto = modelMapper.map(p, PaperDto.class);
			paperDtoList.add(paperDto);
		}
		
		paperMap.put("message", "Read all papers success!");
		paperMap.put("data", paperDtoList);
		paperMap.put("total item", paperDtoList.size());
		
		return paperMap;
	}
	
	// READ PAPER BY ID
	@GetMapping("/read")
	public Map<String, Object> readPaperById(@RequestParam("ID") Long paperId) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = paperRepository.findById(paperId).get();
		PaperDto paperDto = modelMapper.map(paper, PaperDto.class);
		
		paperMap.put("message", "Read paper by id success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
	// CREATE PAPER
	@PostMapping("/create")
	public Map<String, Object> createPaper(@RequestBody PaperDto paperDto) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = modelMapper.map(paperDto, Paper.class);
		paperRepository.save(paper);
		
		paperDto.setPaperId(paper.getPaperId());
		paperMap.put("message", "Create paper success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
	// UPDATE PAPER
	@PutMapping("/update")
	public Map<String, Object> updatePaper(@RequestParam("ID") Long paperId,
			@RequestBody PaperDto paperDto) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = paperRepository.findById(paperId).get(); 
		paper = modelMapper.map(paperDto, Paper.class);
		paper.setPaperId(paperId);
		
		paperRepository.save(paper);
		
		paperDto.setPaperId(paperId);
		paperMap.put("message", "Update paper success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
	// DELETE PAPER
	@DeleteMapping("/delete")
	public Map<String, Object> deletePaper(@RequestParam("ID") Long paperId) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = paperRepository.findById(paperId).get();
		PaperDto paperDto = modelMapper.map(paper, PaperDto.class);
		
		paperRepository.delete(paper);
		
		paperDto.setPaperId(paperId);
		paperMap.put("message", "Delete paper success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL PAPER
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllPaperQuery() {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		List<Paper> paperList = paperRepository.getAllPaper();
		List<PaperDto> paperDtoList = new ArrayList<PaperDto>();
		
		for (Paper p : paperList) {
			PaperDto paperDto = modelMapper.map(p, PaperDto.class);
			paperDtoList.add(paperDto);
		}
		
		paperMap.put("message", "Read all papers success!");
		paperMap.put("data", paperDtoList);
		paperMap.put("total item", paperDtoList.size());
		
		return paperMap;
	}
		
	// READ PAPER BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readPaperByIdQuery(@RequestParam("ID") Long paperId) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = paperRepository.getPaperById(paperId);
		PaperDto paperDto = modelMapper.map(paper, PaperDto.class);
		
		paperMap.put("message", "Read paper by id success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
	// CREATE PAPER
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createPaperQuery(@RequestBody PaperDto paperDto) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = modelMapper.map(paperDto, Paper.class);
		paperRepository.insertToPaper(paper.getQualityName(), paper.getPaperPrice());
		
		paperDto.setPaperId(paper.getPaperId());
		paperMap.put("message", "Create paper success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
	// UPDATE PAPER
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updatePaperQuery(@RequestParam("ID") Long paperId,
			@RequestBody PaperDto paperDto) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = paperRepository.findById(paperId).get(); 
		paper = modelMapper.map(paperDto, Paper.class);
		paper.setPaperId(paperId);
		
		paperRepository.updatePaper(paper.getQualityName(), paper.getPaperPrice(), paperId);
		
		paperDto.setPaperId(paperId);
		paperMap.put("message", "Update paper success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
	// DELETE PAPER
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deletePaperQuery(@RequestParam("ID") Long paperId) {
		Map<String, Object> paperMap = new HashMap<String, Object>();
		
		Paper paper = paperRepository.findById(paperId).get();
		PaperDto paperDto = modelMapper.map(paper, PaperDto.class);
		paper.setPaperId(paperId);
		
		paperRepository.deletePaper(paperId);
		
		paperDto.setPaperId(paperId);
		paperMap.put("message", "Delete paper success!");
		paperMap.put("data", paperDto);
		
		return paperMap;
	}
	
}
