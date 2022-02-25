package com.poscoict.rest.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poscoict.rest.entity.User;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc movMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
	}

	@AfterEach
	void tearDownAfterClass() throws Exception {
	}

	@Test
	void testRegister() throws Exception {
		User sample = User.sample();
		String content = objectMapper.writeValueAsString(sample);
		movMvc.perform(post("/users")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
		     .andExpect((ResultMatcher) MockRestRequestMatchers.content().string(sample.getId()))
		     .andExpect((ResultMatcher) print());
		     
	}

	@Test
	void testFind() {
		
	}

	@Test
	void testFindAll() {
		
	}

	@Test
	void testModify() {
		
	}

	@Test
	void testRemove() {
		
	}

	@Test
	void testUserController() {
		
	}

}
