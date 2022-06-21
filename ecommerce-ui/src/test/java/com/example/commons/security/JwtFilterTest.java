//package com.example.commons.security;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class JwtFilterTest {
//
//	@Mock
//	JwtTokenProvider tokenProvider;
//	@Mock
//	UserDetailsService userService;
//	@InjectMocks
//	JwtFilter jwtFilter;
//
//	@Mock
//	HttpServletRequest request;
//	@Mock
//	HttpServletResponse response;
//	@Mock
//	FilterChain filterChain;
//
//	@Test
//	void test_filter() throws ServletException, IOException {
//
//		when(tokenProvider.isValidToken(any())).thenReturn(true);
//		when(userService.loadUserByUsername(any()))
//				.thenReturn(User.builder().username("juan").password("123456").authorities("authorities").build());
//
//		jwtFilter.doFilterInternal(request, response, filterChain);
//
//		verify(tokenProvider).getUsernameFromToken(any());
//		verify(userService).loadUserByUsername(any());
//	}
//}