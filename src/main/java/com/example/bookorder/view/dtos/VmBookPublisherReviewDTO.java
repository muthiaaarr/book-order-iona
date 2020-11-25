package com.example.bookorder.view.dtos;

public class VmBookPublisherReviewDTO {

	private String title;
	private String companyName;
	private String country;
	private int rating_score;
	private String reviewerName;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getRating_score() {
		return rating_score;
	}
	public void setRating_score(int rating_score) {
		this.rating_score = rating_score;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	
	
	
}
