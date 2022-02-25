package com.poscoict.rest.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.rest.entity.User;
import com.poscoict.rest.service.UserService;
import com.poscoict.rest.store.UserStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceLogic implements UserService {
	
//	@Autowired
//	private UserStore userStore;
	
//	private UserStore userStore;
//	public UserServiceLogic(UserStore userStore) {
//		// TODO Auto-generated constructor stub
//		this.userStore = userStore;
//	}
	
	private final UserStore userStore;

	@Override
	public String register(User newUser) {
		// TODO Auto-generated method stub
		return this.userStore.create(newUser);
	}

	@Override
	public void modify(User newUser) {
		// TODO Auto-generated method stub
		this.userStore.update(newUser);
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		this.userStore.delete(id);
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return this.userStore.retrieve(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userStore.retrieveall();
	}

}
