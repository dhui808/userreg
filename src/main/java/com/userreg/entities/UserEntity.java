package com.userreg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated User ID", name="id",required=false,value="user id")
	private Long id;
	@ApiModelProperty(notes = "The user name", name="username",required=true,value="username")
	private String username;
	@ApiModelProperty(notes = "The user first name", name="firstname",required=true,value="first name")
	private String firstname;
	@ApiModelProperty(notes = "The user last name", name="lastname",required=true,value="last name")
	private String lastname;
	@ApiModelProperty(notes = "The user telephone number", name="telephone",required=false,value="telephone number")
	private String telephone;
	@ApiModelProperty(notes = "The user email", name="email",required=false,value="email")
	private String email;
	@ApiModelProperty(notes = "The user mobile number", name="mobile",required=false,value="mobile number")
	private String mobile;
	@ApiModelProperty(notes = "The user address", name="address",required=true,value="user address")
	private String address;
	@ApiModelProperty(notes = "Password Hash", name="passwordhash",required=true,value="user password")
	private String passwordhash;
	
	public Long getId() {
		return id;
	}
	public void setId(Long userId) {
		this.id = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getPasswordhash() {
		return passwordhash;
	}
	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}
}
