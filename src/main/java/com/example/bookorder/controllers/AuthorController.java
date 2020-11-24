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

import com.example.bookorder.models.Author;
import com.example.bookorder.models.dtos.AuthorDto;
import com.example.bookorder.repositories.AuthorRepository;


@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL AUTHOR
	@GetMapping("/readAll")
	public Map<String, Object> readAllAuthor() {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		List<Author> authorList = authorRepository.findAll();
		List<AuthorDto> authorDtoList = new ArrayList<AuthorDto>();
		
		for (Author a : authorList) {
			AuthorDto authorDto = modelMapper.map(a, AuthorDto.class);
			authorDtoList.add(authorDto);
		}
		
		authorMap.put("message", "Read all authors success!");
		authorMap.put("data", authorDtoList);
		authorMap.put("total item", authorDtoList.size());
		
		return authorMap;
	}
	
	// READ AUTHOR BY ID
	@GetMapping("/read")
	public Map<String, Object> readAuthorById(@RequestParam("ID") Long authorId) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = authorRepository.findById(authorId).get();
		AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
		
		authorMap.put("message", "Read author by id success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
	// CREATE AUTHOR
	@PostMapping("/create")
	public Map<String, Object> createAuthor(@RequestBody AuthorDto authorDto) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = modelMapper.map(authorDto, Author.class);
		authorRepository.save(author);
		
		authorDto.setAuthorId(author.getAuthorId());
		authorMap.put("message", "Create author success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
	// UPDATE AUTHOR
	@PutMapping("/update")
	public Map<String, Object> updateAuthor(@RequestParam("ID") Long authorId,
			@RequestBody AuthorDto authorDto) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = authorRepository.findById(authorId).get();
		author = modelMapper.map(authorDto, Author.class);
		author.setAuthorId(authorId);
		
		authorRepository.save(author);
		
		authorDto.setAuthorId(authorId);
		authorMap.put("message", "Update author success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
	// DELETE AUTHOR
	@DeleteMapping("/delete")
	public Map<String, Object> deleteAuthor(@RequestParam("ID") Long authorId) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = authorRepository.findById(authorId).get();
		AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
		
		authorRepository.delete(author);
		
		authorDto.setAuthorId(authorId);
		authorMap.put("message", "Delete author success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL AUTHOR
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllAuthorQuery() {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		List<Author> authorList = authorRepository.getAllAuthor();
		List<AuthorDto> authorDtoList = new ArrayList<AuthorDto>();
		
		for (Author a : authorList) {
			AuthorDto authorDto = modelMapper.map(a, AuthorDto.class);
			authorDtoList.add(authorDto);
		}
		
		authorMap.put("message", "Read all authors success!");
		authorMap.put("data", authorDtoList);
		authorMap.put("total item", authorDtoList.size());
		
		return authorMap;
	}
	
	// READ AUTHOR BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readAuthorByIdQuery(@RequestParam("ID") Long authorId) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = authorRepository.getAuthorById(authorId);
		AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
		
		authorMap.put("message", "Read author by id success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
	// CREATE AUTHOR
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createAuthorQuery(@RequestBody AuthorDto authorDto) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = modelMapper.map(authorDto, Author.class);
		authorRepository.insertIntoAuthor(author.getFirstName(), 
				author.getLastName(), author.getGender(), 
				author.getAge(), author.getCountry(), author.getRating());
		
		authorDto.setAuthorId(author.getAuthorId());
		authorMap.put("message", "Create author success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
	// UPDATE AUTHOR
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updateAuthorQuery(@RequestParam("ID") Long authorId,
			@RequestBody AuthorDto authorDto) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = authorRepository.findById(authorId).get();
		author = modelMapper.map(authorDto, Author.class);
		author.setAuthorId(authorId);
		
		authorRepository.updateAuthor(author.getFirstName(), 
				author.getLastName(), author.getGender(), 
				author.getAge(), author.getCountry(),
				author.getRating(), authorId);
		
		authorDto.setAuthorId(authorId);
		authorMap.put("message", "Update author success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
	// DELETE AUTHOR
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deleteAuthorQuery(@RequestParam("ID") Long authorId) {
		Map<String, Object> authorMap = new HashMap<String, Object>();
		
		Author author = authorRepository.findById(authorId).get();
		AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
		author.setAuthorId(authorId);
		
		authorRepository.deleteAuthor(authorId);
		
		authorDto.setAuthorId(authorId);
		authorMap.put("message", "Delete author success!");
		authorMap.put("data", authorDto);
		
		return authorMap;
	}
	
}
