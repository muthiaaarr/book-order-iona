package com.example.bookorder.models.dtos;

import java.math.BigDecimal;

public class PaperDto {

	private Long paperId;
	private String qualityName;
	private BigDecimal paperPrice;
	
	public PaperDto() {
		// TODO Auto-generated constructor stub
	}

	public PaperDto(Long paperId, String qualityName, BigDecimal paperPrice) {
		super();
		this.paperId = paperId;
		this.qualityName = qualityName;
		this.paperPrice = paperPrice;
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
