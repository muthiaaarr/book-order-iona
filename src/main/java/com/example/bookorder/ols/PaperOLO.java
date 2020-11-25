package com.example.bookorder.ols;

import java.math.BigDecimal;

import com.io.iona.core.data.annotations.OptionListKey;

public class PaperOLO {

	@OptionListKey
	private Long paperId;
	private String qualityName;
	private BigDecimal paperPrice;
	
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
