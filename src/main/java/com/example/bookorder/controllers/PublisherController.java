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

import com.example.bookorder.models.Publisher;
import com.example.bookorder.models.dtos.PublisherDto;
import com.example.bookorder.repositories.PublisherRepository;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

	@Autowired
	PublisherRepository publisherRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL PUBLISHER
	@GetMapping("/readAll")
	public Map<String, Object> readAllPublisher() {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		List<Publisher> publisherList = publisherRepository.findAll();
		List<PublisherDto> publisherDtoList = new ArrayList<PublisherDto>();
		
		for (Publisher p : publisherList) {
			PublisherDto publisherDto = modelMapper.map(p, PublisherDto.class);
			publisherDtoList.add(publisherDto);
		}
		
		publisherMap.put("message", "Read all publishers success!");
		publisherMap.put("data", publisherDtoList);
		publisherMap.put("total item", publisherDtoList.size());
		
		return publisherMap;
	}
	
	// READ PUBLISHER BY ID
	@GetMapping("/read")
	public Map<String, Object> readPublisherById(@RequestParam("ID") Long publisherId) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.findById(publisherId).get();
		PublisherDto publisherDto = modelMapper.map(publisher, PublisherDto.class);
		
		publisherMap.put("message", "Read publisher by id success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
	// CREATE PUBLISHER
	@PostMapping("/create")
	public Map<String, Object> createPublisher(@RequestBody PublisherDto publisherDto) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
		publisherRepository.save(publisher);
		
		publisherDto.setPublisherId(publisher.getPublisherId());
		publisherMap.put("message", "Create publisher success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
	// UPDATE PUBLISHER
	@PutMapping("/update")
	public Map<String, Object> updatePublisher(@RequestParam("ID") Long publisherID,
			@RequestBody PublisherDto publisherDto) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.findById(publisherID).get();
		publisher = modelMapper.map(publisherDto, Publisher.class);
		publisher.setPublisherId(publisherID);
		
		publisherRepository.save(publisher);
		
		publisherDto.setPublisherId(publisherID);
		publisherMap.put("message", "Update publisher success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
	// DELETE PUBLISHER
	@DeleteMapping("/delete")
	public Map<String, Object> deletePublisher(@RequestParam("ID") Long publisherId) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.findById(publisherId).get();
		PublisherDto publisherDto = modelMapper.map(publisher, PublisherDto.class);
		
		publisherRepository.delete(publisher);
		
		publisherDto.setPublisherId(publisherId);
		publisherMap.put("message", "Delete publisher success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL PUBLISHER
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllPublisherQuery() {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		List<Publisher> publisherList = publisherRepository.getAllPublishers();
		List<PublisherDto> publisherDtoList = new ArrayList<PublisherDto>();
		
		for (Publisher p : publisherList) {
			PublisherDto publisherDto = modelMapper.map(p, PublisherDto.class);
			publisherDtoList.add(publisherDto);
		}
		
		publisherMap.put("message", "Read all publishers success!");
		publisherMap.put("data", publisherDtoList);
		publisherMap.put("total item", publisherDtoList.size());
		
		return publisherMap;
	}

	// READ PUBLISHER BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readPublisherByIdQuery(@RequestParam("ID") Long publisherId) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.getPublisherById(publisherId);
		PublisherDto publisherDto = modelMapper.map(publisher, PublisherDto.class);
		
		publisherMap.put("message", "Read publisher by id success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
	// CREATE PUBLISHER
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createPublisherQuery(@RequestBody PublisherDto publisherDto) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
		publisherRepository.insertToPublisher(publisher.getCompanyName(), 
				publisher.getCountry(), publisher.getPaper().getPaperId());
		
		publisherDto.setPublisherId(publisher.getPublisherId());
		publisherMap.put("message", "Create publisher success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
	// UPDATE PUBLISHER
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updatePublisherQuery(@RequestParam("ID") Long publisherID,
			@RequestBody PublisherDto publisherDto) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.findById(publisherID).get();
		publisher = modelMapper.map(publisherDto, Publisher.class);
		publisher.setPublisherId(publisherID);
		
		publisherRepository.updatePublisher(publisher.getCompanyName(), 
				publisher.getCountry(), publisher.getPaper().getPaperId(), publisherID);
		
		publisherDto.setPublisherId(publisherID);
		publisherMap.put("message", "Update publisher success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
	// DELETE PUBLISHER
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deletePublisherQuery(@RequestParam("ID") Long publisherId) {
		Map<String, Object> publisherMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.findById(publisherId).get();
		PublisherDto publisherDto = modelMapper.map(publisher, PublisherDto.class);
		
		publisherRepository.deletePublisher(publisherId);
		
		publisherDto.setPublisherId(publisherId);
		publisherMap.put("message", "Delete publisher success!");
		publisherMap.put("data", publisherDto);
		
		return publisherMap;
	}
	
}
