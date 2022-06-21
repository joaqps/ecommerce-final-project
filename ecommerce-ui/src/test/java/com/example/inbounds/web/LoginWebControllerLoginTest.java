//package com.example.inbounds.web;
//
//import com.example.domain_connectors.LoginService;
//import org.greyhawk.rest.server.testutils.inbounds.rest.controllers.mockmvc.MockMvcPerformer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.client.RestTemplate;
//
//import javax.servlet.http.Cookie;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class LoginWebControllerLoginTest {
//
//	@Mock
//	RestTemplate restTemplate;
//	@Mock
//	LoginService loginService;
//	@Mock
//	PasswordEncoder passwordEncoder;
//
//	MockMvc mockMvcTest;
//	MockMvcPerformer performer;
//
//	@BeforeEach
//	public void setup() {
//		mockMvcTest = MockMvcBuilders
//				.standaloneSetup(new LoginWebController(restTemplate, loginService, passwordEncoder)).build();
//		performer = new MockMvcPerformer(mockMvcTest, "/auth",
//				Map.ofEntries(Map.entry("Content-Type", MediaType.APPLICATION_JSON_VALUE),
//						Map.entry("Accept", MediaType.APPLICATION_JSON_VALUE)));
//	}
//
//	@Test
//	void test_login() throws Exception {
//
//		when(loginService.login(any(), any())).thenReturn(new Cookie("cookie", "cookie"));
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/login").param("username", "juan")
//				.param("password", "123456");
//
//		MockHttpServletResponse response = mockMvcTest.perform(requestBuilder).andReturn().getResponse();
//
//		assertNotNull(response);
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
//	}
//
//	@Test
//	void test_login_not_found() throws Exception {
//
//		when(loginService.login(any(), any())).thenThrow(new BadCredentialsException("bad"));
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/login").param("username", "juan")
//				.param("password", "123456");
//
//		MockHttpServletResponse response = mockMvcTest.perform(requestBuilder).andReturn().getResponse();
//
//		assertNotNull(response);
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
//	}
//}