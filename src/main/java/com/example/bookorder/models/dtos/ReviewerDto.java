package com.example.bookorder.models.dtos;

public class ReviewerDto {

	private Long reviewerId;
	private String reviewerName;
	private String country;
	private Boolean verified;
	
	public ReviewerDto() {
		// TODO Auto-generated constructor stub
	}

	public ReviewerDto(Long reviewerId, String reviewerName, String country, Boolean verified) {
		super();
		this.reviewerId = reviewerId;
		this.reviewerName = reviewerName;
		this.country = country;
		this.verified = verified;
	}

	public Long getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	
	
}
