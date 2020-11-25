package com.example.bookorder.ols;

import com.io.iona.core.data.annotations.OptionListKey;

public class ReviewerOLO {

	@OptionListKey
	private Long reviewerId;
	private String reviewerName;
	private String country;
	private Boolean verified;
	
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
