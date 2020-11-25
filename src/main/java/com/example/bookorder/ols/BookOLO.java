package com.example.bookorder.ols;

import java.math.BigDecimal;
import java.util.Date;

import com.io.iona.core.data.annotations.OptionListKey;

public class BookOLO {

	@OptionListKey
	private Long bookId;
	private String title;
	private Date releaseDate;
	private AuthorOLO author;
	private PublisherOLO publisher;
	private BigDecimal price;
	
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
	public AuthorOLO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorOLO author) {
		this.author = author;
	}
	public PublisherOLO getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherOLO publisher) {
		this.publisher = publisher;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
