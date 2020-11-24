package com.example.bookorder.controllers;

import java.math.BigDecimal;
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

import com.example.bookorder.models.Book;
import com.example.bookorder.models.Publisher;
import com.example.bookorder.models.dtos.BookDto;
import com.example.bookorder.repositories.BookRepository;
import com.example.bookorder.repositories.PublisherRepository;


@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	// READ ALL BOOKS
	@GetMapping("/readAll")
	public Map<String, Object> readAllBooks() {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		List<Book> bookList = bookRepository.findAll();
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		
		for (Book b : bookList) {
			BookDto bookDto = modelMapper.map(b, BookDto.class);
			bookDtoList.add(bookDto);
		}
		
		bookMap.put("message", "Read all books success!");
		bookMap.put("data", bookDtoList);
		bookMap.put("total item", bookDtoList.size());
		
		return bookMap;
	}
	
	// READ BOOK BY ID
	@GetMapping("/read")
	public Map<String, Object> readBookById(@RequestParam("ID") Long bookId) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Book book = bookRepository.findById(bookId).get();
		BookDto bookDto = modelMapper.map(book, BookDto.class);
		
		bookMap.put("message", "Read book by id success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}
	
	// CREATE BOOK
	@PostMapping("/create")
	public Map<String, Object> createBook(@RequestBody BookDto bookDto) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.findById(bookDto.getPublisher().getPublisherId()).get();
		BigDecimal bookPrice = calculateBookPrice(publisher);
		bookDto.setPrice(bookPrice);
		
		Book book = modelMapper.map(bookDto, Book.class);

		bookRepository.save(book);
		
		bookDto.setBookId(book.getBookId());
		bookMap.put("message", "Create book success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}

	// METHOD CALCULATE BOOK PRICE
	private BigDecimal calculateBookPrice(Publisher publisher) {
		BigDecimal bookPrice = new BigDecimal(0);
		bookPrice = bookPrice.add(publisher.getPaper().getPaperPrice().multiply(BigDecimal.valueOf(1.5)));
		return bookPrice;
	}
	
	// CALCULATE ALL BOOK PRICE
	@PostMapping("/updateAllBookPrice")
	public Map<String, Object> calculateAllBookPrice() {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		List<Book> bookList = bookRepository.findAll();
		
		for (Book b : bookList) {
			b.setPrice(calculateBookPrice(b.getPublisher()));
			bookRepository.save(b);
		}
		
		bookMap.put("message", "Calculate all book price success!");
		
		return bookMap;
	}
	
	// UPDATE BOOK
	@PutMapping("/update")
	public Map<String, Object> updateBook(@RequestParam("ID") Long bookId,
			@RequestBody BookDto bookDto) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Book book = bookRepository.findById(bookId).get();
		book = modelMapper.map(bookDto, Book.class);
		book.setBookId(bookId);
		
		bookRepository.save(book);
		
		bookDto.setBookId(bookId);
		bookMap.put("message", "Update book success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}
	
	// DELETE BOOK
	@DeleteMapping("/delete")
	public Map<String, Object> deleteBook(@RequestParam("ID") Long bookId) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Book book = bookRepository.findById(bookId).get();
		BookDto bookDto = modelMapper.map(book, BookDto.class);
		
		bookRepository.delete(book);
		
		bookDto.setBookId(bookId);
		bookMap.put("message", "Delete book success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}
	
	// USING QUERY ANNOTATION
	
	// READ ALL BOOKS
	@GetMapping("/query/readAll")
	public Map<String, Object> readAllBooksQuery() {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		List<Book> bookList = bookRepository.getAllBooks();
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		
		for (Book b : bookList) {
			BookDto bookDto = modelMapper.map(b, BookDto.class);
			bookDtoList.add(bookDto);
		}
		
		bookMap.put("message", "Read all books success!");
		bookMap.put("data", bookDtoList);
		bookMap.put("total item", bookDtoList.size());
		
		return bookMap;
	}
	
	// READ BOOK BY ID
	@GetMapping("/query/read")
	public Map<String, Object> readBookByIdQuery(@RequestParam("ID") Long bookId) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Book book = bookRepository.getBookById(bookId);
		BookDto bookDto = modelMapper.map(book, BookDto.class);
		
		bookMap.put("message", "Read book by id success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}
	
	// CREATE BOOK
	@Transactional
	@PostMapping("/query/create")
	public Map<String, Object> createBookQuery(@RequestBody BookDto bookDto) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Publisher publisher = publisherRepository.findById(bookDto.getPublisher().getPublisherId()).get();
		BigDecimal bookPrice = calculateBookPrice(publisher);
		bookDto.setPrice(bookPrice);
		
		Book book = modelMapper.map(bookDto, Book.class);
		bookRepository.insertIntoBook(book.getTitle(), book.getReleaseDate(),
				book.getAuthor().getAuthorId(), book.getPublisher().getPublisherId());
		
		bookDto.setBookId(book.getBookId());
		bookMap.put("message", "Create book success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}
	
	// UPDATE BOOK
	@Transactional
	@PutMapping("/query/update")
	public Map<String, Object> updateBookQuery(@RequestParam("ID") Long bookId,
			@RequestBody BookDto bookDto) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Book book = bookRepository.findById(bookId).get();
		book = modelMapper.map(bookDto, Book.class);
		book.setBookId(bookId);
		
		bookRepository.updateBook(book.getTitle(), book.getReleaseDate(),
				book.getAuthor().getAuthorId(), book.getPublisher().getPublisherId(), bookId);
		
		bookDto.setBookId(bookId);
		bookMap.put("message", "Update book success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}
	
	// DELETE BOOK
	@Transactional
	@DeleteMapping("/query/delete")
	public Map<String, Object> deleteBookQuery(@RequestParam("ID") Long bookId) {
		Map<String, Object> bookMap = new HashMap<String, Object>();
		
		Book book = bookRepository.findById(bookId).get();
		BookDto bookDto = modelMapper.map(book, BookDto.class);
		
		bookRepository.deleteBook(bookId);
		
		bookDto.setBookId(bookId);
		bookMap.put("message", "Delete book success!");
		bookMap.put("data", bookDto);
		
		return bookMap;
	}
	
}
