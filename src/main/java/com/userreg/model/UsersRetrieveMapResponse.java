package com.userreg.model;

import java.util.List;
import java.util.Map;

public class UsersRetrieveMapResponse extends AbstractResponse {

	// returns the user list as a list of maps.
	private List<Map<String, String>> users;

	public List<Map<String, String>> getUsers() {
		return users;
	}

	public void setUsers(List<Map<String, String>> users) {
		this.users = users;
	}
}
