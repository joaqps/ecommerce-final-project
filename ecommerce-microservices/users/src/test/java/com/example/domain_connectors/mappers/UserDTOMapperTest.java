package com.example.domain_connectors.mappers;

import com.example.domain.domain.User;
import com.example.inbounds.rest.dtos.UserRequestDTO;
import com.example.inbounds.rest.dtos.UserResponseDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOMapperTest {

	UserDTOMapper mapper = Mappers.getMapper(UserDTOMapper.class);

	@Test
	void test_mapper_response() {

		User user = new User();
		user.setUsername("John");
		user.setPassword("123456");

		UserResponseDTO dto = mapper.mapResponse(user);

		assertEquals("John", dto.getUsername());
		assertEquals("123456", dto.getPassword());
	}

	@Test
	void test_mapper_request() {

		UserRequestDTO user = new UserRequestDTO();
		user.setUsername("John");
		user.setPassword("123456");

		User vo = mapper.mapRequest(user);

		assertEquals("John", vo.getUsername());
		assertEquals("123456", vo.getPassword());
	}

}