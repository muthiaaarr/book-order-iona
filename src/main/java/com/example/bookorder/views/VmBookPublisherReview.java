package com.example.bookorder.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "vm_book_publisher_review")
public class VmBookPublisherReview {

	private String title;
	private String companyName;
	private String country;
	private int rating_score;
	private String reviewerName;
	
	@Id
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "company_name")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "rating_score")
	public int getRating_score() {
		return rating_score;
	}
	public void setRating_score(int rating_score) {
		this.rating_score = rating_score;
	}
	
	@Column(name = "name")
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	
}
