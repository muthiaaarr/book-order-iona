package com.example.bookorder.models.dtos;

public class BookRatingsDto {
	
	private Long ratingId;
	private BookDto book;
	private ReviewerDto reviewer;
	private int ratingScore;
	
	public BookRatingsDto() {
		// TODO Auto-generated constructor stub
	}

	public BookRatingsDto(Long ratingId, BookDto book, ReviewerDto reviewer, int ratingScore) {
		super();
		this.ratingId = ratingId;
		this.book = book;
		this.reviewer = reviewer;
		this.ratingScore = ratingScore;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public ReviewerDto getReviewer() {
		return reviewer;
	}

	public void setReviewer(ReviewerDto reviewer) {
		this.reviewer = reviewer;
	}

	public int getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}
	
	
}
