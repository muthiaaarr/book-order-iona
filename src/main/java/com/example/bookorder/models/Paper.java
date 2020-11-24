package com.example.bookorder.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "paper")
public class Paper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2235824075281363998L;
	
	// ATTRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_paper_paper_id_seq")
	@SequenceGenerator(name = "generator_paper_paper_id_seq", sequenceName = "paper_paper_id_seq", schema = "public", allocationSize = 1)
	@Column(name = "paper_id", unique = true)
	private Long paperId;
	
	@Column(name = "quality_name", nullable = false)
	private String qualityName;
	
	@Column(name = "price", nullable = false)
	private BigDecimal paperPrice;
	
	// ONE TO MANY PAPER-PUBLISHER
	@OneToMany(mappedBy = "paper", cascade = CascadeType.ALL)
	Set<Publisher> publishers;
	 
	// CONSTRUCTOR
	public Paper() {
		// TODO Auto-generated constructor stub
	}

	public Paper(Long paperId, String qualityName, BigDecimal paperPrice, Set<Publisher> publishers) {
		super();
		this.paperId = paperId;
		this.qualityName = qualityName;
		this.paperPrice = paperPrice;
		this.publishers = publishers;
	}

	// GETTER & SETTER
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

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}
	 
	 
}
