package com.userreg.model;

public class User {
	
	private String username;
	private String firstname;
	private String lastname;
	private String telephone;
	private String email;
	private String mobile;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
