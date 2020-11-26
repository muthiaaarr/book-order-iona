package com.example.bookorder.models.dtos;

import java.math.BigDecimal;

public class PublisherDto {

	private Long publisherId;
	private String companyName;
	private String country;
	private Long paperId;
	private String qualityName;
	private BigDecimal paperPrice;
	
	public PublisherDto() {
		// TODO Auto-generated constructor stub
	}

	public PublisherDto(Long publisherId, String companyName, String country, Long paperId, String qualityName,
			BigDecimal paperPrice) {
		super();
		this.publisherId = publisherId;
		this.companyName = companyName;
		this.country = country;
		this.paperId = paperId;
		this.qualityName = qualityName;
		this.paperPrice = paperPrice;
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

	public Long getPaperId() {
		return paperId;
	}

	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}

	public String getQualityName() {
		return qualityName;
	}

	public void setQualityName(String qualityName) {
		this.qualityName = qualityName;
	}

	public BigDecimal getPaperPrice() {
		return paperPrice;
	}

	public void setPaperPrice(BigDecimal paperPrice) {
		this.paperPrice = paperPrice;
	}

	
	
	
}
