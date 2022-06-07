package com.example.inbounds.web;

import com.example.commons.uri.UriResolver;
import com.example.commons.uri.UsersUriResolver;
import com.example.domain_connectors.LoginService;
import com.example.inbounds.rest.dtos.UserResponseDTO;
import com.example.inbounds.web.dtos.AlertDTO;
import com.example.inbounds.web.dtos.LoginRequestDTO;
import com.example.inbounds.web.dtos.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginWebController {

	private final Logger logger = LoggerFactory.getLogger(LoginWebController.class);

	private final RestTemplate restTemplate;
	private final LoginService loginService;
	private final PasswordEncoder passwordEncoder;
	private final UriResolver uriResolver = new UsersUriResolver();

	@GetMapping("/login")
	public String getLoginPage(final Model model) {
		return "login";
	}

	@GetMapping("/register")
	public String getRegisterPage(final Model model) {
		return "register";
	}

	@GetMapping("/login-success")
	public String getLoginSuccessPage(final Model model, final RedirectAttributes attributes) {

		attributes.addFlashAttribute("alert", new AlertDTO("success", "User was logged in successfully."));
		return "redirect:/ecommerce/brands";
	}

	@GetMapping("/logout-success")
	public String getLogoutSuccessPage(final Model model, final RedirectAttributes attributes) {

		attributes.addFlashAttribute("alert", new AlertDTO("success", "User was logged out successfully."));
		return "redirect:/auth/login";
	}

	@PostMapping(value = "/register", produces = "application/json")
	@ResponseBody
	public ResponseEntity<LoginResponseDTO> register(final @RequestBody LoginRequestDTO loginRequest) {

		HttpEntity<LoginRequestDTO> request = new HttpEntity<>(
				new LoginRequestDTO(loginRequest.getUsername(), passwordEncoder.encode(loginRequest.getPassword())));

		try {
			ResponseEntity<SimpleResponseDto<UserResponseDTO>> response = restTemplate
					.exchange(uriResolver.getRestUri(), HttpMethod.POST, request, new ParameterizedTypeReference<>() {
					});
		} catch (HttpClientErrorException ex) {
			return ResponseEntity.ok(new LoginResponseDTO(false, "Username already exists."));
		}

		return ResponseEntity.ok(new LoginResponseDTO(true, "User was registered successfully."));
	}

	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponseDTO> login(HttpServletResponse response, @RequestParam String username,
			@RequestParam String password) {

		try {
			Cookie loginCookie = loginService.login(username, password);
			response.addCookie(loginCookie);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.ok(new LoginResponseDTO(false, "Incorrect username or password."));
		}

		return ResponseEntity.ok(new LoginResponseDTO(true, "Login successful."));
	}
}
