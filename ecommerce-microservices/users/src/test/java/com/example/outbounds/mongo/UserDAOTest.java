package com.example.outbounds.mongo;

import com.example.domain.domain.User;
import com.example.outbound_connectors.mappers.UserEntityMapperImpl;
import com.example.outbounds.mongo.entities.UserEntity;
import com.example.outbounds.mongo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDAOTest {

	@Mock
	UserRepository repository;
	@Mock
	UserEntityMapperImpl mapper;
	@InjectMocks
	UserDAOImpl userDAO;

	@Test
	void test_find_by_username() {

		when(repository.findByUsername(any())).thenReturn(Optional.of(new UserEntity("1", "John", "123456")));
		when(mapper.mapEntity(any())).thenCallRealMethod();

		Optional<User> entity = userDAO.findByUsername("");

		assertTrue(entity.isPresent());
		assertEquals("1", entity.get().getId());
	}

	@Test
	void test_save() {

		when(repository.save(any())).thenReturn(new UserEntity("1", "John", "123456"));
		when(mapper.mapEntity(any())).thenCallRealMethod();

		User user = userDAO.save(new User());

		assertEquals("1", user.getId());
		assertEquals("John", user.getUsername());
		assertEquals("123456", user.getPassword());
	}
}