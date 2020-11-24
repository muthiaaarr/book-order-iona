package com.example.bookorder.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reviewer")
public class Reviewer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5520766434253410285L;

	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_reviewer_reviewer_id_seq")
	@SequenceGenerator(name = "generator_reviewer_reviewer_id_seq", sequenceName = "reviewer_reviewer_id_seq", 
						schema = "public", allocationSize = 1)
	@Column(name = "reviewer_id", unique = true)
	private Long reviewerId;
	
	@Column(name = "name", nullable = false)
	private String reviewerName;
	
	@Column(name = "country",nullable = false)
	private String country;
	
	@Column(name = "verified", nullable = false)
	private Boolean verified;
	
	// ONE TO MANY REVIEWER-RATING
	@OneToMany(mappedBy = "reviewer")
	private Set<BookRatings> ratings;
	
	// CONSTRUCTOR
	public Reviewer() {
		// TODO Auto-generated constructor stub
	}

	public Reviewer(Long reviewerId, String reviewerName, String country, Boolean verified, Set<BookRatings> ratings) {
		super();
		this.reviewerId = reviewerId;
		this.reviewerName = reviewerName;
		this.country = country;
		this.verified = verified;
		this.ratings = ratings;
	}

	// GETTER & SETTER
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

	public Set<BookRatings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<BookRatings> ratings) {
		this.ratings = ratings;
	}
	
	
	
}
