package com.example.bookorder.views;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "vm_book_author", schema = "public")
public class VmBookAuthor {

	private int no;
	private long bookId;
	private String title;
	private String authorFirstName;
	private String authorLastName;
	private String rating;
	private BigDecimal price;
	
	@Id
	@Column(name = "no", unique = true, nullable = false)
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	@Column(name = "book_id")
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "author_f_name")
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	
	@Column(name = "author_l_name")
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	
	@Column(name = "rating")
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
}
