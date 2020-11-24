package com.example.bookorder.models.dtos;

import java.math.BigDecimal;
import java.util.Date;	

public class BookDto {

	private Long bookId;
	private String title;
	private Date releaseDate;
	private AuthorDto author;
	private PublisherDto publisher;
	private BigDecimal price;
	
	public BookDto() {
		// TODO Auto-generated constructor stub
	}

	public BookDto(Long bookId, String title, Date releaseDate, AuthorDto author, PublisherDto publisher,
			BigDecimal price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}

	public PublisherDto getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
