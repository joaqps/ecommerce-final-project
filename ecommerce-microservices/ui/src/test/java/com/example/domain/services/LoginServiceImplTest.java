package com.example.domain.services;

import com.example.commons.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.Cookie;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplTest {

	@Mock
	AuthenticationManager authManager;
	@Mock
	JwtTokenProvider jwtTokenProvider;
	@InjectMocks
	LoginServiceImpl loginService;

	@Test
	void test_login() {

		when(authManager.authenticate(any())).thenReturn(new UsernamePasswordAuthenticationToken("juan", "123456"));
		when(jwtTokenProvider.generateToken(any())).thenReturn("token");

		Cookie cookie = loginService.login("juan", "123456");

		assertEquals("token", cookie.getValue());
	}
}