package com.example.bookorder.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "book_ratings")
public class BookRatings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8593430350713022281L;

	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_rating_rating_id_seq")
	@SequenceGenerator(name = "generator_rating_rating_id_seq", sequenceName = "rating_rating_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "rating_id", unique = true)
	private Long ratingId;
	
	@Column(name = "rating_score", nullable = false)
	private int ratingScore;
	
	// MANY TO ONE RATING-BOOK
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	
	// MANY TO ONE BOOK-REVIEWER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reviewer_id")
	private Reviewer reviewer;
	
	// CONSTRUCTOR
	public BookRatings() {
		// TODO Auto-generated constructor stub
	}

	public BookRatings(Long ratingId, Book book, Reviewer reviewer, int ratingScore) {
		super();
		this.ratingId = ratingId;
		this.book = book;
		this.reviewer = reviewer;
		this.ratingScore = ratingScore;
	}

	// GETTER & SETTER
	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	public int getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}
	
	
	
}
