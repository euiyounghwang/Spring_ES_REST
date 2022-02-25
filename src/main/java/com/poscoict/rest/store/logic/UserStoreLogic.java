package com.poscoict.rest.store.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.poscoict.rest.entity.User;
import com.poscoict.rest.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore {

	private Map<String, User> userMap;
	
	public UserStoreLogic() {
		// TODO Auto-generated constructor stub
		this.userMap = new HashMap<>();
	}
	
	@Override
	public String create(User newUser) {
		// TODO Auto-generated method stub
		this.userMap.put(newUser.getId(), newUser);
		return newUser.getId();
	}

	@Override
	public void update(User newUser) {
		// TODO Auto-generated method stub
		this.userMap.put(newUser.getId(), newUser);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.userMap.remove(id);
	}

	@Override
	public User retrieve(String id) {
		// TODO Auto-generated method stub
		return this.userMap.get(id);
	}

	@Override
	public List<User> retrieveall() {
		// TODO Auto-generated method stub
		
		return this.userMap.values().stream().collect(Collectors.toList());
	}

}
