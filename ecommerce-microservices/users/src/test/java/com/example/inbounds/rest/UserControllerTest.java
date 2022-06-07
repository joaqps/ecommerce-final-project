package com.example.inbounds.rest;

import com.example.domain.domain.User;
import com.example.domain_connectors.UserService;
import com.example.domain_connectors.mappers.UserDTOMapper;
import com.example.inbounds.rest.dtos.UserRequestDTO;
import org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests.MockMvcTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest extends MockMvcTest {

	@Mock
	UserService userService;
	UserDTOMapper mapper = Mappers.getMapper(UserDTOMapper.class);

	@Override
	protected String getUriRoot() {
		return "/users";
	}

	@Override
	protected Object buildController() {
		return new UserController(userService, mapper);
	}

	@Test
	void test_register() {

		UserRequestDTO dto = new UserRequestDTO();
		String payload = dtoToJson(dto);

		when(userService.save(any(), any())).thenReturn(User.builder().username("John").password("123456").build());

		final ResultActions response = performer().post("/", payload);

		buildAsserter(response).statusBodyJson(HttpStatus.CREATED, "{data:{'username':'John', 'password':'123456'}}");
	}

	@Test
	void test_register_exists() {

		UserRequestDTO dto = new UserRequestDTO();
		String payload = dtoToJson(dto);

		when(userService.save(any(), any())).thenThrow(new DuplicateKeyException(""));

		final ResultActions response = performer().post("/", payload);

		buildAsserter(response).status(HttpStatus.CONFLICT);
	}

	@Test
	void test_find_by_username() {

		UserRequestDTO dto = new UserRequestDTO();
		String payload = dtoToJson(dto);

		when(userService.findByUsername(any()))
				.thenReturn(Optional.of(User.builder().username("John").password("123456").build()));

		final ResultActions response = performer().get("/john");

		buildAsserter(response).statusBodyJson(HttpStatus.OK, "{data:{'username':'John', 'password':'123456'}}");
	}

	@Test
	void test_find_by_username_not_found() {

		UserRequestDTO dto = new UserRequestDTO();
		String payload = dtoToJson(dto);

		when(userService.findByUsername(any())).thenReturn(Optional.empty());

		final ResultActions response = performer().get("/john");

		buildAsserter(response).status(HttpStatus.NOT_FOUND);
	}
}