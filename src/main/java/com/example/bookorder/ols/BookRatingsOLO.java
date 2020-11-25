package com.example.bookorder.ols;

import com.io.iona.core.data.annotations.OptionListKey;

public class BookRatingsOLO {

	@OptionListKey
	private Long ratingId;
	private BookOLO book;
	private ReviewerOLO reviewer;
	private int ratingScore;
	
	public Long getRatingId() {
		return ratingId;
	}
	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}
	public BookOLO getBook() {
		return book;
	}
	public void setBook(BookOLO book) {
		this.book = book;
	}
	public ReviewerOLO getReviewer() {
		return reviewer;
	}
	public void setReviewer(ReviewerOLO reviewer) {
		this.reviewer = reviewer;
	}
	public int getRatingScore() {
		return ratingScore;
	}
	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}
	
	
}
