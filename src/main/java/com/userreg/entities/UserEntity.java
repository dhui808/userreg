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
	@ApiModelProperty(notes = "The database generated User ID", name="userId",required=false,value="user id")
	private Long userId;
	@ApiModelProperty(notes = "The user name", name="userName",required=true,value="username")
	private String userName;
	@ApiModelProperty(notes = "The user first name", name="firstName",required=true,value="first name")
	private String firstName;
	@ApiModelProperty(notes = "The user last name", name="lastName",required=true,value="last name")
	private String lastName;
	@ApiModelProperty(notes = "The user telephone number", name="telephone",required=false,value="telephone number")
	private String telephone;
	@ApiModelProperty(notes = "The user email", name="email",required=false,value="email")
	private String email;
	@ApiModelProperty(notes = "The user mobile number", name="mobile",required=false,value="mobile number")
	private String mobile;
	@ApiModelProperty(notes = "The user address", name="address",required=true,value="user address")
	private String address;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
