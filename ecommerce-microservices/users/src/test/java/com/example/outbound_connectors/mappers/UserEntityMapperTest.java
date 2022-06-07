package com.example.outbound_connectors.mappers;

import com.example.domain.domain.User;
import com.example.outbounds.mongo.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityMapperTest {

	UserEntityMapper mapper = Mappers.getMapper(UserEntityMapper.class);

	@Test
	void test_map_entity() {

		UserEntity entity = new UserEntity();
		entity.setId("1");
		entity.setUsername("John");
		entity.setPassword("123456");

		User vo = mapper.mapEntity(entity);

		assertEquals("1", vo.getId());
		assertEquals("John", vo.getUsername());
		assertEquals("123456", vo.getPassword());
	}

	@Test
	void test_map_vo() {

		User vo = new User();
		vo.setId("1");
		vo.setUsername("John");
		vo.setPassword("123456");

		UserEntity entity = mapper.mapVo(vo);

		assertEquals("1", entity.getId());
		assertEquals("John", entity.getUsername());
		assertEquals("123456", entity.getPassword());
	}
}