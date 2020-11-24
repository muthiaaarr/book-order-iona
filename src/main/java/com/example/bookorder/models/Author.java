package com.example.bookorder.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192806858932864698L;

	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_author_author_id_seq")
	@SequenceGenerator(name = "generator_author_author_id_seq", sequenceName = "author_author_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "author_id", unique = true, nullable = false)
	private Long authorId;
	
	@Column(name = "f_name", nullable = false)
	private String firstName;
	
	@Column(name = "l_name", nullable = false) 
	private String lastName;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "rating", nullable = false)
	private String rating;
	
	// ONE TO MANY AUTHOR-BOOK
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	Set<Book> books;
	
	// CONSTRUCTOR
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(Long authorId, String firstName, String lastName, String gender, Integer age, String country,
			String rating, Set<Book> books) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.country = country;
		this.rating = rating;
		this.books = books;
	}

	// GETTER & SETTER
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
