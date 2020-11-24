package com.example.bookorder.models.dtos;

public class CustomerDto {

	private Long customerId;
	private String customerName;
	private String country;
	private String address;
	private String phoneNumber;
	private String postalCode;
	private String email;
	
	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(Long customerId, String customerName, String country, String address, String phoneNumber,
			String postalCode, String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.country = country;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
