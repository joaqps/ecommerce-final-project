package com.example.commons.security;

import com.example.domain.User;
import io.jsonwebtoken.MalformedJwtException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenProviderTest {

	private String token = "";

	JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

	@BeforeEach
	void setValues() {

		ReflectionTestUtils.setField(jwtTokenProvider, "jwtSecret",
				"K3lF7QAspsGG09mbIaryP3jtRkkxC5pwTV6BtM4kU5EXYRDEkMM9dUdjlpjPrEWYM");
		ReflectionTestUtils.setField(jwtTokenProvider, "jwtDurationSeconds", 86400L);

		Authentication auth = new UsernamePasswordAuthenticationToken(User.builder().username("juan").build(),
				"123456");
		token = jwtTokenProvider.generateToken(auth);
	}

	@Test
	void test_generate_token() {

		Authentication auth = new UsernamePasswordAuthenticationToken(User.builder().username("juan").build(),
				"123456");
		String token = jwtTokenProvider.generateToken(auth);

		assertNotNull(token);
	}

	@Test
	void test_is_valid_token() {

		assertFalse(jwtTokenProvider.isValidToken(""));
		assertTrue(jwtTokenProvider.isValidToken(token));
		assertThrows(MalformedJwtException.class, () -> jwtTokenProvider.isValidToken("1"));
		assertThrows(MalformedJwtException.class,
				() -> jwtTokenProvider.isValidToken(token.substring(10) + token.substring(0, 9)));
	}

	@Test
	void test_get_username() {

		String username = jwtTokenProvider.getUsernameFromToken(token);

		assertEquals("juan", username);
	}
}