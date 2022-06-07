package com.example.inbounds.rest;

import com.example.domain.domain.User;
import com.example.domain_connectors.UserService;
import com.example.domain_connectors.mappers.UserDTOMapper;
import com.example.inbounds.rest.apidoc.users.UsersCommandApi;
import com.example.inbounds.rest.dtos.UserRequestDTO;
import com.example.inbounds.rest.dtos.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocInsert;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query.ApiDocFindById;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersCommandApi {

	private final UserService userService;
	private final UserDTOMapper mapper;

	@PostMapping
	public ResponseEntity<SimpleResponseDto<UserResponseDTO>> register(UserRequestDTO dto) {

		try {
			User savedUser = userService.save(dto.getUsername(), dto.getPassword());
			return SimpleResponseDto.success(ApiDocInsert.Response.Success.SC, mapper.mapResponse(savedUser));
		} catch (DuplicateKeyException ex) {
			return SimpleResponseDto.error(ApiDocInsert.Response.Conflict.SC, "Username already exists.");
		}
	}

	@GetMapping("/{username}")
	public ResponseEntity<SimpleResponseDto<UserResponseDTO>> findByUsername(@PathVariable String username) {

		Optional<User> savedUser = userService.findByUsername(username);

		if (savedUser.isPresent()) {
			return SimpleResponseDto.success(ApiDocFindById.Response.Success.SC, mapper.mapResponse(savedUser.get()));
		}
		return SimpleResponseDto.error(ApiDocFindById.Response.NotFound.SC, "Username does not exist.");
	}
}
