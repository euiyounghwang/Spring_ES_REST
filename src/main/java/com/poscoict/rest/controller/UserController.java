package com.poscoict.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.rest.entity.User;
import com.poscoict.rest.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
//@Controller
@RequiredArgsConstructor
public class UserController {
	
	/*
	 * 
	 * Monolithic Architecture : 모든 업무로직을 하나의 어플리케이션 형태로 묶어 서비스 하는 형태
	 *  - User Interface, Business Logic, Data Access
	 * SOA : 이를 개선(Service Oriented Architecture) : 서비스 단위로 독립된 S/W 개발
	 * 3-4 ~
	 *   
	 */
	
	private final UserService userService;
	
	/*
	@RequestMapping(value = "/findAIServerLog", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAIServerLog(@RequestBody Map<String, Object> params)	{
		return monitoringService.findAIServerLog(params);
	}
	*/
	
	@PostMapping("/users")
//	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String register(@RequestBody User newUser) {
		return userService.register(newUser);
	}
	
	@GetMapping("/users/{id}")
	public User find(@PathVariable String id) {
//		System.out.println("find..");
		return userService.find(id);
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@PutMapping("/users")
	public void modify(@RequestBody User newUser) {
		userService.modify(newUser);
	}
	
	@DeleteMapping("/users/{id}")
	public void remove(@PathVariable String id) {
		userService.remove(id);
		
	}
}
