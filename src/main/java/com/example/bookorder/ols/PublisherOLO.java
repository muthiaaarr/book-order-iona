package com.example.bookorder.ols;

import com.io.iona.core.data.annotations.OptionListKey;

public class PublisherOLO {

	@OptionListKey
	private Long publisherId;
	private String companyName;
	private String country;
	private PaperOLO paper;
	
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
	public PaperOLO getPaper() {
		return paper;
	}
	public void setPaper(PaperOLO paper) {
		this.paper = paper;
	}
	
	
	
}
