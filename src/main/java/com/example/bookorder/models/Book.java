package com.example.bookorder.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1218560231241332908L;

	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_book_book_id_seq")
	@SequenceGenerator(name = "generator_book_book_id_seq", sequenceName = "book_book_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "book_id", unique = true)
	private Long bookId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "real_date", nullable = false)
	private Date releaseDate;
	
	@Column(name = "price")
	private BigDecimal price;
	
	// MANY TO ONE BOOK-AUTHOR
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
	// MANY TO ONE BOOK-PUBLISHER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;
	
	// ONE TO MANY BOOK-RATING
	@OneToMany(mappedBy = "book")
	private Set<BookRatings> ratings;
	
	// MANY TO MANY BOOK-ORDER
	@OneToMany(mappedBy = "book")
	private Set<BookOrderDetails> orders;
	
	// CONSTRUCTOR
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Long bookId, String title, Date releaseDate, BigDecimal price, Author author, Publisher publisher,
			Set<BookRatings> ratings, Set<BookOrderDetails> orders) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.ratings = ratings;
		this.orders = orders;
	}

	// GETTER & SETTER
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<BookRatings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<BookRatings> ratings) {
		this.ratings = ratings;
	}

	public Set<BookOrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(Set<BookOrderDetails> orders) {
		this.orders = orders;
	}
	
	
}
