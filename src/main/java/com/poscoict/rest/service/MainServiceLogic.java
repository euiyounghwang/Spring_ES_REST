package com.poscoict.rest.service;

import org.springframework.stereotype.Service;

@Service
public class MainServiceLogic implements MainService{

	@Override
	public String selectSample() {
		// TODO Auto-generated method stub
		return "hello" + ", " + "world" + "!";
	}
	
}
