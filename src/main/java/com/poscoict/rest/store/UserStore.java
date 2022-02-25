package com.poscoict.rest.store;

import java.util.List;

import com.poscoict.rest.entity.User;

public interface UserStore {
	
	String create(User newUser);
	void update(User newUser);
	void delete(String id);
	
	User retrieve(String id);
	List<User> retrieveall();
}
