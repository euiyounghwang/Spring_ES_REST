package com.poscoict.rest.service.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poscoict.rest.entity.User;
import com.poscoict.rest.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

@SpringBootTest
public class UserServiceLogicTest {
	
	// 생성자주입, lombok RequriedArgsConstructor X
	@Autowired
	private UserService userService;
	
	private User kim;
	private User lee;
	
	@BeforeEach
	public void startup() {
		this.kim = new User("kim", "kim@test");
		this.lee = new User("lee", "lee@test");
		this.userService.register(kim);
		this.userService.register(lee);
	}
	
	@Test
	public void registerTest() {
		
		User sample = User.sample();
		assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
		assertThat(this.userService.findAll().size()).isEqualTo(3);
		
		// 삭제
		this.userService.remove(sample.getId());
	}
	
	@Test
	public void find() {
		assertThat(this.userService.find(this.kim.getId())).isNotNull();
		assertThat(this.userService.find(this.kim.getId()).getEmail()).isEqualTo(this.kim.getEmail());
	}
	
	@AfterEach
	public void cleanup() {
		this.userService.remove(kim.getId());
		this.userService.remove(lee.getId());
	}

}
