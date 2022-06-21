//package com.example.commons.security;
//
//import com.example.commons.uri.UriResolver;
//import com.example.commons.uri.UsersUriResolver;
//import com.example.inbounds.rest.dtos.UserResponseDTO;
//import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query.ApiDocFindById;
//import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.RestTemplate;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class CustomUserDetailsServiceTest {
//
//	UriResolver uriResolver = new UsersUriResolver();
//
//	@Mock
//	RestTemplate restTemplate;
//	@InjectMocks
//	CustomUserDetailsService userDetailsService;
//
//	@Test
//	void test_load_by_username() {
//
//		ResponseEntity<SimpleResponseDto<UserResponseDTO>> response = SimpleResponseDto
//				.success(ApiDocFindById.Response.Success.SC, new UserResponseDTO("juan@email.com", "123456"));
//
//		when(restTemplate.exchange(uriResolver.getRestUri() + "/juan@email.com", HttpMethod.GET, null,
//				new ParameterizedTypeReference<SimpleResponseDto<UserResponseDTO>>() {
//				})).thenReturn(response);
//
//		UserDetails userDetails = userDetailsService.loadUserByUsername("juan@email.com");
//
//		assertEquals("juan@email.com", userDetails.getUsername());
//		assertEquals("123456", userDetails.getPassword());
//	}
//
//	@Test
//	void test_load_by_username_not_found() {
//
//		ResponseEntity<SimpleResponseDto<UserResponseDTO>> response = SimpleResponseDto
//				.success(ApiDocFindById.Response.Success.SC, new UserResponseDTO("juan@email.com", "123456"));
//
//		when(restTemplate.exchange(uriResolver.getRestUri() + "/juan@email.com", HttpMethod.GET, null,
//				new ParameterizedTypeReference<SimpleResponseDto<UserResponseDTO>>() {
//				})).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
//
//		assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("juan@email.com"));
//	}
//}