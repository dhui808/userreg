package com.userreg.model;

import java.util.List;

public class UsersRetrieveResponse extends AbstractResponse {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
