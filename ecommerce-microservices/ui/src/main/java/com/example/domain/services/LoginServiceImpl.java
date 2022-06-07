package com.example.domain.services;

import com.example.commons.security.JwtTokenProvider;
import com.example.domain_connectors.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

import static com.example.commons.security.JwtFilter.JWT_TOKEN;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

	private final AuthenticationManager authManager;
	private final JwtTokenProvider jwtTokenProvider;

	@Override
	public Cookie login(String username, String password) {

		Authentication authDTO = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authManager.authenticate(authDTO);

		String token = jwtTokenProvider.generateToken(authentication);

		return generateLoginCookie(token);
	}

	private Cookie generateLoginCookie(String token) {

		Cookie cookie = new Cookie(JWT_TOKEN, token);
		cookie.setMaxAge(86400);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setPath("/");

		return cookie;
	}
}
