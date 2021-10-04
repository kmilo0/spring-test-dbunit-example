package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.User;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	@DatabaseSetup("/users.xml")
	public void testFind() {
		Optional<User> user = this.userService.find(1);
		assertEquals("Nikola", user.get().getName());
		assertEquals("", user.get().getLastName());
	}

	@Test
	@DatabaseSetup("/users.xml")
	@ExpectedDatabase("/expectedUsers.xml")
	public void testRemove() {
		this.userService.remove(1);
	}

}
