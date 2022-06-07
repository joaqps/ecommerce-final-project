package com.example.domain.services;

import com.example.domain.domain.User;
import com.example.outbound_connectors.UserDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	UserDAO userDAO;
	@InjectMocks
	UserServiceImpl userService;

	@Test
	void test_find_by_username() {

		userService.findByUsername("John");

		verify(userDAO).findByUsername("John");
	}

	@Test
	void saveUser() {

		User user = new User();
		user.setUsername("John");
		user.setPassword("123456");

		userService.save("John", "123456");

		verify(userDAO).save(user);
	}
}