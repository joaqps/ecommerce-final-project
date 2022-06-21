package com.example.inbounds.rest.apidoc.users;

import com.example.inbounds.rest.apidoc.UsersApi;
import com.example.inbounds.rest.dtos.UserRequestDTO;
import com.example.inbounds.rest.dtos.UserResponseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = UsersApi.MAIN_PATH, produces = ApiDocCommons.MEDIATYPE_RESPONSE)
@UsersApi.UserCommand
public interface UsersCommandApi {

	@UsersApi.UserCommand
	ResponseEntity<SimpleResponseDto<UserResponseDTO>> register(@Parameter @RequestBody UserRequestDTO dto);
}
