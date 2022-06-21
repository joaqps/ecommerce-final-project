//package com.example.inbounds.web;
//
//import com.example.commons.uri.UriResolver;
//import com.example.commons.uri.UsersUriResolver;
//import com.example.domain_connectors.LoginService;
//import com.example.inbounds.rest.dtos.UserResponseDTO;
//import com.example.inbounds.web.dtos.LoginRequestDTO;
//import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocInsert;
//import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
//import org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests.MockMvcTest;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.RestTemplate;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class LoginWebControllerTest extends MockMvcTest {
//
//	UriResolver uriResolver = new UsersUriResolver();
//
//	@Mock
//	RestTemplate restTemplate;
//	@Mock
//	LoginService loginService;
//	@Mock
//	PasswordEncoder passwordEncoder;
//
//	@Override
//	protected String getUriRoot() {
//		return "/auth";
//	}
//
//	@Override
//	protected Object buildController() {
//		return new LoginWebController(restTemplate, loginService, passwordEncoder);
//	}
//
//	@Test
//	void test_login_path() {
//
//		final ResultActions responseLogin = performer().get("/login-success");
//
//		buildAsserter(responseLogin).status(HttpStatus.FOUND);
//
//		final ResultActions responseLogout = performer().get("/logout-success");
//
//		buildAsserter(responseLogout).status(HttpStatus.FOUND);
//	}
//
//	@Test
//	void test_register() {
//
//		HttpEntity<LoginRequestDTO> request = new HttpEntity<>(new LoginRequestDTO("juan", null));
//
//		when(restTemplate.exchange(uriResolver.getRestUri(), HttpMethod.POST, request,
//				new ParameterizedTypeReference<SimpleResponseDto<UserResponseDTO>>() {
//				})).thenReturn(SimpleResponseDto.success(ApiDocInsert.Response.Success.SC, new UserResponseDTO()));
//
//		final ResultActions response = performer().post("/register", dtoToJson(request.getBody()));
//
//		buildAsserter(response).statusBodyJson(HttpStatus.OK, "{'successful':true}");
//	}
//
//	@Test
//	void test_register_duplicate() {
//
//		HttpEntity<LoginRequestDTO> request = new HttpEntity<>(new LoginRequestDTO("juan", null));
//
//		when(restTemplate.exchange(uriResolver.getRestUri(), HttpMethod.POST, request,
//				new ParameterizedTypeReference<SimpleResponseDto<UserResponseDTO>>() {
//				})).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
//
//		final ResultActions response = performer().post("/register", dtoToJson(request.getBody()));
//
//		buildAsserter(response).statusBodyJson(HttpStatus.OK, "{'successful':false}");
//	}
//}