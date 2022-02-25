package com.poscoict.rest.service;

import java.util.List;

import com.poscoict.rest.entity.User;

public interface UserService {
	String register(User newUser);
	void modify(User newUser);
	void remove(String id);
	
	User find(String id);
	List<User> findAll();
}
