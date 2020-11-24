package com.example.bookorder.models.dtos;

public class PublisherDto {

	private Long publisherId;
	private String companyName;
	private String country;
	private PaperDto paper;
	
	public PublisherDto() {
		// TODO Auto-generated constructor stub
	}

	public PublisherDto(Long publisherId, String companyName, String country, PaperDto paper) {
		super();
		this.publisherId = publisherId;
		this.companyName = companyName;
		this.country = country;
		this.paper = paper;
	}

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

	public PaperDto getPaper() {
		return paper;
	}

	public void setPaper(PaperDto paper) {
		this.paper = paper;
	}
	
	
}
