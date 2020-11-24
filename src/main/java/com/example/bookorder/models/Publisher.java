package com.example.bookorder.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "publisher")
public class Publisher implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -20842185907564129L;

	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_publisher_publisher_id_seq")
	@SequenceGenerator(name = "generator_publisher_publisher_id_seq", sequenceName = "publisher_publisher_id_seq",
						schema = "public", allocationSize = 1)
	@Column(name = "publisher_id", unique = true)
	private Long publisherId;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	// MANY TO ONE PUBLISHER-PAPER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paper_id")
	private Paper paper;
	
	// ONE TO MANY PUBLISHER-BOOK
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	Set<Book> books;
	
	// CONSTRUCTOR
	public Publisher() {
		// TODO Auto-generated constructor stub
	}

	public Publisher(Long publisherId, String companyName, String country, Paper paper, Set<Book> books) {
		super();
		this.publisherId = publisherId;
		this.companyName = companyName;
		this.country = country;
		this.paper = paper;
		this.books = books;
	}

	// GETTER & SETTER
	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
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

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
